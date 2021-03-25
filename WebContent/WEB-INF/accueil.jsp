<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/Style.css"/>" />
	</head>
	<body>
		<c:import url="/inc/menu.jsp" />
		<div class="spaceComm">
			<c:forEach items="${ Comment }" var="Comment" varStatus="boucle">
				<div class="card">
					<p><c:out value="${ Comment.value.message }"/></p>
					<h1><c:out value="${ Comment.value.firstName } ${ Comment.value.lastName }"/></h1>
				</div>
			</c:forEach>
		</div>
		
	</body>
</html>