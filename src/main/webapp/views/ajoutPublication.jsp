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

<h1>Nouvelle publication</h1>
<table>
<form action=ajoutPublication method=post>
<tr><td>Type </td>
<td><select name="type">
<option value="livre">Livre</option>
<option value="magazine">Magazine</option>
<option value="journal">Journal</option>
</select></td></tr>
<tr><td>Titre </td> 
<td><input type=text name="titre"></td></tr>

<tr><td>Nombre de pages</td> 
<td><input type=text name="nbPages"></td></tr>


<tr><td>Quantité</td> 
<td><input type=text name="quantite"></td></tr>
<tr><td><button class="bouton" type=submit>Suivant</button></td></tr>
</form>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>