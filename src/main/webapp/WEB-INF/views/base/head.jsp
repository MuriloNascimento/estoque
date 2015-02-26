<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.2/paper/bootstrap.min.css">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<title>${requestScope.tituloPagina}</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
	<link rel="stylesheet" href="http://localhost:8080/estoque/skin/css/estilo.css">
	<script>jQuery.noConflict();</script>
	<script>
	jQuery(document).ready(function(){
		
		
		
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
		
		var pagina = ${page};
		if(pagina == 1){
			jQuery(".retornar").parent().addClass("disabled");
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

</head>