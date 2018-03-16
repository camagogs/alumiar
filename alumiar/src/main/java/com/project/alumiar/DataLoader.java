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
//		Animal a = new Animal();
//		
//		a.setNome("Billy");
//		a.setTipoAnimal("Cachorro");
//		a.setRaca("Labrador");
//		a.setSexo("Macho");
//		a.setIsAdotado("Não Adotado");
//		a.setCuidados("Ração especial sem glúten");
//		a.setIdade("Filhote");
//		a.setDescricao("Billy é um cachorro dócil e brincalhão, gosta de passear e brincar com sua bola.");
//		a.setPelagem("Curta");
//		a.setPathFoto("dog.jpg");
//		
//		Animal g = new Animal();
//		
//		g.setNome("Belinha");
//		g.setTipoAnimal("Gato");
//		g.setRaca("Indefinido");
//		g.setSexo("Fêmea");
//		g.setIsAdotado("Não Adotado");
//		g.setCuidados("Ração especial sem glúten");
//		g.setIdade("Adulto");
//		g.setDescricao("Belinha é uma gata dócil.");
//		g.setPelagem("Longa");
//		g.setPathFoto("cat.png");
//		
//		repository.save(a);
//		
//		repository.save(g);
		
	}
}
