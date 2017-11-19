package com.project.alumiar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.alumiar.models.Animal;
import com.project.alumiar.repository.AnimalRepository;

@Component
public class DataLoader {
	
	private AnimalRepository repository;
	
	@Autowired
	public DataLoader (AnimalRepository repository) {
		this.repository = repository;
	}
	
	@PostConstruct
	private void createAnimal() {
		Animal a = new Animal();
		
		a.setNome("Billy");
		
		a.setPathFoto("dog.jpg");
		
		repository.save(a);
		
	}

}
