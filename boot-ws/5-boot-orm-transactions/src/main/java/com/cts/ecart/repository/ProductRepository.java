package com.cts.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
