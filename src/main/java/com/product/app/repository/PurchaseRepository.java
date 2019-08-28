package com.product.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.app.entity.ProductPurchase;

public interface PurchaseRepository extends JpaRepository<ProductPurchase, Integer> {
	
	@Query(value="select product_id, count(product_id) as count from ingproduct.product_purchase where purchase_date=:dailyDate group by product_id",nativeQuery = true)
	public List<Integer[]> getPruductNameAndCount(String dailyDate);

}
