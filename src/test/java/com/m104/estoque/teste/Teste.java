package com.m104.estoque.teste;

import com.m104.estoque.modelo.entidades.Usuario;
import com.m104.estoque.modelo.repositorios.UsuarioDAO;

public class Teste {

	public static void main(String[] args) {
		
		UsuarioDAO udao = new UsuarioDAO();
		
		Usuario usuario = udao.buscaComCriteria();
		
		System.out.println(usuario.getNome());
		
	}

}
