package com.NimapTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NimapTest.bean.CategoryBean;
import com.NimapTest.entity.CategoryEntity;
import com.NimapTest.service.CategoryService;


@RestController
@RequestMapping("/api")
public class CategoryController {
	
@Autowired
private CategoryService categoryService;

   @PostMapping("/categories")
   public String saveCategory(@RequestBody CategoryBean req) {
	return categoryService.saveCategory(req);
   }
   
   @GetMapping("/categories/all")
   public List<CategoryEntity> getall() {
	return categoryService.getall();
   }
   
   @GetMapping("/categories/{id}")
   public CategoryEntity getCategoryById(@PathVariable int id) {
	return categoryService.getCategoryById(id);
   }
   
   @PutMapping("/categories/{id}")
   public String updateCategory(@PathVariable int id ,@RequestBody CategoryBean req) {
	req.setId(id);
	return categoryService.updateCategory(req);
   }
   
   @DeleteMapping("/categories/{id}")
   public String deleteCategory(@PathVariable int id) {
	return categoryService.deleteCategory(id);
   }
   @GetMapping("/categories")
   public ResponseEntity<Page<CategoryEntity>> getCategories(@RequestParam(defaultValue = "0") int page) {
       PageRequest request = PageRequest.of(page, 10); 
       return ResponseEntity.ok(categoryService.getallCategories(request));
   }

  }
