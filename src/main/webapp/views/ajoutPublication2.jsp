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
<form action=ajoutPublication2 method=post>
<c:if test="${type == 'livre' }">
<tr><td>Auteur(livre) </td> 
<td><input type=text name="auteur"></td></tr>
</c:if>
<tr><td>Date de publication</td></tr>
<tr><td>Année</td>
<td><input type=text name="annee"></td></tr>
<c:if test="${type == 'magazine' || type == 'journal' }">
<tr><td>Mois</td>
<td>
<select name="mois">
<option value="1">Janvier</option>
<option value="2">Février</option>
<option value="3">Mars</option>
<option value="4">Avril</option>
<option value="5">Mai</option>
<option value="6">Juin</option>
<option value="7">Juillet</option>
<option value="8">Aout</option>
<option value="9">Septembre</option>
<option value="10">Octobre</option>
<option value="11">Novembre</option>
<option value="12">Décembre</option>
</select>
</td></tr>
<c:if test="${type == 'journal' }">
<tr><td>Jour</td>
<td><input type=text name="jour"></td></tr>
</c:if>
</c:if>
<tr><td><button class="bouton" name="id" value="${publication.id }" type=submit>Ajout publication</button></td></tr>
</form>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>