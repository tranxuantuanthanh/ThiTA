package com.thanh.ThiTA.repository.Category;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thanh.ThiTA.entity.Category;

@Repository
public class CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories() {
        return jdbcTemplate.query("Select * from category;", new CategoryRowMapper());
    }

    public List<Category> findCategories(String searchValue) {
        String sql = "SELECT * FROM `category` WHERE categoryName COLLATE UTF8_GENERAL_CI LIKE ? or description COLLATE UTF8_GENERAL_CI LIKE ?;";
        return jdbcTemplate.query(sql,
                new Object[]{'%' + searchValue + '%', '%' + searchValue + '%'},
                new int[]{Types.VARCHAR, Types.VARCHAR},
                new CategoryRowMapper());
    }

    public int addCategory(String categoryName, String description, String picture) {
        String sql = "insert into category(categoryName, description, picture) values (?,?,?)";
        return jdbcTemplate.update(sql, categoryName, description, picture);
    }

    public int editCategory(Category category) {
        String sql = "update category set categoryName = ?, description = ?, picture = ? where categoryId = ? and (categoryName <> ? or description <> ? or picture <> ?)";
        return jdbcTemplate.update(sql,
                category.getCategoryName(),
                category.getDescription(),
                category.getPicture(),
                category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription(),
                category.getPicture());
    }

    public int deleteCategory(int categoryId) {
        return jdbcTemplate.update("delete from category where categoryId = ?", categoryId);
    }
}
