package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.app.entity.ProductPurchase;

public interface PurchaseRepository extends JpaRepository<ProductPurchase, Integer> {

}
