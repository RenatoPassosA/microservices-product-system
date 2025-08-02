package com.project.productapi.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.productapi.infrastructure.repository.jpa.ProductEntity;

@Repository
public interface TestProductRepository extends JpaRepository<ProductEntity, Long> {

}