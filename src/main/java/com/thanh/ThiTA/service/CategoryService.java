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
}
