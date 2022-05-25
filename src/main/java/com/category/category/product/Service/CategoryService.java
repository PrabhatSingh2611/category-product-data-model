package com.category.category.product.Service;

import com.category.category.product.Entity.CategoryEntity;
import com.category.category.product.Exception.DataNotFoundException;;

import java.util.List;

public interface CategoryService {

    CategoryEntity findById(Long id) throws DataNotFoundException;

    CategoryEntity getCategoryByName(String name);

    List<CategoryEntity> getAllCategories();

    CategoryEntity createCategory(CategoryEntity category);

    List<CategoryEntity> createCategories(List<CategoryEntity> categories);

    CategoryEntity updateCategory(CategoryEntity newCategory);

    String deleteCategoryById(Long categoryIdToBeDeleted);


}
