package com.thanh.ThiTA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.ThiTA.entity.Category;
import com.thanh.ThiTA.service.Category.CategoryService;

@RestController
@RequestMapping(path = "/api/category")
@CrossOrigin()
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/list")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/search")
    public ResponseEntity<?> findCategories(@RequestParam(name = "keyword", required = false, defaultValue = "") String value) {
        return ResponseEntity.ok(categoryService.findCategories(value));
    }

    @PostMapping(path = "/add")
    public int addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category.getCategoryName(), category.getDescription(), category.getPicture());
    }

    @PutMapping(path = "/edit/{id}")
    public int editCategory(@PathVariable int id,@RequestBody Category category) {
        category.setCategoryId(id);
        return categoryService.editCategory(category);
    }

    @DeleteMapping(path = "/delete/{id}")
    public int deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }
}
