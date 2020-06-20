package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.model.Account;
import com.codenotfound.primefaces.repository.AccountRepository;

@Named
@ViewScoped
public class AccountView implements Serializable {

	  private static final long serialVersionUID = 1L;

	  @Autowired
	  private AccountRepository AccountRepository;

	  private List<Account> Accounts;
	  
	  private String username;
	  private String password;

	  public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@PostConstruct
	  public void init() {
	    Accounts = AccountRepository.findAll();
	  }

	  public List<Account> getCars() {
	    return Accounts;
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
		
		public void redirectto()
		{
			System.out.println("Happppppppppyyyyy !!!!!");
			redirect("helloworld.xhtml");
		}
		
		public void login() {
			init();
	        for (int i = 0; i < Accounts.size(); i++) {
	            if (Accounts.get(i).getUsername().equals(username) && Accounts.get(i).getPassword().equals(password)) {
	            	redirect("helloworld.xhtml");
	            }
	        }
			
		}
	}