package com.dcarminatti.market.cart.service.category;

import com.dcarminatti.market.cart.model.Category;
import com.dcarminatti.market.cart.request.category.AddCategoryRequest;
import com.dcarminatti.market.cart.request.category.CategoryUpdateRequest;

import java.util.List;

public interface ICategoryService {
    Category addCategory(AddCategoryRequest category);
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category updateCategory(Long id, CategoryUpdateRequest request);
    void deleteCategory(Long id);
}
