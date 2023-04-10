package com.thanh.ThiTA.service.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanh.ThiTA.entity.Category;
import com.thanh.ThiTA.exception.NotFoundException;
import com.thanh.ThiTA.repository.Category.CategoryRepository;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public List<Category> findCategories(String searchValue) {
        List<Category> list = categoryRepository.findCategories(searchValue);
        if(list.size()> 0) return list;
        throw new NotFoundException("Not Founded");
    }

    @Override
    public int addCategory(String categoryName, String description, String picture) {
        int count = categoryRepository.addCategory(categoryName, description, picture);
        return count;
    }

    @Override
    public int editCategory(Category category) {
        int count = categoryRepository.editCategory(category);
        return count;
    }

    @Override
    public int deleteCategory(int categoryId) {
        int count = categoryRepository.deleteCategory(categoryId);
        return count;
    }

}
