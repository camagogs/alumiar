package com.project.alumiar.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ensaio")
public class Ensaio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDoEnsaio;
	
	private String nomDoFotografo;
	
	private String ong;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoEnsaio() {
		return nomeDoEnsaio;
	}

	public void setNomeDoEnsaio(String nomeDoEnsaio) {
		this.nomeDoEnsaio = nomeDoEnsaio;
	}

	public String getNomDoFotografo() {
		return nomDoFotografo;
	}

	public void setNomDoFotografo(String nomDoFotografo) {
		this.nomDoFotografo = nomDoFotografo;
	}

	public String getOng() {
		return ong;
	}

	public void setOng(String ong) {
		this.ong = ong;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
