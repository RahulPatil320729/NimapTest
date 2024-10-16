package com.NimapTest.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.NimapTest.bean.CategoryBean;
import com.NimapTest.entity.CategoryEntity;


public interface CategoryService {

	 public String saveCategory(CategoryBean req);
	 public CategoryEntity getCategoryById(int id);
	 public String updateCategory(CategoryBean req);
	 public String deleteCategory(int id);
	 public List<CategoryEntity> getall();
	 public Page<CategoryEntity> getallCategories(Pageable pageable);
}
