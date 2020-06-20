package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name ="Category")
public class Category {
	
	 @Id
	 @GeneratedValue
	 private Long id;
	 
	 
	 private String Name; 
	 public Category() {
		 
	 }
	 public Category(Long id,String Name) {
		 
		 this.id =id;
		 this.Name = Name ;
		 
	 }
	 
	 
	 
	 
	 
	  public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}



	  
	 
	 
	 
	 
}
