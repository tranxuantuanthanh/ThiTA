package com.thanh.ThiTA.service.Category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thanh.ThiTA.entity.Category;

@Service
public interface CategoryService {
    public List<Category> getAllCategories();

    public List<Category> findCategories(String searchValue);

    public int addCategory(String categoryName, String description, String picture);

    public int editCategory(Category category);

    public int deleteCategory(int categoryId);
}
