package com.project.alumiar.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.alumiar.models.Animal;
import com.project.alumiar.services.AnimalService;
import com.project.alumiar.services.StorageService;
import com.project.alumiar.storage.StorageFileNotFoundException;

@Controller
public class AnimalController {
	
	private boolean isAdotado = true;
	
	@Autowired
	private AnimalService service;
	
	private final StorageService storageService;
	
    @Autowired
    public AnimalController(StorageService storageService) {
        this.storageService = storageService;
    }
    
	@GetMapping("/admin/animais/form")
	public String form() {
		
		return "forms/animal/new";
	}
	
	@RequestMapping("/admin/animais/listar")
	public ModelAndView listar() {
		
		ModelAndView mv = new ModelAndView("forms/animal/listAnimal");
		mv.addObject("animais", service.obterTodos());
		
		return mv;
	}

	@GetMapping("/files/{filename:.+}")
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

      Resource file = storageService.loadAsResource(filename);
      return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
              "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
	
	@RequestMapping("/admin/animais/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		service.delete(id);
		redirectAttrs.addFlashAttribute("message", "Animal removido com sucesso!!!!");
		return "redirect:/admin/animais/listar";
	}
	
	@RequestMapping("admin/animais/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		
		return add(service.editar(id));
	}
	
	@GetMapping("/add")
	public ModelAndView add(Animal animal) {
		
		ModelAndView mv = new ModelAndView("/forms/animal/edit");
		mv.addObject("animalObj", animal);
		
		return mv;
	}
	
	@RequestMapping(value = "/admin/animais/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Animal animal,
			BindingResult bindresult) {
		
		if(bindresult.hasErrors()) {
			
			return add(animal);
		} 
		
		service.salvar(animal);
		
		return listar();
	}
	
	@RequestMapping(value = "/form/admin/cadastraAnimal", method = RequestMethod.POST)
	public String cadastrar(Model model, RedirectAttributes redirectAtt, 
			@RequestParam("nomeAnimal") String nome, 
			@RequestParam("raca") String raca, 
			@RequestParam("myImage") MultipartFile file,
			@RequestParam("isAdotado") String adocao,
			@RequestParam("tipoAnimal") String tipo,
			@RequestParam("sexo") String sexo, 
			@RequestParam("pelagem") String pelagem, 
			@RequestParam("idade") String idade, 
			@RequestParam("desc") String descricao,
			@RequestParam("cuidados") String cuidados) {
				
		try {
			
			Animal animal = new Animal(nome, raca, file.getOriginalFilename(), tipo, idade, pelagem, sexo, descricao, cuidados,isAdotado);
			
			storageService.store(file);
			
			service.salvar(animal);
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("msgError", e.getMessage());
			return "pages/404"; 
		}
		return "redirect:/admin/animais/listar";	
	}
	
	
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
