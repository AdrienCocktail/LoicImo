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
		p
		<div class="containerSEI">
			<c:if test="${!empty sessionScope.succes}">
				<div class="succes">
		    		Votre message a bien été envoyé.
					<c:remove var="succes" scope="session" />
					<div class="deleteSucc">
						<a href="http://localhost:8080/LoicImo/accueil"></a>
					</div>
				</div>
			</c:if>
			
			<c:if test="${!empty commAccueilForm.erreurs}">
				<div class="erreur">
					<span>	
						${commAccueilForm.erreurs['prenom']}
						${commAccueilForm.erreurs['nom']}
						${commAccueilForm.erreurs['commentaire']}
						${commAccueilForm.erreurs['email']}
						<br>
						<div class="backForm"><a href="#form">Revenir au formulaire</a></div>
					</span>
					<div class="deleteErr">
						<a href="http://localhost:8080/LoicImo/accueil"></a>
					</div>
				</div>
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
		
		<div class="containerCommentForm" id="form">
			<form class="commentForm" method="post" action="accueil">
				<div class="row1">
					<input class="${!empty commAccueilForm.erreurs['prenom'] ? 'erreurs' : 'neutre' }" type="text" id="prenom" 
						name=prenom value="${commAccueil.firstName}" placeholder="Prénom" size="40" maxlength="10" required/>
					<input class="${!empty commAccueilForm.erreurs['nom'] ? 'erreurs' : 'neutre' }" type="text" id="nom" 
						name=nom value="${commAccueil.lastName}" placeholder="Nom" size="40" maxlength="10" required/>
				</div>
				<div class="row2">
					<input class="${!empty commAccueilForm.erreurs['email'] ? 'erreurs' : 'neutre' }" type="text" id="email" 
						name=email value="${commAccueil.email}" placeholder="Email" size="40" maxlength="40" required/>
				</div>
				<div class="row3">
					<textarea class="${!empty commAccueilForm.erreurs['commentaire'] ? 'erreurs' : 'neutre' }" id="commentaire" 
						name=commentaire placeholder="Commentaire" rows="5" cols="33" required>${commAccueil.message}</textarea>
				</div>
				<div class="row4">
					<input class="btn" type="submit" value="Envoyer" class="sansLabel" />
				</div>
			</form>
		</div>
		
	</body>
	<footer>
	</footer>
</html>