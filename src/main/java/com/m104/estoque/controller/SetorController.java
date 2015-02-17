package com.m104.estoque.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m104.estoque.modelo.entidades.Setor;
import com.m104.estoque.modelo.repositorios.SetorDAO;

@Controller
@RequestMapping("/setor")
public class SetorController {

	@Inject
	SetorDAO sdao;
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model){
		model.addAttribute("tituloPagina","Cadastro de Setor");
		return "setor/cadastro";
	}
	
	@RequestMapping("/listagem")
	public String listagem(Model model){
		model.addAttribute("tituloPagina","Listagem de Setor");
		model.addAttribute("setores",sdao.buscartodos());
		return "setor/listagem";
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Setor setor){
		sdao.salvar(setor);
		return "redirect:cadastro";
	}
	
}
