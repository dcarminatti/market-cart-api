package com.dcarminatti.market.cart.repository;

import com.dcarminatti.market.cart.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
