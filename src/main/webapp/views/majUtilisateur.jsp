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
</br></br>

<h1>Modification utilisateur</h1>
<table>
<form action=majUtilisateur method=post>
<tr><td>Login </td> 
<td><c:out value="${u.login }"/></td></tr>
<tr><td>Nom </td> 
<td><input type=text name=nom value="${u.nom }"></td></tr>
<tr><td>Prénom </td> 
<td><input type=text name=prenom value="${u.prenom }"></td></tr>
<tr><td>Mail  </td>
<td><input type=text name=mail value="${u.mail }"></td></tr>
<tr><td>Mot de passe </td> 
<td><input type=password name=pwd value="${u.password }"></td></tr>

<tr><td><button class="bouton" name="id" value="${u.id }" type=submit>Maj utilisateur</button></td></tr>
</form>
</table>
</body>
</html>