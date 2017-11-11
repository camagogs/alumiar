package com.project.alumiar.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.alumiar.models.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
	
	//public void createAnimal(String nome, );
	
}
