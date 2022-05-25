package com.category.category.product.Service.ServiceImpl;

import com.category.category.product.Entity.ProductEntity;
import com.category.category.product.Exception.DataNotFoundException;
import com.category.category.product.Repository.ProductRepository;
import com.category.category.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity findById(Long id) throws DataNotFoundException {
        if (Optional.ofNullable(id).isPresent()) {
            return repository.findById(id).orElseThrow(
                    () -> new DataNotFoundException("product not found for : " + id)
            );
        } else
            return null;    }

    @Override
    public ProductEntity getProductByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public ProductEntity getProductByPrice(double price) {
        return repository.findByPrice(price);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return repository.save(product);
    }

    @Override
    public List<ProductEntity> createProducts(List<ProductEntity> products) {
        return repository.saveAll(products);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity newProduct) {
        ProductEntity existingProduct = repository.findById((long) newProduct.getId()).orElse(null);
        existingProduct.setName(newProduct.getName());
        existingProduct.setQuantity(newProduct.getQuantity());
        existingProduct.setPrice(newProduct.getPrice());
        return repository.save(existingProduct);
    }

    @Override
    public String deleteProductById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Product not found");
        }
        return "Product Deleted Successfully" + id;
    }
}
