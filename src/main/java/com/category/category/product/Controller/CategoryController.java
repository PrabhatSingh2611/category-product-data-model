package com.category.category.product.Controller;

import com.category.category.product.Entity.CategoryEntity;
import com.category.category.product.Exception.DataNotFoundException;
import com.category.category.product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping(path = "/byId/{id}")
    public CategoryEntity findById(@PathVariable Long id) throws DataNotFoundException {
        return service.findById(id);
    }

    @GetMapping(path = "/byName/{name}")
    public CategoryEntity getCategoryByName(@PathVariable String name) {
        return service.getCategoryByName(name);
    }

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/paginationAndSort/{offset}/{pagesize}/{field}")
    public Page<CategoryEntity> getCategoryByPaginationAndSorting(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
        Page<CategoryEntity> categories = service.getCategoryByPaginationAndSorting(offset, pagesize, field);
        return categories;
    }

    @PostMapping(path = "/createCategory")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return service.createCategory(category);
    }

    @PostMapping(path = "/createCategories")
    public List<CategoryEntity> createCategories(@RequestBody List<CategoryEntity> categories) {
        return service.createCategories(categories);
    }

    @PutMapping(path = "/updateCategory/{id}")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity newCategory) {
        return service.updateCategory(newCategory);
    }

    @DeleteMapping(path = "/deleteCategory/{id}")
    public String deleteCategoryById(Long id) {
        return service.deleteCategoryById(id);
    }

}
