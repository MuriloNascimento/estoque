package com.m104.estoque.modelo.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarOrdenadoPorSetor(int startPosition,int maxResult){
		Query consulta = em.createNamedQuery("Produto.buscarOrdenadoPorSetor");
		consulta.setFirstResult(startPosition);
		consulta.setMaxResults(maxResult);
		return consulta.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscartodosDesc(){
		Query consulta = em.createNamedQuery("Produto.buscarTodosDesc");
		return consulta.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarPorPalvraChave(String palavra){
		Query consulta = em.createNamedQuery("Produto.buscarPorPalavraChave");
		consulta.setParameter("palavra", "%"+palavra+"%");
		return consulta.getResultList();
	}
	
	public Long quantidadeProdutos(){
		TypedQuery<Long> consulta = em.createNamedQuery("Produto.quantidadeProdutos",Long.class);
		return consulta.getSingleResult();
	}
	
}
