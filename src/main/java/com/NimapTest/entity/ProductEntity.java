package com.NimapTest.entity;

import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class ProductEntity {
	public ProductEntity() {
	}
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String description;
   private Double price;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="category_id")
   private CategoryEntity category;

}

