package com.codenotfound.primefaces;

import javax.inject.Named;


@Named
public class HelloWorld {
	


  private String firstName = "1";
  private String lastName = "1";
  
  

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String showGreeting() {
	
    return "X + Y = " + (Integer.parseInt(firstName)+Integer.parseInt(lastName))  ;
  }
}
