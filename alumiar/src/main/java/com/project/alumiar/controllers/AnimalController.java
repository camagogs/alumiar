package com.project.alumiar.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.alumiar.models.Animal;
import com.project.alumiar.models.Animal.Idade;
import com.project.alumiar.models.Animal.Pelagem;
import com.project.alumiar.models.Animal.TipoAnimal;
import com.project.alumiar.services.AnimalService;
import com.project.alumiar.services.StorageService;
import com.project.alumiar.storage.StorageFileNotFoundException;

@Controller
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	private final StorageService storageService;
	
    @Autowired
    public AnimalController(StorageService storageService) {
        this.storageService = storageService;
    }
    
	@GetMapping("/admin/animais/form")
	public String form() {
		return "forms/animal/formularioAnimal";
	}
	
	@RequestMapping("/admin/animais/listar")
	public String listar(Model model) throws IOException {
		Iterable<Animal> animais = service.obterTodos();
		
		Stream<Path> images = storageService.loadAll();
		
		model.addAttribute("animais", animais);
		
        model.addAttribute("files", images.map(
                path -> MvcUriComponentsBuilder.fromMethodName(AnimalController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));
        
		return "forms/animal/listAnimal";
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
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("animalObj", service.editar(id));
		return "forward:/admin/animais/form";
	}
	
	
	@RequestMapping(value = "/form/admin/cadastraAnimal", method = RequestMethod.POST)
	public String cadastrar(Model model, RedirectAttributes redirectAtt, 
			@RequestParam("nomeAnimal") String nome, 
			@RequestParam("raca") String raca, 
			@RequestParam("myImage") MultipartFile file,
			@RequestParam("tipoAnimal") String tipo,
			@RequestParam("sexo") String sexo, 
			@RequestParam("pelagem") String pelagem, 
			@RequestParam("idade") String idade, 
			@RequestParam("desc") String descricao,
			@RequestParam("cuidados") String cuidados) {
		
		if (file.isEmpty()) {
            redirectAtt.addFlashAttribute("message", "Please select a file to upload");
        }
		
		if (!file.isEmpty()) {
            model.addAttribute("images", file);
        }
	
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
			
			Animal animal = new Animal(nome, raca, file.getOriginalFilename(), TipoAnimal, Idade, Pelagem, sexo, descricao, cuidados);
			
			storageService.store(file);
			
			service.salvar(animal);
			
		} catch (Exception e) {
			return "Ops, deu um erro: " + e.getMessage();
		}
		return "redirect:/admin/animais/listar";	
	}
	
	
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
