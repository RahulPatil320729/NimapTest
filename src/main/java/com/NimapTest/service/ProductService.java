package com.NimapTest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.NimapTest.bean.ProductBean;
import com.NimapTest.entity.ProductEntity;

public interface ProductService {
	
		public String saveProduct(ProductBean request);
		public ProductEntity getById(int id);
		public String deleteProduct(int id);
		public String updateProduct(ProductBean reqBean);
		public Page<ProductEntity> getAll(Pageable pageable);

}
