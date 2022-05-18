package com.study.demoProject.domain.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findFirstByCode(Long code);
}
