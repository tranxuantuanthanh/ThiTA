package com.thanh.ThiTA.service.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.thanh.ThiTA.model.Category;

public class CategoryNameRowMapper implements RowMapper<Category>{

    @Override
    @Nullable
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setCategoryId(rs.getInt(1));
        category.setCategoryName(rs.getString(2));
        return category;
    }
}
