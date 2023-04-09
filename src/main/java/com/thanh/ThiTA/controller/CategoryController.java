package com.thanh.ThiTA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.ThiTA.model.Category;
import com.thanh.ThiTA.service.CategoryService;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/list-categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
