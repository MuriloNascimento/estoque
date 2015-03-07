package com.m104.estoque.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m104.estoque.modelo.entidades.Usuario;
import com.m104.estoque.modelo.repositorios.UsuarioDAO;

@Controller
@RequestMapping("/autenticacao")
public class LoginController {
	
	@Inject
	private UsuarioDAO udao;

	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("tituloPagina", "Faça seu login");
		return "login";
	}
	
	@RequestMapping("/logar")
	public String logar(Usuario usuarioLog, HttpSession session){
		List<Usuario> usuarios = udao.buscarPorLoginSenha(usuarioLog.getLogin(),usuarioLog.getSenha());
		if(!usuarios.isEmpty()){
			session.setAttribute("usuarioLog", usuarioLog);
			return "redirect:http://localhost:8080/estoque/";
		} 
		return "redirect:http://localhost:8080/estoque/autenticacao/login/";
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
	 	return "redirect:http://localhost:8080/estoque/autenticacao/login/";
	}
	
}
