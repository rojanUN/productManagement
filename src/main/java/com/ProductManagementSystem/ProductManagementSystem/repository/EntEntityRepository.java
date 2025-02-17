package com.ProductManagementSystem.ProductManagementSystem.repository;

import com.ProductManagementSystem.ProductManagementSystem.entity.EntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntEntityRepository extends JpaRepository<EntEntity, UUID> {
}