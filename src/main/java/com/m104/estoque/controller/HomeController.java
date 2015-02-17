package com.m104.estoque.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.m104.estoque.modelo.repositorios.ProdutoDAO;
import com.m104.estoque.modelo.repositorios.SetorDAO;

@Controller
public class HomeController {
	
	@Inject
	private SetorDAO sdao;

	@Inject
	private ProdutoDAO pdao;

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("setores",sdao.buscartodos());
		model.addAttribute("produtos",pdao.buscartodos());
		model.addAttribute("tituloPagina", "Controle Estoque");
		return "index";
	}
	
	@RequestMapping("/teste")
	public String index(Model model,@RequestParam("teste") String testeA){
		model.addAttribute("teste",testeA);
		return "teste";
	}
	

	public SetorDAO getSdao() {
		return sdao;
	}

	public void setSdao(SetorDAO sdao) {
		this.sdao = sdao;
	}

	public ProdutoDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProdutoDAO pdao) {
		this.pdao = pdao;
	}

}