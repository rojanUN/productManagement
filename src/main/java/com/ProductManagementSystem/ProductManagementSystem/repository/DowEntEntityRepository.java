package com.ProductManagementSystem.ProductManagementSystem.repository;

import com.ProductManagementSystem.ProductManagementSystem.entity.dj.DowEntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DowEntEntityRepository extends JpaRepository<DowEntEntity, UUID> {
}