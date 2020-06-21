package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Product;
import com.codenotfound.primefaces.repository.ProductRepository;


@Named
@ViewScoped
public class ProductView implements Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private ProductRepository ProductRepository;

  private List<Product> Products;

  @PostConstruct
  public void init() {
    Products = ProductRepository.findAll();
  }
  
  public void redirect(String page)
	{
		try{
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(page);
			
		} catch(Exception e){
			System.out.println(e);
		}
	}
  
  
}