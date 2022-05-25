package com.category.category.product.Controller;

import com.category.category.product.Entity.CategoryEntity;
import com.category.category.product.Exception.DataNotFoundException;
import com.category.category.product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/category/")
public class CategoryController {

    @Autowired
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public CategoryEntity findById(@PathVariable Long id) throws DataNotFoundException {
        return service.findById(id);
    }

    @GetMapping(path = "{name}")
    public CategoryEntity getCategoryByName(@PathVariable String name) {
        return service.getCategoryByName(name);
    }

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return service.getAllCategories();
    }

    @PostMapping(path = "/createCategory")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return service.createCategory(category);
    }

    @PostMapping(path = "/createCategories")
    public List<CategoryEntity> createCategories(@RequestBody List<CategoryEntity> categories) {
        return service.createCategories(categories);
    }

    @PutMapping(path = "/updateCategory")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity newCategory) {
        return service.updateCategory(newCategory);
    }

    @DeleteMapping(path = "/deleteCategory")
    public String deleteCategoryById(Long id) {
        return service.deleteCategoryById(id);
    }

}
