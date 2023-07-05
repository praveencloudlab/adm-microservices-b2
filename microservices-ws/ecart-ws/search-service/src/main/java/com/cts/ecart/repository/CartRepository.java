package com.cts.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{}
