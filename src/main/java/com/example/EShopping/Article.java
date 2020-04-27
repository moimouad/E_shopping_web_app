package com.example.EShopping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	
	@Id @GeneratedValue
	private Long Id ;
	private String title;
	private String core;
	public Article() {
		super();
		
	}
	public Article(String title, String core) {
		super();
		this.title = title;
		this.core = core;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	

}
