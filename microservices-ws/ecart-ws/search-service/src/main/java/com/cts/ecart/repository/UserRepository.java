package com.cts.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
