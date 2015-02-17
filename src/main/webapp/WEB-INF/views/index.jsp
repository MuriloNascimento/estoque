<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="base/head.jsp"></c:import>
<body>

	<c:import url="base/header.jsp"></c:import>

	<div class="container">
	
		<div class="row">

			<div class="col-md-6">
			
				<div class="bs-example" data-example-id="hoverable-table">
					<div class="page-header">
					  <h4><small>Ultimos setores cadastrados</small></h4>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="setor" items="${requestScope.setores}">
								<tr>
									<td>${setor.id}</td>
									<td>${setor.nome}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
			</div>
			
			<div class="col-md-6">
				
				<div class="bs-example" data-example-id="hoverable-table">
					<div class="page-header">
					  <h4><small>Ultimos produtos cadastrados</small></h4>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>Setor</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="produto" items="${requestScope.produtos}">
								<tr>
									<td>${produto.id}</td>
									<td>${produto.nome}</td>
									<td>${produto.setor.nome}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
		
		</div>
		
	</div>
	
	<c:import url="base/footer.jsp"></c:import>
	
</body>
</html>