package com.NimapTest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapTest.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>{

}
