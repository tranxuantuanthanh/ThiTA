package com.thanh.ThiTA.repository.Category;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thanh.ThiTA.entity.Category;

@Repository
public class CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories(){
        List<Category> listCategories = new ArrayList<>();
        listCategories = jdbcTemplate.query("Select * from category;", new CategoryRowMapper());
        return listCategories;
    }

    public List<Category> findCategories(String searchValue){
        List<Category> listCategories = new ArrayList<>();
        listCategories = jdbcTemplate.query("SELECT * FROM `category` WHERE categoryName COLLATE UTF8_GENERAL_CI LIKE ? or description COLLATE UTF8_GENERAL_CI LIKE ?;",
                                            new Object[]{'%'+searchValue+'%','%'+searchValue+'%'}, 
                                            new int[]{Types.VARCHAR, Types.VARCHAR}, 
                                            new CategoryRowMapper());
        return listCategories;
    }

    public int addCategory(String categoryName, String description, String picture){
        return jdbcTemplate.update("insert into category(categoryName, description, picture) values (?,?,?)", categoryName, description, picture);
    }

    public int editCategory(Category category){
        return jdbcTemplate.update("update category set categoryName = ?, description = ?, picture = ? where categoryId = ? and (categoryName <> ? or description <> ? or picture <> ?)",
                                        category.getCategoryName(),
                                        category.getDescription(),
                                        category.getPicture(),
                                        category.getCategoryId(),
                                        category.getCategoryName(),
                                        category.getDescription(),
                                        category.getPicture());
    }

    public int deleteCategory(int categoryId){
        return jdbcTemplate.update("delete from category where categoryId = ?", categoryId);
    }
}
