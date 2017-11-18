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
	public String home() {
		return "index";
	}
    
    @GetMapping("/adote")
	public String adote(Model model) {
    	
    	Iterable<Animal> animais = service.obterTodos();
    	
    	model.addAttribute("animais", animais);
    	
		return "pages/adote";
	}
    
    @GetMapping("/apoio")
	public String apoio() {
		return "pages/apoio";
	}
    
    @GetMapping("/ensaios")
	public String ensaios() {
		return "pages/ensaios";
	}
    
    @GetMapping("/o_projeto")
	public String oProjeto() {
		return "pages/o_projeto";
	}
    
    @GetMapping("/alumiar")
	public String alumiar() {
		return "pages/alumiar";
	}
    
    @GetMapping("/sobre_nos")
	public String sobreNos() {
		return "pages/sobre-nos";
	}
}
