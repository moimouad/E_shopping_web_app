package com.codenotfound.primefaces;

import org.junit.Assert;
import org.junit.*;
import org.mockito.Mockito;

import com.codenotfound.primefaces.model.Product;

public class JUnitTests {

	@Test
	public void testMethod1() {
		Product pro = new Product();
		pro.setName("name1");
		pro.setCategory("category1");		
		pro.setDescription("description1");
		pro.setPrice(100);
		pro.setQuantity(30);
		
		pro.updateProd("name2", "description2", 200, 60, null, null);
		int newPrice =pro.getPrice() ;

		Assert.assertEquals(200,newPrice);


	}
	 
	@Test
	public void testMethod2() {
		
		
		
	}
}
