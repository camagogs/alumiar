package com.project.alumiar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.alumiar.models.Animal;
import com.project.alumiar.services.AnimalService;

@Controller
public class MainController {
	
	@Autowired
	private AnimalService service;

    @GetMapping("/")
	public String home(Model model) {
    	
    	Iterable<Animal> animais = service.obterTodos();
    	
    	model.addAttribute("animais", animais);
    	
		return "index";
	}
    
    @GetMapping("/admin")
    public String loginAdmin() {
    	return "pages/login";
    }
}
    