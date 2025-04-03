package com.dcarminatti.market.cart.service.category;

import com.dcarminatti.market.cart.exception.category.CategoryNotFoundException;
import com.dcarminatti.market.cart.exception.category.CategoryAlreadyExistsException;
import com.dcarminatti.market.cart.model.Category;
import com.dcarminatti.market.cart.repository.CategoryRepository;
import com.dcarminatti.market.cart.request.category.AddCategoryRequest;
import com.dcarminatti.market.cart.request.category.CategoryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public Category addCategory(AddCategoryRequest request) {
        if (categoryRepository.findByName(request.getName()) != null) {
            throw new CategoryAlreadyExistsException(request.getName() + " category already exists!");
        } else {
            Category newCategory = createCategory(request);
            return categoryRepository.save(newCategory);
        }
    }

    private Category createCategory(AddCategoryRequest request) {
        return new Category(
                request.getName(),
                request.getDescription()
        );
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found!"));
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, CategoryUpdateRequest request) {
        return categoryRepository.findById(id)
                .map(existingCategory -> updateExistingCategory(existingCategory, request))
                .map(categoryRepository::save)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found!"));
    }

    private Category updateExistingCategory(Category existingCategory, CategoryUpdateRequest request) {
        existingCategory.setName(request.getName());
        existingCategory.setDescription(request.getDescription());
        return existingCategory;
    }

    public void deleteCategory(Long id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found!"));
    }
}
