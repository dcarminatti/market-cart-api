package com.dcarminatti.market.cart.service.product;

import com.dcarminatti.market.cart.exception.product.ProductNotFoundException;
import com.dcarminatti.market.cart.model.Category;
import com.dcarminatti.market.cart.model.Product;
import com.dcarminatti.market.cart.repository.CategoryRepository;
import com.dcarminatti.market.cart.repository.ProductRepository;
import com.dcarminatti.market.cart.request.product.AddProductRequest;
import com.dcarminatti.market.cart.request.product.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product addProduct(AddProductRequest request) {
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        return productRepository.save(createProduct(request, category));
    }

    private Product createProduct(AddProductRequest request, Category category) {
        return new Product(
                request.getName(),
                request.getDescription(),
                request.getBrand(),
                request.getPrice(),
                request.getQuantity(),
                category
        );
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    public List<Product> getProductsByCategoryAndName(String category, String name) {
        return productRepository.findByCategoryNameAndName(category, name);
    }

    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    public Product updateProduct(Long productId, ProductUpdateRequest request) {
        return productRepository.findById(productId)
                .map(existingProduct -> updateExistingProduct(existingProduct, request))
                .map(productRepository::save)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {
        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setQuantity(request.getQuantity());

        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        existingProduct.setCategory(category);

        return existingProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete, () -> {
            throw new ProductNotFoundException("Product not found!");
        });
    }

    public Long countProductsBrandAndName(String brand, String name) {
        return productRepository.countProductByBrandAndName(brand, name);
    }
}
