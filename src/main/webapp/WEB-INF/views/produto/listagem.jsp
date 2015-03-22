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
	                <li class=""><a href="http://localhost:8080/estoque/produto/cadastro" class="list-group-item">Cadastrar</a></li>
	                <li class=""><a href="http://localhost:8080/estoque/produto/listagem/1" class="list-group-item">Listar</a></li>
	            </ul>
			</div>
			<div class="col-md-9">
				
				<div class="bs-example" data-example-id="hoverable-table">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>Setor</th>
								<th>Alterado em</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="produto" items="${requestScope.produtos}">
								<tr class="">
									<td>${produto.id}</td>
									<td>${produto.nome}</td>
									<td>${produto.setor.nome}</td>
									<td>${produto.data}</td>
									<td><a href="http://localhost:8080/estoque/produto/alteracao/${produto.id}" class="btn btn-default">Alterar</a> <a href="javascript:func()" onclick="confirmacao(${produto.id},'produto')" class="btn btn-default">Deletar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div>
					<ul class="pagination pagination-sm">
					  <li><a href="javascript:function();" class="retornar">«</a></li>
					  <li><a href="javascript:function();" class="avancar" >»</a></li>
					</ul>
					<p>${requestScope.quantidade} produtos cadastrados</p>
				</div>
				
			</div>
		
		</div>		
		
	</div>
	
	<c:import url="/WEB-INF/views/base/footer.jsp"></c:import>
	
	<script>
	
	jQuery(document).ready(function(){
		
		var pagina = ${page};
		if(pagina == 1){
			jQuery(".retornar").parent().addClass("disabled");
		}
		
		function confirmacao(id,classe){
			var r = confirm("Deseja excluir?");
		    if (r == true) {
		    	window.location.href = "http://localhost:8080/estoque/"+classe+"/deletar/"+id;
		    }
		}
		
		var avancar = function(pagina){
			pagina++;
			window.location.href = "http://localhost:8080/estoque/produto/listagem/"+pagina;
		}
		
		var retornar = function(pagina){
			if(pagina > 1){
				pagina--;
				window.location.href = "http://localhost:8080/estoque/produto/listagem/"+pagina;
			} 
		}
		
		jQuery(".avancar").click(function(){
			var pagina = ${page};
			avancar(pagina);
		});
		
		jQuery(".retornar").click(function(){
			var pagina = ${page};
			retornar(pagina);
		});
		
	})
	</script>
</body>
</html>