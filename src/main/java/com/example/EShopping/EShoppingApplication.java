package com.example.EShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EShoppingApplication {

	public static void main(String[] args) {
		ApplicationContext cxt = SpringApplication.run(EShoppingApplication.class, args);
		
		ArticleRepository articleRepository =cxt.getBean(ArticleRepository.class);
		articleRepository.save(new Article("titre 1","core "));
	
		
	}

}
