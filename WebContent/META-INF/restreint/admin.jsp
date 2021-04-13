<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/Style.css"/>" />
	</head>
	<body>
		<nav class="menu">
			<div>
				<a class="logo" href="#"><img src="https://fontmeme.com/permalink/210318/3383eb2d1c2ef35ec9474a43fa397d97.png" 
				alt="frances-ha-font" border="0" height="20px"></a>
			</div>
			<ul>
				<li><a class="deconnexion" href="./deconnectAdm">Déconnexion</a></li>
			</ul>
		</nav>
		p
		<div class="tableau">
			<table>
			<caption>Liste des massages d'accueil</caption>
			  <tr>
			    <th>ID</th>
			    <th>Nom</th>
			    <th>Prénom</th>
			    <th>Message</th>
			    <th>Email</th>
			    <th>Date</th>  
			    <th>Action</th>
			  </tr>
			  	<c:forEach items="${ Comment }" var="Comment" varStatus="boucle">
				  	<tr class="content">
				  		<td><c:out value="${ Comment.value.ID }"></c:out></td>
				  		<td><c:out value="${ Comment.value.firstName }"></c:out></td>
				  		<td><c:out value="${ Comment.value.lastName }"></c:out></td>
				  		<td><c:out value="${ Comment.value.message }"></c:out></td>
				  		<td><c:out value="${ Comment.value.email }"></c:out></td>
				  		<td><c:out value="11/12/2036"></c:out></td>
				  		<td><a class="delete" href="
          							<c:url value="/adminDeletComm">
          							<c:param name="ID" value="${Comment.value.ID}"/>
		            				</c:url>"></a></td>
				  	</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>