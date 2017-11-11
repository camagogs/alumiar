package com.project.alumiar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.alumiar.models.Animal;
import com.project.alumiar.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;
	
	public void salvar(Animal animal) {
		repository.save(animal);
	}

}
