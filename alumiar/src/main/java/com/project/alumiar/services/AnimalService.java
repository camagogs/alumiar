package com.project.alumiar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.alumiar.models.Animal;
import com.project.alumiar.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;
	
	public Iterable<Animal> obterTodos(){
		
		Iterable<Animal> animais = repository.findAll();
		
		return animais;
	}
	
	public Animal salvar(Animal animal) {
		return repository.save(animal);
	}
	
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
	public Animal editar(Long id) {
		return repository.findOne(id);
	}
}
