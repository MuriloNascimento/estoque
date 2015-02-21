package com.m104.estoque.modelo.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m104.estoque.modelo.entidades.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvar(Produto produto){
		em.merge(produto);
	}
	
	@Transactional
	public void excluir(Produto produto){
		Produto produtoTmp = buscarPorId(produto.getId());
		em.remove(produtoTmp);
	}
	
	public Produto buscarPorId(int id){
		return em.find(Produto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscartodos(){
		Query consulta = em.createNamedQuery("Produto.buscarTodos");
		return consulta.getResultList();
	}
	
}
