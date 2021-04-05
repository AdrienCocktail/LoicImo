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
		
		<div class="trio">
			<div class="trio_1">
				<div class="imgBoussole">
				</div>
				<h1>Eviter les Pièges</h1>
				<p>Accedat huc suavitas quaedam oportet sermonum atque morum, haudquaquam 
				mediocre condimentum amicitiae. Tristitia autem et in omni re severitas </p>
			</div>
			<div class="trio_2">
				<div class="Negocier">
				</div>
				<h1>Negocier</h1>
				<p>Accedat huc suavitas quaedam oportet sermonum atque morum, haudquaquam mediocre 
				condimentum amicitiae. Tristitia autem et in omni re severitas habet illa quidem 
				gravitatem, sed amicitia remissior esse gravitatem, sed amicitia remissior esse</p>
			</div>
			<div class="trio_3">
				<div class="Methodologie">
				</div>
				<h1>Méthodologie</h1>
				<p>Accedat huc suavitas quaedam oportet sermonum atque morum, haudquaquam mediocre 
				condimentum amicitiae. Tristitia autem et in omni re severitas habet illa quidem 
				gravitatem, sed amicitia remissior esse</p>
			</div>
		</div>
		
		<div class="img">
		</div>
		
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