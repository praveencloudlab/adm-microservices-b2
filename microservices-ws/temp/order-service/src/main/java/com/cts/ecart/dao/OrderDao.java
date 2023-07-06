package com.cts.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
