package com.codenotfound.primefaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPrimeFacesApplication {

  public static void main(String[] args) {
    
    Context.setContext(SpringApplication.run(SpringPrimeFacesApplication.class, args)) ;
    
    /*AccountRepository carRepo = context.getBean(AccountRepository.class);
    carRepo.save(new Account("mouad","1234"));*/
    
  }
}
