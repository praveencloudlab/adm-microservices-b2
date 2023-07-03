package com.cts.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
