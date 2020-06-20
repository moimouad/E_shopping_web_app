package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;


import com.codenotfound.primefaces.model.Category;
import com.codenotfound.primefaces.repository.CategoryRepository;

@Named
@ViewScoped
public class CategoriesView implements Serializable {


	  private static final long serialVersionUID = 1L;

	  @Autowired
	  private CategoryRepository categoriesRepository;

	  private List<Category> categories;
	  

	  @PostConstruct
	  public void init() {
		  categories = categoriesRepository.findAll();
	  }
	  public List<Category> getCategories() {
		    return categories;
		  }
	  private void redirect(String page)
		{
			try{
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getExternalContext().redirect(page);
				
			} catch(Exception e){
				System.out.println(e);
			}
		}
		  

}
