package com.codenotfound.primefaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codenotfound.primefaces.model.Car;
import com.codenotfound.primefaces.repository.CarRepository;

@SpringBootApplication
public class SpringPrimeFacesApplication {

  public static void main(String[] args) {
    
    ApplicationContext context = SpringApplication.run(SpringPrimeFacesApplication.class, args);
    
    CarRepository carRepo = context.getBean(CarRepository.class);
    
    carRepo.save(new Car("mouadert",1998,"mouuzert"));
    
  }
}
