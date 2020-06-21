package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.Context;
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
	  private String repassword;
	  public String errorMessage;
	  private boolean loggedin;
	  

	private boolean remember = false;
	  

	  public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

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

	  public List<Account> getAccounts() {
	    return Accounts;
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
		
		
		public void login() {
			init();
	        for (int i = 0; i < Accounts.size(); i++) {
	            if (Accounts.get(i).getUsername().equals(username) && Accounts.get(i).getPassword().equals(password)) {
	            	
	            	FacesContext facesContext = FacesContext.getCurrentInstance();
	        		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
	            	if(this.remember)
	    			{
	    				Cookie ckUsername = new Cookie("username",this.getUsername());
	    				ckUsername.setMaxAge(3600);
	    				response.addCookie(ckUsername);
	    				Cookie ckPassword = new Cookie("password",this.getPassword());
	    				ckUsername.setMaxAge(3600);
	    				response.addCookie(ckPassword);
	    			}            	
	            	
	    			FacesContext context = FacesContext.getCurrentInstance();
	    			context.getExternalContext().getSessionMap().put("username",username);
	    			context.getExternalContext().getSessionMap().put("username",username);
	    			System.out.println(context.getExternalContext().getSessionMap().get("username"));
	            	redirect("items.xhtml");
	            	return;
	            }
	        }
	        errorMessage = "Username or Password incorrect !";
		}
		
		
		
		public void signup() {
			if (password.equals(repassword)) {
				
				init();
				
				boolean existed = false;
				
		        for (int i = 0; i < Accounts.size(); i++) {
		            if (Accounts.get(i).getUsername().equals(username)) {
		            	errorMessage = "Username already existed !";
		            	existed = true;
		            }
		        }
		        
		        if (!existed) {
		        	AccountRepository accRepo = Context.getContext().getBean(AccountRepository.class);
				    accRepo.save(new Account(username,password));
				    redirect("index.xhtml");
		        }
				
			}
			else {
				errorMessage = "You didn't retape well the password !";
			}
		}
		
		
		public void checkloginstatus()
		{
			if(username == null || this.getUsername().equals(""))
			{
				this.loggedin = false;
			}
			else
			{
				this.loggedin = true;
			}
		}
		
		private Account checkCookie()
		{
			Account account = null;
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			String username = "", password = "";
			Cookie [] cookies = request.getCookies();
			if(cookies != null)
			{
				for(Cookie ck : cookies)
				{
					if(ck.getName().equalsIgnoreCase("username"))
						username = ck.getValue();
					if(ck.getName().equalsIgnoreCase("password"))
						password = ck.getValue();
				}
			}
			if(!username.isEmpty() && !password.isEmpty())
			{
				account = new Account(username,password);
			}
			return account;
		}
		
		public void verifyLoginOnWelcomedummy()
		{
			this.errorMessage = "";
			FacesContext context = FacesContext.getCurrentInstance();
			//check for cookie
			Account acc = checkCookie();
			if(acc != null)	{
				System.out.println("Cookie found");
				System.out.println(acc.getUsername());
				this.setUsername(acc.getUsername());
				this.setPassword(acc.getPassword());
			}
			else {
				this.setUsername((String) context.getExternalContext().getSessionMap().get("username"));
			}
			
		}
		
		public void logout()
		{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			//Remove cookie
			for(Cookie ck : request.getCookies())
			{
				if(ck.getName().equalsIgnoreCase("username"))
				{
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
				if(ck.getName().equalsIgnoreCase("password"))
				{
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
			//delete session
			FacesContext context = FacesContext.getCurrentInstance();
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			System.out.println(context.getExternalContext().getSessionMap().get("username"));
			try{
			TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			redirect("items.xhtml");
		}
		
		
		public boolean admin() {
			init();
	        for (int i = 0; i < Accounts.size(); i++) {
	            if (Accounts.get(i).getUsername().equals(username)) {
	            	return Accounts.get(i).isAdmin();
	            }
	        }
	        return false;
		}
		
		public void isAdmin() {
			if(!admin()) redirect("items.xhtml");
		}
		
	}