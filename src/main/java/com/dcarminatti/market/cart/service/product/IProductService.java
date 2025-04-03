package com.dcarminatti.market.cart.service.product;

import com.dcarminatti.market.cart.model.Product;
import com.dcarminatti.market.cart.request.product.AddProductRequest;
import com.dcarminatti.market.cart.request.product.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);
    List<Product> getProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByCategoryAndName(String category, String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Product getProductById(Long id);
    Product updateProduct(Long id, ProductUpdateRequest product);
    void deleteProduct(Long id);
    Long countProductsBrandAndName(String brand, String name);
}
