package com.category.category.product.Service.ServiceImpl;


import com.category.category.product.Entity.CategoryEntity;
import com.category.category.product.Exception.DataNotFoundException;
import com.category.category.product.Repository.CategoryRepository;
import com.category.category.product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public CategoryEntity findById(Long id) throws DataNotFoundException {
        if (Optional.ofNullable(id).isPresent()) {
            return repository.findById(id).orElseThrow(
                    () -> new DataNotFoundException("category not found for : " + id)
            );
        } else
            return null;
    }

    @Override
    public CategoryEntity getCategoryByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Page<CategoryEntity> getCategoryByPaginationAndSorting(int offset, int pagesize, String field) {
        Page<CategoryEntity> categories = repository.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(Sort.Direction.ASC, field)));
        return categories;
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        return repository.save(category);
    }

    @Override
    public List<CategoryEntity> createCategories(List<CategoryEntity> categories) {
        return repository.saveAll(categories);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity newCategory) {
        CategoryEntity existingCategory = repository.findById((long) newCategory.getId()).orElse(null);
        existingCategory.setName(newCategory.getName());
        return repository.save(existingCategory);
    }

    @Override
    public String deleteCategoryById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Category not found");
        }
        return "Category Deleted Successfully" + id;
    }
}
