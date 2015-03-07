package com.m104.estoque.modelo.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m104.estoque.modelo.entidades.Usuario;

@Repository
@SuppressWarnings("unchecked")
public class UsuarioDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvar(Usuario usuario){
		em.merge(usuario);
	}
	
	@Transactional
	public void excluir(Usuario usuario){
		Usuario usuarioTmp = buscarPorId(usuario.getId());
		em.remove(usuarioTmp);
	}
	
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	
	
	public List<Usuario> buscartodos(){
		Query consulta = em.createNamedQuery("Usuario.buscarTodos");
		return consulta.getResultList();
	}
	
	public List<Usuario> buscarPorLoginSenha(String login,String senha){

		Query consulta = em.createNamedQuery("Usuario.logar");
		consulta.setParameter("login", login);
		consulta.setParameter("senha", senha);
		
		return consulta.getResultList();
		
	}
	
}
