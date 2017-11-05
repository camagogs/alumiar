package com.project.alumiar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum TipoPorte { PEQUENO, MEDIO, GRANDE };
enum Idade { FILHOTE, ADULTO, IDOSO };

@Entity(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	private String nome;
	
	private String tipoAnimal;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "porte_animal")
	private TipoPorte porte;
	
	@Enumerated(EnumType.STRING)
	@Column(name="faixa_idade")
	private Idade idade;
	
	private char sexo;
	
	private String descricao;
	
	public Animal() {
		
	}

	public Animal(Long id, String nome, String tipoAnimal, TipoPorte porte, Idade idade, char sexo, String descricao) {
		this.id = id;
		this.nome = nome;
		this.tipoAnimal = tipoAnimal;
		this.porte = porte;
		this.idade = idade;
		this.sexo = sexo;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPorte getPorte() {
		return porte;
	}

	public void setPorte(TipoPorte porte) {
		this.porte = porte;
	}

	public Idade getIdade() {
		return idade;
	}

	public void setIdade(Idade idade) {
		this.idade = idade;
	}
}
