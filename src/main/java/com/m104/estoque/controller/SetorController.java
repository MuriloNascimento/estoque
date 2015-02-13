package com.m104.estoque.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m104.estoque.modelo.entidades.Setor;
import com.m104.estoque.modelo.repositorios.SetorDAO;

@Controller
@RequestMapping("/setor")
public class SetorController {

	@Inject
	SetorDAO sdao;
	
	@RequestMapping("/cadastrar")
	public String cadastro(){
		Setor setor = new Setor();
		setor.setNome("Geladeira");
		sdao.salvar(setor);
		return "cadastro";
	}
	
}
