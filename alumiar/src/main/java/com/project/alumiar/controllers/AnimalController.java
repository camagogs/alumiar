package com.project.alumiar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.alumiar.models.Animal;
import com.project.alumiar.models.Animal.Idade;
import com.project.alumiar.models.Animal.Pelagem;
import com.project.alumiar.models.Animal.TipoAnimal;
import com.project.alumiar.services.AnimalService;

@Controller
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	
	@GetMapping("/form")
	public String form() {
		return "forms/animal/formularioAnimal";
	}
	
	@RequestMapping("/listaranimais")
	public String listar(Model model) {
		Iterable<Animal> animais = service.obterTodos();
		
		model.addAttribute("animais", animais);
		
		return "forms/animal/listAnimal";
	}
	
	@RequestMapping(value = "/form/admin/cadastraAnimal", method = RequestMethod.POST)
	public String cadastrar(Model model, 
			@RequestParam("nomeAnimal") String nome, 
			@RequestParam("raca") String raca, 
			@RequestParam("myImage") String foto,
			@RequestParam("tipoAnimal") String tipo,
			@RequestParam("sexo") String sexo, 
			@RequestParam("pelagem") String pelagem, 
			@RequestParam("idade") String idade, 
			@RequestParam("desc") String descricao,
			@RequestParam("cuidados") String cuidados) {
	
		TipoAnimal TipoAnimal = null;
		Pelagem Pelagem = null;
		Idade Idade = null;
		
		
		if(tipo.equals("g")) {
			TipoAnimal = TipoAnimal.GATO;
		}
		
		if(tipo.equals("c")) {
			TipoAnimal = TipoAnimal.CACHORRO;
		}
		
		if(pelagem.equals("curta")) {
			Pelagem = Pelagem.CURTA;
		}
		
		if(pelagem.equals("media")) {
			Pelagem = Pelagem.MEDIA;
		}
		
		if(pelagem.equals("longa")) {
			Pelagem = Pelagem.LONGA;
		}
		
		if(idade.equals("filhote")) {
			Idade = Idade.FILHOTE;
		}
		
		if(idade.equals("adulto")) {
			Idade = Idade.ADULTO;
		}
		
		if(idade.equals("idoso")) {
			Idade = Idade.IDOSO;
		}
		
		try {
			
			Animal animal = new Animal(nome, raca, foto, TipoAnimal, Idade, Pelagem, sexo, descricao, cuidados);
			
			service.salvar(animal);
			
			return "redirect:/listaranimais"; 
			
		} catch (Exception e) {
			return "Ops, deu um erro: " + e.getMessage();
		}
	}
	
}
