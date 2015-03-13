package com.m104.estoque.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		Produto produto = new Produto();
		model.addAttribute("produto",produto);
		model.addAttribute("setores",sdao.buscartodos());
		model.addAttribute("tituloPagina","Cadastro de Produto");
		return "produto/cadastro";
	}
	
	@RequestMapping("/alteracao/{id}")
	public String cadastro(Model model,@PathVariable("id") int id){
		Produto produto = pdao.buscarPorId(id);
		model.addAttribute("produto",produto);
		model.addAttribute("setores",sdao.buscartodos());
		model.addAttribute("tituloPagina","Cadastro de Produto");
		return "produto/cadastro";
	}
	
	@RequestMapping("/listagem/{page}")
	public String listagem(Model model,@PathVariable("page") int page){
		Long quandidade = pdao.quantidadeProdutos();
		int max = page * 10;
		int min = max - 10;
		List<Produto> produtos = pdao.buscarOrdenadoPorSetor(min,max);
		if(produtos.isEmpty()){
			return "redirect:http://localhost:8080/estoque/produto/listagem/"+(page-1);
		} else {
			model.addAttribute("tituloPagina","Listagem de Produtos");
			model.addAttribute("produtos",produtos);
			model.addAttribute("quantidade",quandidade);
			return "produto/listagem";
		}
	}
	
	@RequestMapping("/busca")
	public String busca(Model model,String palavra){
		model.addAttribute("tituloPagina","Busca de Produto");
		model.addAttribute("produtos",pdao.buscarPorPalvraChave(palavra));
		return "produto/listagem";
	}
	
	@RequestMapping(value="/cadastrar",method=RequestMethod.POST)
	public String cadastrar(@Valid Produto produto, BindingResult result){
		if(result.hasErrors()) {
			return "redirect:cadastro";
		} else {
			pdao.salvar(produto);
			return "redirect:cadastro";
		}
		
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") int id){
		Produto produto = pdao.buscarPorId(id);
		pdao.excluir(produto);
		return "redirect:http://localhost:8080/estoque/produto/listagem/1";
	}
	
}
