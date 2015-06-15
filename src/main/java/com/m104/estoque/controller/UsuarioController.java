package com.m104.estoque.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.m104.estoque.modelo.entidades.Usuario;
import com.m104.estoque.modelo.repositorios.UsuarioDAO;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Inject
	private UsuarioDAO udao;
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model){
		Usuario usuario = new Usuario();
		model.addAttribute("usuario",usuario);
		model.addAttribute("tituloPagina","Cadastro de Usuario");
		return "usuario/cadastro";
	}
	
	@RequestMapping("/alteracao/{id}")
	public String alterar(Model model,@PathVariable("id") int id){
		Usuario usuario = udao.buscarPorId(id);
		model.addAttribute("usuario",usuario);
		model.addAttribute("tituloPagina","Alteração de Usuario");
		return "usuario/cadastro";
	}
	
	@RequestMapping("/listagem")
	public String listagem(Model model){
		model.addAttribute("tituloPagina","Listagem de Usuario");
		model.addAttribute("usuarios",udao.buscartodos());
		return "usuario/listagem";
	}
	
	@RequestMapping("/perfil/{id}")
	public String perfil(Model model,@PathVariable("id") int id){
		Usuario usuarioPerfil = udao.buscarPorId(id);
		model.addAttribute("usuario",usuarioPerfil);
		model.addAttribute("tituloPagina","Perfil de "+usuarioPerfil.getNome());
		return "usuario/perfil";
	}
	
	@RequestMapping("perfil-criteria")
	public String perfilCriteria(Model model){
		Usuario usuarioPerfil = udao.buscaComCriteria();
		model.addAttribute("usuario",usuarioPerfil);
		model.addAttribute("tituloPagina","Perfil de "+usuarioPerfil.getNome());
		return "usuario/perfil";
	}
	
	@RequestMapping(value="/cadastrar",headers = "content-type=multipart/*")
	public String cadastrar(Usuario usuario,@RequestParam(value="avatar", required=false) MultipartFile avatar){
		
		try {
			byte[] conteudo = avatar.getBytes();
			
			// Creating the directory to store file
            File dir = new File("/home/murilo/workspace/estoque/src/main/webapp/skin/images");
            
            // Create the file on server
            File serverFile = new File(dir + File.separator + usuario.getId() + ".jpg");
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(conteudo);
            stream.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			udao.salvar(usuario);
		}
		
       
		
		return "redirect:http://localhost:8080/estoque/usuario/cadastro";
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") int id){
		Usuario usuario = udao.buscarPorId(id);
		udao.excluir(usuario);
		return "redirect:http://localhost:8080/estoque/usuario/listagem";
	}
	
}
