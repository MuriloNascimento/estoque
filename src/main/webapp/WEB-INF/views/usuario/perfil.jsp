<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/views/base/head.jsp"></c:import>
<body>

	<c:import url="/WEB-INF/views/base/header.jsp"></c:import>

	<div class="container">
	
		<div class="row">
		
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
	                <li class=""><a href="http://localhost:8080/estoque/usuario/cadastro" class="list-group-item">Cadastrar</a></li>
	                <li class=""><a href="http://localhost:8080/estoque/usuario/listagem" class="list-group-item">Listar</a></li>
	            </ul>
			</div>
			<div class="col-md-9 perfil">
				
				<div class="container-fluid">
					  		
					  <div class="row">
					  			
						  	<div class="col-md-3">

						  		<img class="avatar" src='<c:url value="http://localhost:8080/estoque/skin/images/${requestScope.usuario.id}.jpg"/>'/>

						  	</div>
						  			
				  			<div class="col-md-9">
				  				<h3>${requestScope.usuario.nome}</h3>
				  				<p>Login: ${requestScope.usuario.login}</p>
				  			</div>
					  			
					  </div>
					  
				</div>
					
			</div>

		</div>		
		
	</div>
	
	<c:import url="/WEB-INF/views/base/footer.jsp"></c:import>
	
</body>
</html>