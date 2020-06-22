package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Card")
public class Card {
	
	@Id
	@GeneratedValue
	private Long id;
	private String user;
	private Long idProd;
	private int quantity;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getIdProd() {
		return idProd;
	}
	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Card(String user, Long idProd, int quantity) {
		super();
		this.user = user;
		this.idProd = idProd;
		this.quantity = quantity;
	}

	public Card() {
		super();
	}
	
	
	
	
	

}