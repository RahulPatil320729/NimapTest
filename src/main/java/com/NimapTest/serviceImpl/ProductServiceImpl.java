package com.NimapTest.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.NimapTest.bean.ProductBean;
import com.NimapTest.entity.CategoryEntity;
import com.NimapTest.entity.ProductEntity;
import com.NimapTest.exception.CategoryNotFoundException;
import com.NimapTest.repo.CategoryRepo;
import com.NimapTest.repo.ProductRepo;
import com.NimapTest.service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public String saveProduct(ProductBean request) {
	CategoryEntity category = categoryRepo.findById(request.getCategory().getId()).orElseThrow(()-> new CategoryNotFoundException(request.getCategory().getId()));
	ProductEntity product= new ProductEntity();
	product.setName(request.getName());
	product.setDescription(request.getDescription());
	product.setPrice(request.getPrice());
	product.setCategory(category);
	productRepo.save(product);
	return "Product saved sucessfully";
	}

	@Override
	public ProductEntity getById(int id) {
	return productRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found with id :"+id));
		
	}

	@Override
	public String deleteProduct(int id) {
	productRepo.deleteById(id);
	return "Product deleted";
	}

	@Override
	public String updateProduct(ProductBean reqBean) {
	Optional<ProductEntity> product = productRepo.findById(reqBean.getId());
	if(product.isPresent()){
		ProductEntity existProduct = product.get();
		existProduct.setName(reqBean.getName());
		existProduct.setDescription(reqBean.getDescription());
		existProduct.setPrice(reqBean.getPrice());
		if(reqBean.getCategory()!=null) {
			existProduct.setCategory(reqBean.getCategory());
		}
		productRepo.save(existProduct);
		return "Product Updated ";
	}else {
		return "Product not found";
	}
		
	}

	@Override
	public Page<ProductEntity> getAll(Pageable pageable) {
		
		return productRepo.findAll(pageable);
	}

}
