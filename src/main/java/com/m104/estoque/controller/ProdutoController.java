package com.m104.estoque.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m104.estoque.convertion.SetorConvertion;
import com.m104.estoque.modelo.entidades.Produto;
import com.m104.estoque.modelo.entidades.Setor;
import com.m104.estoque.modelo.repositorios.ProdutoDAO;
import com.m104.estoque.modelo.repositorios.SetorDAO;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Inject
	private ProdutoDAO pdao;
	
	@Inject
	private SetorDAO sdao;
	
	@InitBinder
	public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		binder.registerCustomEditor(Setor.class, new SetorConvertion(this.sdao));
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model){
		model.addAttribute("setores",sdao.buscartodos());
		model.addAttribute("tituloPagina","Cadastro de Produto");
		return "produto/cadastro";
	}
	
	@RequestMapping("/listagem")
	public String listagem(Model model){
		model.addAttribute("tituloPagina","Listagem de Produtos");
		model.addAttribute("produtos",pdao.buscartodos());
		return "produto/listagem";
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Produto produto){
		pdao.salvar(produto);
		return "redirect:cadastro";
	}
	
}
