<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="agora" class="java.util.Date"/>


<c:import url="/WEB-INF/views/base/head.jsp"></c:import>
<body>

	<c:import url="/WEB-INF/views/base/header.jsp"></c:import>

	<div class="container">
	
		<div class="row">
		
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
	                <li class=""><a href="http://localhost:8080/estoque/produto/cadastro" class="list-group-item">Cadastrar</a></li>
	                <li class=""><a href="http://localhost:8080/estoque/produto/listagem/1" class="list-group-item">Listar</a></li>
	            </ul>
			</div>
			<div class="col-md-9">
				
				<sf:form class="form-horizontal" action="http://localhost:8080/estoque/produto/cadastrar" commandName="produto">
				  <fieldset>
				    <legend>Cadastro de Produto</legend>
				    
				    <input type="hidden" value="${requestScope.produto.id}" name="id">
				    <div class="form-group">
				      <label for="inputNome" class="col-lg-2 control-label">Nome</label>
				      <div class="col-lg-10">
				      	<sf:errors path="nome"/>
				        <input type="text" name="nome" value="${requestScope.produto.nome}" class="form-control" id="inputNome" placeholder="Nome">
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="select" class="col-lg-2 control-label">Setor</label>
				      <div class="col-lg-10">
				      	<select class="form-control" id="select" name="setor" >
				      		<option value="" disabled selected>Escolha um setor</option>
				        	<c:forEach var="setor" items="${requestScope.setores}">	
				          		<option value="${setor.id}" ${requestScope.produto.setor.id == setor.id ? 'selected' : ''}>${setor.nome}</option>
				      		</c:forEach>
				      	</select>
				      </div>
				    </div>
				    <div class="form-group">
				      <div class="col-lg-10 col-lg-offset-2">
				        <button type="reset" class="btn btn-default">Cancel</button>
				        <button type="submit" class="btn btn-primary">Submit</button>
				      </div>
				    </div>
				  </fieldset>
				</sf:form>
				
				
			</div>
			
		</div>		
		
	</div>
	
	<c:import url="/WEB-INF/views/base/footer.jsp"></c:import>
	
</body>
</html>