<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/Style.css"/>" />
    </head>
    <body class="connection">
        <form class="connectForm" method="post" action="connectAdm">
            <fieldset class="fieldset">
            
            	<h1>ESPACE ADMIN</h1>

                <input type="text" id="pseudo" name="pseudo" placeholder="Pseudo" size="40" maxlength="10" />
                <span class="erreurAdm">${adminForm.erreurs['pseudo']}</span>
                <br />

                <input type="password" id="password" name="password" placeholder="Password" size="20" maxlength="20" />
                <span class="erreurAdm">${adminForm.erreurs['password']}</span>
                <br />

                <input class="btn" type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="erreurAdm">${adminForm.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>