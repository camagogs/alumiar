package com.project.alumiar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
	public String home() {
		return "index";
	}
    
    @GetMapping("/adote")
	public String adote() {
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
