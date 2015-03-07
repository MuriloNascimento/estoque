package com.m104.estoque.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		
		if(uri.endsWith("login/") || uri.endsWith("logar/") || uri.contains("skin")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLog") != null) {
			return true;
		}
		
		
		response.sendRedirect("http://localhost:8080/estoque/autenticacao/login/");
	    return false;
		
	}
	
	

}
