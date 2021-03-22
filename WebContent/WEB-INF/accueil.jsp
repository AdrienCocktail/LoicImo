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
		<nav class="menu">
			<div>
				<a class="logo" href="#"><img src="https://fontmeme.com/permalink/210318/3383eb2d1c2ef35ec9474a43fa397d97.png" 
				alt="frances-ha-font" border="0" height="20px"></a>
			</div>
			<ul>
				<li><a class="accueil" href="#">Accueil</a></li>
				<li><a class="a_propos" href="#">À propos</a></li>
				<li><a class="temoignages" href="#">Témoignages</a></li>
				<li><a class="formation" href="#">Formation</a></li>
				<li><a class="contact" href="#">Contact</a></li>
			</ul>
		</nav>
		
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