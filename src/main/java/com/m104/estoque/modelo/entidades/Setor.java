package com.m104.estoque.modelo.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Setor {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Preencha o nome.")
	private String nome;
	
	@OneToMany(mappedBy="setor",fetch=FetchType.LAZY)
	private List<Produto> produtos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
