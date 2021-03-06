<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
			<div class="col-md-9">
				
				<div class="bs-example" data-example-id="hoverable-table">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>Login</th>
								<th>Senha</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="usuario" items="${requestScope.usuarios}">
								<tr>
									<td>${usuario.id}</td>
									<td><a href="http://localhost:8080/estoque/usuario/perfil/${usuario.id}">${usuario.nome}</a></td>
									<td>${usuario.login}</td>
									<td>${usuario.senha}</td>
									<td><a href="alteracao/${usuario.id}" class="btn btn-default">Alterar</a> <a href="javascript:func()" onclick="confirmacao(${usuario.id},'usuario')" class="btn btn-default">Deletar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
		
		</div>		
		
	</div>
	
	<c:import url="/WEB-INF/views/base/footer.jsp"></c:import>
	
</body>
</html>