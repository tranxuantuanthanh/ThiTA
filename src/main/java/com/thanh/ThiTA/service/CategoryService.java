package com.thanh.ThiTA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thanh.ThiTA.model.Category;
import com.thanh.ThiTA.service.RowMapper.CategoryRowMapper;

@Repository
public class CategoryService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories(){
        List<Category> listCategories = new ArrayList<>();
        listCategories = jdbcTemplate.query("Select * from category;", new CategoryRowMapper());
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
