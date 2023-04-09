package com.thanh.ThiTA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.ThiTA.model.Category;
import com.thanh.ThiTA.service.CategoryService;

@RestController
@RequestMapping(path = "/api/category")
@CrossOrigin()
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/list-categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping(path = "/add-category")
    public int addCategory(@RequestBody Category category){
        return categoryService.addCategory(category.getCategoryName(), category.getDescription(), category.getPicture());
    }

    @PutMapping(path = "/edit-category")
    public int editCategory(@RequestBody Category category){
        return categoryService.editCategory(category);
    }

    @DeleteMapping(path = "/delete-category/{categoryId}")
    public int deleteCategory(@PathVariable int categoryId){
        return categoryService.deleteCategory(categoryId);
    }
}
