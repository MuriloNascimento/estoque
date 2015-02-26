package com.m104.estoque.modelo.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m104.estoque.modelo.entidades.Setor;

@Repository
public class SetorDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvar(Setor setor){
		em.merge(setor);
	}
	
	@Transactional
	public void excluir(Setor setor){
		Setor setorTmp = buscarPorId(setor.getId());
		em.remove(setorTmp);
	}
	
	public Setor buscarPorId(int id){
		return em.find(Setor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Setor> buscartodos(){
		Query consulta = em.createNamedQuery("Setor.buscarTodos");
		return consulta.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Setor> buscartodosDesc(){
		Query consulta = em.createNamedQuery("Setor.buscarTodosDesc");
		return consulta.getResultList();
	}
	
}
