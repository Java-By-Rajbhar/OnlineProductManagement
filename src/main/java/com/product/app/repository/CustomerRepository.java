package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
