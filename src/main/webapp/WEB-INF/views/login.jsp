<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="base/head.jsp"></c:import>
<body>

	
		<div class="panel panel-primary login-panel">
			  <div class="panel-heading">
			    	<h3 class="panel-title">Faça seu login</h3>
			  </div>
			  <div class="panel-body">
				    <form class="form-signin" action="http://localhost:8080/estoque/autenticacao/logar/" method="post">
				       
				        <input type="text" id="inputLogin" class="form-control" placeholder="Login" name="login" required="required" autofocus="autofocus">
				        <input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="senha" required="required">
				        <button class="btn btn-primary btn-block botao-login" type="submit">Entrar</button>
				       
				  	</form>
			  </div>
		</div>
		
	
</body>
</html>