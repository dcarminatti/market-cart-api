package com.dcarminatti.market.cart.repository;

import com.dcarminatti.market.cart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
