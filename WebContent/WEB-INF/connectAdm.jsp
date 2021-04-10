<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/Style.css"/>" />
    </head>
    <body>
        <form method="post" action="connectAdm">
            <fieldset>
                <legend>Connexion</legend>

                <label for="text">Pseudo <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" size="20" maxlength="60" />
                <span class="erreur">${adminForm.erreurs['pseudo']}</span>
                <br />

                <label for="password">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="erreur">${adminForm.erreurs['password']}</span>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>