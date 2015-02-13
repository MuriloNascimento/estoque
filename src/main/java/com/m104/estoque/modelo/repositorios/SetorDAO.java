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
		Setor setorTmp = buscarPorId(setor.getId());
		em.merge(setorTmp);
	}
	
	@Transactional
	public void excluir(Setor setor){
		em.remove(setor);
	}
	
	public Setor buscarPorId(int id){
		return em.find(Setor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Setor> buscartodos(){
		Query consulta = em.createQuery("select s from Setor s");
		return consulta.getResultList();
	}
	
}
