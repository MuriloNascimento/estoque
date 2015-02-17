<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="base/head.jsp"></c:import>
<body>

	<c:import url="base/header.jsp"></c:import>

	<div class="container">
	
		${requestScope.teste}
		
	</div>
	
	<c:import url="base/footer.jsp"></c:import>
	
</body>
</html>