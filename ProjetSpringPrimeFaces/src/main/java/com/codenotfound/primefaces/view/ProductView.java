package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.Context;
import com.codenotfound.primefaces.model.Category;
import com.codenotfound.primefaces.model.Product;
import com.codenotfound.primefaces.repository.ProductRepository;


@Named
@ViewScoped
public class ProductView implements Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private ProductRepository ProductRepository;

  private List<Product> Products;
  
  private String name;
  private String description;
  private int price;
  private int quantity;
  private String imageUrl;
  private String category;
  
  private Product selected;
  
  @PostConstruct
  public void init() {
    Products = ProductRepository.findAll();
  }
  
  
  public List<Product> getProducts() {
	return Products;
}


public void setProducts(List<Product> products) {
	Products = products;
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


  
  public void redirect(String page)
	{
		try{
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(page);
			
		} catch(Exception e){
			System.out.println(e);
		}
	}
  
  public void addProduct() {
      System.out.println("Add New Category... ");
      FacesContext context = FacesContext.getCurrentInstance();
      if (name != null && !name.equals("")) {
	        ProductRepository accRepo = Context.getContext().getBean(ProductRepository.class);
			accRepo.save(new Product( name,description,price,quantity,imageUrl,category) );
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Category Update successfully.", null));
	        redirect("admin_prod.xhtml");
      }
  }
  
  public void updateProduct() {
      
      FacesContext context = FacesContext.getCurrentInstance();
      if (selected != null) {
	        ProductRepository accRepo = Context.getContext().getBean(ProductRepository.class);
	        
	        if (name != null && !name.equals(""))    {  	selected.setName(name);     }
	        if (description != null && !description.equals(""))        {     	selected.setDescription(description);      }
	        if (price !=  0)       {       	selected.setPrice(price);       }
	        if (quantity !=  0)       {       	selected.setQuantity(quantity);       }
	        if (imageUrl != null && !imageUrl.equals(""))        {     	selected.setImageUrl(imageUrl);      }
	        if (category != null && !category.equals(""))        {     	selected.setCategory(category);      }
	        
			accRepo.save(selected);
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Category Update successfully.", null));
	        redirect("admin_prod.xhtml");
      }
  }
  
  
  public void deleteProduct() {
      FacesContext context = FacesContext.getCurrentInstance();
      if (selected != null) {
	        ProductRepository accRepo = Context.getContext().getBean(ProductRepository.class);
			accRepo.delete(selected.getId());
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Category Delete successfully.", null));
	        redirect("admin_prod.xhtml");
      }
  }
  
  public void onRowSelect(SelectEvent event) {
      this.selected = (Product) event.getObject();
      
      FacesContext context = FacesContext.getCurrentInstance();

      if (this.selected == null) {
          String msg = "No product is selected!!";
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
      } else {
          String msg = "Product selected: " + this.selected.getName();
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
      }

  }

  public void onRowUnselect(UnselectEvent event) {
      this.selected = null;
      String msg = "Gnome unselected: " + this.selected;
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
      if (this.selected == null) {
          System.out.println(this.selected + ": is unselected");
      }
  }
  
  
}