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
import com.codenotfound.primefaces.repository.CategoryRepository;

@Named
@ViewScoped
public class CategoriesView implements Serializable {

	  private static final long serialVersionUID = 1L;

	  @Autowired
	  private CategoryRepository categoriesRepository;

	  private List<Category> categories;
	  
	  private Category selected;
	  public String namee; 
	  
	public String getNamee() {
		return namee;
	}
	public void setNamee(String namee) {
		this.namee = namee;
	}
	public Category getSelected() {
		return selected;
	}
	public void setSelected(Category selected) {
		this.selected = selected;
	}
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
	  
	  public void onRowSelect(SelectEvent event) {
	        this.selected = (Category) event.getObject();
	        
	        FacesContext context = FacesContext.getCurrentInstance();

	        if (this.selected == null) {
	            String msg = "No Category is selected!!";
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	        } else {
	            System.out.println("Category is selected in CategoriesView");
	            String msg = "Categoty selected: " + this.selected.getName();
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
	    
	    public void deleteExistingProduct() {
	        System.out.println("Deleting Existing product... ");
	        Category gnome = selected;
	        FacesContext context = FacesContext.getCurrentInstance();
	        // need to handel when gnome is null
	        if (gnome == null) {
	            System.out.println("Selected gnome is null");
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Selected product to be deleted is null. Bug!!! in the product list.", null));
	        }

	        // call EJB to delete the product
	        try {
	        	CategoryRepository accRepo = Context.getContext().getBean(CategoryRepository.class);
			    accRepo.delete(gnome.getId());
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Product deleted successfully.", null));
	            redirect("admin_categ.xhtml");
	        } catch (Exception e) {
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Product deletion was unsuccessful.", null));
	        }

	    }
	    
	    public void updateExistingProduct() {
	        System.out.println("Updating Existing product... ");
	        Category gnome = selected;
	        FacesContext context = FacesContext.getCurrentInstance();
	        // need to handel when gnome is null
	        if (gnome == null) {
	            System.out.println("Selected Category is null");
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Selected Category Update is null. Bug!!! in the product list.", null));
	        }

	        // call EJB to delete the product
        
	        	System.out.println("Value: "+namee);
	        	gnome.setName(namee);
	        	CategoryRepository accRepo = Context.getContext().getBean(CategoryRepository.class);
			    accRepo.save(gnome);
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Category Update successfully.", null));
	            redirect("admin_categ.xhtml");

	    }
		  

}
