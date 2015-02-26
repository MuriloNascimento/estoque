package com.m104.estoque.modelo.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries ({
	@NamedQuery(name="Setor.buscarTodos",query="select s from Setor s"),
	@NamedQuery(name="Setor.buscarTodosDesc",query="select s from Setor s order by s.id DESC")
})
public class Setor {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	private String nome;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@OneToMany(mappedBy="setor",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
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
