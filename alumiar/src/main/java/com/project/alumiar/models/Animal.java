package com.project.alumiar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	private String nome;
	
	private String raca;
	
	private String pathFoto;
	
	private String isAdotado;
	
	private Boolean statusAdocao = false;

	@Column(name= "tipo_animal")
	private String tipoAnimal;
	
	@Column(name="faixa_etaria")
	private String idade;
	
	@Column(name="tipo_pelagem")
	private String pelagem;
	
	private String sexo;
	
	private String descricao;
	
	private String cuidados;
	
	public Animal() {
		
	}
	
	public Animal(String nome, String raca, String pathFoto, String tipoAnimal, String idade, String pelagem,
			String sexo, String descricao, String cuidados, String isAdotado) {
		this.nome = nome;
		this.raca = raca;
		this.pathFoto = pathFoto;
		this.tipoAnimal = tipoAnimal;
		this.idade = idade;
		this.pelagem = pelagem;
		this.sexo = sexo;
		this.descricao = descricao;
		this.cuidados = cuidados;
		this.isAdotado = isAdotado;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIsAdotado() {
		return isAdotado;
	}

	public void setIsAdotado(String isAdotado) {
		
		if(isAdotado == "Adotado")
			this.statusAdocao = true;
		
		this.isAdotado = isAdotado;
	}

	public Boolean getStatusAdocao() {
		return statusAdocao;
	}

	public void setStatusAdocao(Boolean statusAdocao) {
		this.statusAdocao = statusAdocao;
	}
}
