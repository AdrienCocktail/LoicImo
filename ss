[1mdiff --git a/WebContent/WEB-INF/accueil.jsp b/WebContent/WEB-INF/accueil.jsp[m
[1mindex 71fb570..37e15e9 100644[m
[1m--- a/WebContent/WEB-INF/accueil.jsp[m
[1m+++ b/WebContent/WEB-INF/accueil.jsp[m
[36m@@ -1,12 +1,28 @@[m
[31m-<%@ page language="java" contentType="text/html; charset=UTF-8"[m
[31m-    pageEncoding="UTF-8"%>[m
[32m+[m[32m<%@ page pageEncoding="UTF-8" %>[m
[32m+[m[32m<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>[m
 <!DOCTYPE html>[m
 <html>[m
[31m-<head>[m
[31m-<meta charset="UTF-8">[m
[31m-<title>Accueil</title>[m
[31m-</head>[m
[31m-<body>[m
[31m-	Page d'accueil[m
[31m-</body>[m
[32m+[m	[32m<head>[m
[32m+[m		[32m<meta charset="UTF-8">[m
[32m+[m		[32m<title>Accueil</title>[m
[32m+[m		[32m<link type="text/css" rel="stylesheet" href="<c:url value="/inc/Style.css"/>" />[m
[32m+[m	[32m</head>[m
[32m+[m	[32m<body>[m
[32m+[m		[32m<nav class="menu">[m
[32m+[m		[32m  <ul>[m
[32m+[m		[32m    <li>Logo</li>[m
[32m+[m		[32m    <li><a href="#">Accueil</a></li>[m
[32m+[m		[32m    <li><a href="#">À propos</a></li>[m
[32m+[m		[32m    <li><a href="#">Témoignages</a></li>[m
[32m+[m		[32m    <li><a href="#">Formation</a></li>[m
[32m+[m		[32m    <li><a href="#">Plateforme</a></li>[m
[32m+[m		[32m    <li><a href="#">Contact</a></li>[m
[32m+[m		[32m  </ul>[m
[32m+[m		[32m</nav>[m
[32m+[m[41m		[m
[32m+[m		[32m<label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>[m
[32m+[m		[32m<input type="text" id="telephoneClient" name="telephoneClient" value="<c:out value="${2}"/>" size="30" maxlength="30" />[m
[32m+[m[41m	[m
[32m+[m		[32m<p>Page d'accueil</p>[m
[32m+[m	[32m</body>[m
 </html>[m
\ No newline at end of file[m
[1mdiff --git a/WebContent/WEB-INF/web.xml b/WebContent/WEB-INF/web.xml[m
[1mindex 6f41044..b52ddb0 100644[m
[1m--- a/WebContent/WEB-INF/web.xml[m
[1m+++ b/WebContent/WEB-INF/web.xml[m
[36m@@ -1,6 +1,5 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
[31m-<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">[m
[31m- [m
[32m+[m[32m<web-app>[m
 	<servlet>[m
 		<servlet-name>Accueil</servlet-name>[m
 		<servlet-class>com.loicimo.servlets.Accueil</servlet-class>[m
[36m@@ -10,5 +9,11 @@[m
 		<servlet-name>Accueil</servlet-name>[m
 		<url-pattern>/</url-pattern>[m
 	</servlet-mapping>[m
[31m-  [m
[32m+[m[41m	[m
[32m+[m	[32m<jsp-config>[m
[32m+[m		[32m<jsp-property-group>[m
[32m+[m			[32m<url-pattern>*.jsp</url-pattern>[m
[32m+[m			[32m<include-prelude>/WEB-INF/taglibs.jsp</include-prelude>[m
[32m+[m		[32m</jsp-property-group>[m
[32m+[m	[32m</jsp-config>[m
 </web-app>[m
\ No newline at end of file[m
[1mdiff --git a/WebContent/test.html b/WebContent/test.html[m
[1mdeleted file mode 100644[m
[1mindex 1e25c2d..0000000[m
[1m--- a/WebContent/test.html[m
[1m+++ /dev/null[m
[36m@@ -1,10 +0,0 @@[m
[31m-<!DOCTYPE html>[m
[31m-<html>[m
[31m-<head>[m
[31m-<meta charset="UTF-8">[m
[31m-<title>Insert title here</title>[m
[31m-</head>[m
[31m-<body>[m
[31m-	test	test de la branche dev dev[m
[31m-</body>[m
[31m-</html>[m
\ No newline at end of file[m
