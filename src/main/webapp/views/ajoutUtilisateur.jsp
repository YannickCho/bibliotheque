<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${utilisateur != null }">
<div id="id1">
<c:out value="Bonjour ${utilisateur.prenom } ${utilisateur.nom }"/></br>
<a href="deconnect">Déconnexion</a>
</br></br>
</div>
</c:if>

<h1>Nouvel utilisateur</h1>
<table>
<form action=ajoutUtilisateur method=post>
<tr><td>Nom </td> 
<td><input type=text name=nom></td></tr>
<tr><td>Prénom </td> 
<td><input type=text name=prenom></td></tr>
<tr><td>Mail  </td>
<td><input type=text name=mail></td></tr>
<tr><td>Login </td> 
<td><input type=text name=login></td></tr>
<tr><td>Mot de passe </td> 
<td><input type=password name=pwd></td></tr>
<tr><td>Bibliothécaire </td>
<td><input type="checkbox" name="type"></td></tr>
<tr><td><button class="bouton" type=submit>Ajout utilisateur</button></td></tr>
</form>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>