package com.example.EShopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	
	
	@RequestMapping(value="/")
	public String Connection(Model model) {
		
		
		
		return "Acceuil.xhtml";
	}
	
	


}
