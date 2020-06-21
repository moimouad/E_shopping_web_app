package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.Context;
import com.codenotfound.primefaces.model.Product;
import com.codenotfound.primefaces.repository.ProductRepository;


@Named
@ViewScoped
public class ProductView implements Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private ProductRepository ProductRepository;

  private List<Product> Products;
  
  private Long id;


  private String name;
  private String description;
  private int price;
  private int quantity;
  private String imageUrl;
  private String category;
  
  private String chose;
  
  
  public String getChose() {
	return chose;
}


public void setChose(String chose) {
	this.chose = chose;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}
  
  public Product getSelected() {
	return selected;
}


public void setSelected(Product selected) {
	this.selected = selected;
}

private Product selected;
  
  @PostConstruct
  public void init() {
	  
	FacesContext context = FacesContext.getCurrentInstance();
	this.setChose((String) context.getExternalContext().getSessionMap().get("chose"));
	
	
    Products = ProductRepository.findAll();
    if (chose != null) {
    	int len = Products.size();
        for (int i = 0; i < len; i++) {
        	if(!Products.get(i).getCategory().equals(chose)) {
        		Products.remove(i);
        		i--;
        		len--;
        	}
        }
    }
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
  
  
  
  public void deleteProduct() {
      FacesContext context = FacesContext.getCurrentInstance();
      if (selected != null) {
	        ProductRepository accRepo = Context.getContext().getBean(ProductRepository.class);
			accRepo.delete(selected.getId());
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Category Delete successfully.", null));
	        redirect("admin_prod.xhtml");
      }
  }
  
  public void chose() {
	  FacesContext context = FacesContext.getCurrentInstance();
	  context.getExternalContext().getSessionMap().put("chose",chose);
	  redirect("products.xhtml");
  }
  
  public void chose(int i) {
	  FacesContext context = FacesContext.getCurrentInstance();
	  context.getExternalContext().getSessionMap().put("chose",null);
	  redirect("products.xhtml");
  }
  
  
  
}