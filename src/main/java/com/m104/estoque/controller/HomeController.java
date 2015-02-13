package com.m104.estoque.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.m104.estoque.modelo.repositorios.SetorDAO;

@Controller
public class HomeController {
	
	@Inject
	SetorDAO sdao;
	
	@Inject
	UsuarioDAO udao;
	
}
