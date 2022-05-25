package com.category.category.product.Controller;

import com.category.category.product.Entity.ProductEntity;
import com.category.category.product.Exception.DataNotFoundException;
import com.category.category.product.Service.ProductService;
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
@RequestMapping(path = "api")
public class ProductController {

    @Autowired
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/byId/{id}")
    public ProductEntity findById(@PathVariable Long id) throws DataNotFoundException {
        return service.findById(id);
    }

    @GetMapping("/byName/{name}")
    public ProductEntity getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @GetMapping("/byPrice/{price}")
    public ProductEntity getProductByPrice(double price) {
        return service.getProductByPrice(price);
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/createProduct")
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return service.createProduct(product);
    }

    @PostMapping(path = "/createProducts")
    public List<ProductEntity> createProducts(@RequestBody List<ProductEntity> products) {
        return service.createProducts(products);
    }

    @PutMapping(path = "/updateProduct")
    public ProductEntity updateProduct(@RequestBody ProductEntity newProduct) {
        return service.updateProduct(newProduct);
    }

    @DeleteMapping(path = "/deleteMapping")
    public String deleteCategoryById(Long id) {
        return service.deleteProductById(id);
    }

}
