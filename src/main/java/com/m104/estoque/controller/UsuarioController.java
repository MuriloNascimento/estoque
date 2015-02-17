package com.m104.estoque.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m104.estoque.modelo.entidades.Usuario;
import com.m104.estoque.modelo.repositorios.UsuarioDAO;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Inject
	private UsuarioDAO udao;
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model){
		model.addAttribute("tituloPagina","Cadastro de Usuario");
		return "usuario/cadastro";
	}
	
	@RequestMapping("/listagem")
	public String listagem(Model model){
		model.addAttribute("tituloPagina","Listagem de Usuario");
		model.addAttribute("usuarios",udao.buscartodos());
		return "usuario/listagem";
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Usuario usuario){
		udao.salvar(usuario);
		return "redirect:cadastro";
	}
	
}
