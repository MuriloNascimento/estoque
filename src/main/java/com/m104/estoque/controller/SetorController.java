package com.m104.estoque.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		Setor setor = new Setor();
		model.addAttribute("setor",setor);
		model.addAttribute("tituloPagina","Cadastro de Setor");
		return "setor/cadastro";
	}
	
	@RequestMapping("/alteracao/{id}")
	public String alterar(Model model,@PathVariable("id") int id){
		Setor setor = sdao.buscarPorId(id);
		model.addAttribute("setor",setor);
		model.addAttribute("tituloPagina","Alteração de Setor");
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
		return "redirect:http://localhost:8080/estoque/setor/cadastro";
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") int id){
		Setor setor = sdao.buscarPorId(id);
		sdao.excluir(setor);
		return "redirect:http://localhost:8080/estoque/setor/listagem";
	}
	
}
