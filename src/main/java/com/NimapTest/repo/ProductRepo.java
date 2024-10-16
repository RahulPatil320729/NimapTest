package com.NimapTest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapTest.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
