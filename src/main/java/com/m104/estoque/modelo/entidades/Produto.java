package com.m104.estoque.modelo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@NamedQueries ({
	@NamedQuery(name="Produto.buscarTodos",query="select p from Produto p"),
	@NamedQuery(name="Produto.buscarOrdenadoPorSetor",query="select p from Produto p order by p.setor"),
	@NamedQuery(name="Produto.buscarPorPalavraChave",query="select p from Produto p where p.nome LIKE :palavra"),
	@NamedQuery(name="Produto.quantidadeProdutos",query="select COUNT(p) from Produto p"),
	@NamedQuery(name="Produto.buscarTodosDesc",query="select p from Produto p order by p.id DESC")
})
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message="Faltou o produto")
	@Size(min=3)
	@Column(length=30,nullable=false,unique=true)
	private String nome;
	
	@NotNull(message="Faltou o setor")
	@JoinColumn
	@ManyToOne 
	private Setor setor;
	
	@Temporal(value=TemporalType.DATE)
	private Date data = new Date();
	
	@Temporal(value=TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date validade;
	
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getData() {
		return data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
}
