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
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<div class="succes">
			<c:if test="${!empty sessionScope.succes}">
	    		Votre message a bien été envoyé.
	    		
				<c:remove var="succes" scope="session" />
			</c:if>
		</div>
		
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
		
		<div class="About">
			<div class="Text">
				<h1>ABOUT</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sapien eros, 
				elementum nec enim nec, laoreet pharetra elit. Integer et dignissim neque. 
				Curabitur neque elit, elementum quis purus vitae, tempor mattis nisi.<br><br>
				Nunc ultricies leo at rutrum ultrices. Integer aliquet lorem eget ante efficitur 
				egestas. Etiam in dolor massa. Phasellus vitae scelerisque tortor. Nam quam orci, 
				finibus vitae nibh vitae, tincidunt tincidunt massa. Nunc pretium aliquet congue.<br><br>
				Nam quam orci, finibus vitae nibh vitae, tincidunt tincidunt massa. Nunc pretium aliquet congue.</p>
			</div>
			<div class="Img">
			</div>
		</div>
		
		<div class="img2">
		</div>
		
		<div class="content">
			<div class="bandeau">
				<h1>Formation pour devenir propriétaire</h1>
				<p><a href="#">Débuter facilement</a></p>
			</div>
		</div>
		
		<div class="spaceComm">
			<c:forEach items="${ Comment }" var="Comment" varStatus="boucle">
				<div class="card">
					<p><c:out value="${ Comment.value.message }"/></p>
					<h1><c:out value="${ Comment.value.firstName } ${ Comment.value.lastName }"/></h1>
				</div>
			</c:forEach>
		</div>
		
		<form class="commentForm" method="post" action="accueil">
			<input type="text" id="prenom" name=prenom placeholder="Prénom" size="40" maxlength="10" />
			<input type="text" id="nom" name=nom placeholder="Nom" size="40" maxlength="10" />
			<textarea id="commentaire" name=commentaire placeholder="commentaire" rows="5" cols="33"></textarea>
			<input type="text" id="email" name=email placeholder="email" size="40" maxlength="40" />
			
			<input class="btn" type="submit" value="Envoyer" class="sansLabel" />
			<span class="erreur">${commAccueilForm.erreurs['prenom']}
								${commAccueilForm.erreurs['nom']}
								${commAccueilForm.erreurs['commentaire']}
								${commAccueilForm.erreurs['email']}</span>
		</form>
		
	</body>
	<footer>
	</footer>
</html>