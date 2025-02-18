package com.ProductManagementSystem.ProductManagementSystem.repository;

import com.ProductManagementSystem.ProductManagementSystem.entity.dj.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonEntityRepository extends JpaRepository<PersonEntity, UUID> {
}