package com.NimapTest.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.NimapTest.bean.CategoryBean;
import com.NimapTest.entity.CategoryEntity;
import com.NimapTest.exception.CategoryNotFoundException;
import com.NimapTest.repo.CategoryRepo;
import com.NimapTest.service.CategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo repo;

	@Override
	public String saveCategory(CategoryBean req) {
		CategoryEntity category = new CategoryEntity();
		category.setName(req.getName());
		repo.save(category);
		return "Category saved sucessfully";
	}

	@Override
	public CategoryEntity getCategoryById(int id) {
	return repo.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
	}

	@Override
	public String updateCategory(CategoryBean req) {
	Optional<CategoryEntity> cat = repo.findById(req.getId());
	if(cat.isPresent()) {
		CategoryEntity existing = cat.get();
          existing.setName(req.getName());	
          repo.save(existing);
          return "Updated sucessfully";
	}
	else {
		return "cant find category with id :"+ req.getId();
	}
	}

	@Override
	public String deleteCategory(int id) {
		if(!repo.existsById(id)) {
			throw new CategoryNotFoundException(id);
		}
	repo.deleteById(id);
	return "Category with id :"+id+ " deleted";
	}

	@Override
	public List<CategoryEntity> getall() {
		return repo.findAll();
	}

	@Override
	public Page<CategoryEntity> getallCategories(Pageable pageable) {
	
		return repo.findAll(pageable);
	}

}
