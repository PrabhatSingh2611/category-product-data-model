package com.category.category.product.Service;

import com.category.category.product.Entity.ProductEntity;
import com.category.category.product.Exception.DataNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {

    ProductEntity findById(Long id) throws DataNotFoundException;

    ProductEntity getProductByName(String name);

    ProductEntity getProductByPrice(double price);

    List<ProductEntity> getAllProducts();

    Page<ProductEntity> getProductByPaginationAndSorting(int offset, int pagesize, String field);

    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> createProducts(List<ProductEntity> products);

    ProductEntity updateProduct( ProductEntity newProduct);

    String deleteProductById(Long idToBeDeleted);


}
