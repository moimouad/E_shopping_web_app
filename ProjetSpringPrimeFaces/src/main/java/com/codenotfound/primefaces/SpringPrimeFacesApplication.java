package com.codenotfound.primefaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codenotfound.primefaces.model.Account;
import com.codenotfound.primefaces.repository.AccountRepository;

@SpringBootApplication
public class SpringPrimeFacesApplication {

  public static void main(String[] args) {
    
    ApplicationContext context = SpringApplication.run(SpringPrimeFacesApplication.class, args);
    /*
    AccountRepository carRepo = context.getBean(AccountRepository.class);
    
    carRepo.save(new Account("mouad","1234"));*/
    
  }
}
