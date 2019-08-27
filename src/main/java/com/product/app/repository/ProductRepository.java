package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.app.entity.Product;
/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
