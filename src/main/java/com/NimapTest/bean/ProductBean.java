package com.NimapTest.bean;

import java.util.Locale.Category;

import com.NimapTest.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductBean {
	private int id;
	private String name;
	private String description;
	private Double price;
	private CategoryEntity category;
	
	public ProductBean() {
		
	}
}

