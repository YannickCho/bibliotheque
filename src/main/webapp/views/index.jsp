<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${utilisateur != null }">
<div id="id1">
<c:out value="Bonjour ${utilisateur.prenom } ${utilisateur.nom }"/></br>
<a href="deconnect">Déconnexion</a>
</br></br>
</div>
</c:when>
<c:otherwise>
<h1>Authentification</h1>

<table>
<form action=connexion method=post>
<tr><td>Login :</td> 
<td><input type=text name=login></td></tr>
<tr><td>Mot de passe :</td> 
<td><input type=password name=pwd></td></tr>
<tr><td><button class="bouton" type=submit>Connexion</button></td></tr>
</form>
</table>

<c:out value="${erreur }"/>

<br><br>

</c:otherwise>
</c:choose>
</body>
</html>