package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.primefaces.Context;
import com.codenotfound.primefaces.model.Card;
import com.codenotfound.primefaces.model.Product;
import com.codenotfound.primefaces.repository.CardRepository;
import com.codenotfound.primefaces.repository.ProductRepository;

@Named
@ViewScoped
public class CardView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private ProductRepository productRepository;
	
	private List<Card> cards;
	private List<Card> orders;
	private ArrayList<Product> products =  new ArrayList<Product>() ;
	private ArrayList<Product> productsOrder =  new ArrayList<Product>() ;
	private Card card = new Card();
	private String actUser;
	private Long selected;
	private int total;
	private int totalOrders;
	
	
	
	public List<Card> getOrders() {
		return orders;
	}

	public void setOrders(List<Card> orders) {
		this.orders = orders;
	}

	public ArrayList<Product> getProductsOrder() {
		return productsOrder;
	}

	public void setProductsOrder(ArrayList<Product> productsOrder) {
		this.productsOrder = productsOrder;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Long getSelected() {
		return selected;
	}

	public void setSelected(Long selected) {
		this.selected = selected;
	}

	public String getActUser() {
		return actUser;
	}

	public void setActUser(String actUser) {
		this.actUser = actUser;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@PostConstruct
	public void init() {
		
		total = 0;
		totalOrders = 0;
		
		FacesContext context = FacesContext.getCurrentInstance();
		actUser = (String) context.getExternalContext().getSessionMap().get("username");
		cards = cardRepository.findAll();
		orders = cardRepository.findAll();
		
		products.clear();
		productsOrder.clear();
		
		int len = cards.size();
        for (int i = 0; i < len; i++) {
        	if(!cards.get(i).getUser().equals(actUser) || cards.get(i).isOrderbool()) {
        		cards.remove(i);
        		i--;
        		len--;
        	}
        }
 
        for (int i = 0; i < cards.size(); i++) {
        	
        	Product p = productRepository.findOne(cards.get(i).getIdProd());
        	
        	p.setQuantity(cards.get(i).getQuantity());
        	
        	p.setId(cards.get(i).getId());
        	
        	total += p.getPrice() * p.getQuantity();
        
        	products.add(p) ;
        	
        }
        
        //----------------------------------------------------------------------
        
        len = orders.size();
        for (int i = 0; i < len; i++) {
        	if(!orders.get(i).getUser().equals(actUser) || !orders.get(i).isOrderbool()) {
        		orders.remove(i);
        		i--;
        		len--;
        	}
        }
 
        for (int i = 0; i < orders.size(); i++) {
        	
        	Product p = productRepository.findOne(orders.get(i).getIdProd());
        	
        	p.setQuantity(orders.get(i).getQuantity());
        	
        	if(orders.get(i).isValid()) {
        		p.setId(Long.valueOf(1));
        	}
        	else {
        		p.setId(Long.valueOf(0));
        	}
        	
        	totalOrders += p.getPrice() * p.getQuantity();
        
        	productsOrder.add(p) ;
        	
        }
        
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
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
	
	public void addToCard() {
		CardRepository accRepo = Context.getContext().getBean(CardRepository.class);
		accRepo.save(card);
		redirect("products.xhtml");
	 }
	
	  public void deleteProduct() {
	      FacesContext context = FacesContext.getCurrentInstance();
		        CardRepository accRepo = Context.getContext().getBean(CardRepository.class);
				accRepo.delete(selected);
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin: Category Delete successfully.", null));
		        redirect("card.xhtml");
	  }
	  
	  public void orderProduct() {
		        CardRepository accRepo = Context.getContext().getBean(CardRepository.class);
		        for (int i = 0; i < cards.size(); i++) {
		        	Card c = cards.get(i); 
		        	c.setOrderbool(true);
		        	accRepo.save(c);
		        }
		        redirect("orders.xhtml");
	  }
	
	

}
