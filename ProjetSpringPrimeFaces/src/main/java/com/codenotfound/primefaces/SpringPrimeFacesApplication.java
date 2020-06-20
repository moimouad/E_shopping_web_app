package com.codenotfound.primefaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codenotfound.primefaces.model.Car;
import com.codenotfound.primefaces.model.Category;
import com.codenotfound.primefaces.repository.CarRepository;
import com.codenotfound.primefaces.repository.CategoryRepository;

@SpringBootApplication
public class SpringPrimeFacesApplication {

  public static void main(String[] args) {
    
    ApplicationContext context = SpringApplication.run(SpringPrimeFacesApplication.class, args);
    
    CarRepository carRepo = context.getBean(CarRepository.class);
    CategoryRepository catRepo = context.getBean(CategoryRepository.class);
    catRepo.save(new Category(null,"Clothes"));
    
    
  }
}
