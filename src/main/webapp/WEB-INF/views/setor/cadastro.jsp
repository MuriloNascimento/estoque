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
	                <li class=""><a href="http://localhost:8080/estoque/setor/cadastro" class="list-group-item">Cadastrar</a></li>
	                <li class=""><a href="http://localhost:8080/estoque/setor/listagem" class="list-group-item">Listar</a></li>
	            </ul>
			</div>
			<div class="col-md-9">
				
				<form class="form-horizontal" action="cadastrar">
				  <fieldset>
				    <legend>Cadastro de Setor</legend>
				    <div class="form-group">
				      <label for="inputNome" class="col-lg-2 control-label">Nome</label>
				      <div class="col-lg-10">
				        <input type="text" name="nome" class="form-control" id="inputNome" placeholder="Nome">
				      </div>
				    </div>
				    <div class="form-group">
				      <div class="col-lg-10 col-lg-offset-2">
				        <button type="reset" class="btn btn-default">Cancel</button>
				        <button type="submit" class="btn btn-primary">Submit</button>
				      </div>
				    </div>
				  </fieldset>
				</form>
			</div>
		
		</div>		
		
	</div>
	
	<c:import url="/WEB-INF/views/base/footer.jsp"></c:import>
	
</body>
</html>