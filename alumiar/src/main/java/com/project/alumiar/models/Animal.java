package com.project.alumiar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum TipoAnimal { CACHORRO, GATO };
enum Idade { FILHOTE, ADULTO, IDOSO };
enum Pelagem { CURTA, MEDIA, LONGA };

@Entity(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	private String nome;
	
	private String pathFoto;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "tipo_animal")
	private TipoAnimal animal;
	
	@Enumerated(EnumType.STRING)
	@Column(name="faixa_etaria")
	private Idade idade;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_pelagem")
	private Pelagem pelagem;
	
	private char sexo;
	
	private String descricao;
	
	private String cuidados;
	
	public Animal() {
		
	}
	
	public Animal(Long id, String nome, TipoAnimal animal, Idade idade, Pelagem pelagem, char sexo,
			String descricao, String cuidados) {
		this.id = id;
		this.nome = nome;
		this.animal = animal;
		this.idade = idade;
		this.pelagem = pelagem;
		this.sexo = sexo;
		this.descricao = descricao;
		this.cuidados = cuidados;
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

	public TipoAnimal getAnimal() {
		return animal;
	}

	public void setAnimal(TipoAnimal animal) {
		this.animal = animal;
	}

	public Idade getIdade() {
		return idade;
	}

	public void setIdade(Idade idade) {
		this.idade = idade;
	}

	public Pelagem getPelagem() {
		return pelagem;
	}

	public void setPelagem(Pelagem pelagem) {
		this.pelagem = pelagem;
	}

	public String getCuidados() {
		return cuidados;
	}

	public void setCuidados(String cuidados) {
		this.cuidados = cuidados;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}	
}
