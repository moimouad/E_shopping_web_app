package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private String imageUrl;
	private String category;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product(String name, String description, int price, int quantity, String imageUrl, String category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.category = category;
	}
	public Product() {
		super();
	}
	
	public void updateProd(String name, String description, int price, int quantity, String imageUrl, String category) {
		
		  if (name != null && !name.equals("")) {
		       this.setName(name); }	      
	      if (description != null && !description.equals("")) {
	    	  this.setDescription(description);	     }	      
	      if (category != null && !category.equals("")) {
	    	  this.setCategory(category);	      }	      
	      if (imageUrl != null && !imageUrl.equals("")) {
	    	  this.setImageUrl(imageUrl);	     }	      
	      if (price != 0 ) {
	    	  this.setPrice(price);	     }	     
	      if (quantity != 0 ) {
	    	  this.setQuantity(quantity);	      }
	      				
	}
	
}
