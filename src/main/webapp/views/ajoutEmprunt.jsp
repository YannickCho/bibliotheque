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
<c:if test="${utilisateur != null }">
<div id="id1">
<c:out value="Bonjour ${utilisateur.prenom } ${utilisateur.nom }"/></br>
<a href="deconnect">Déconnexion</a>
</br></br>
</div>
</c:if>

<h1>Nouvel emprunt</h1>
<table>
<form action=ajoutEmprunt method=post>
<tr><td>Emprunteur </td> 
<td><select name="idEmprunteur">
<c:forEach items="${ emprunteurs}" var="emprunteur">
<option value="${emprunteur.id }"><c:out value="${emprunteur.prenom } ${emprunteur.nom }"/></option>
</c:forEach>
</select>
</td></tr>
<tr><td>Publication </td>
<td><select name="idPublication">
<c:forEach items="${ publications}" var="publication">
<c:if test="${publication.quantite>0 }">
<option value="${publication.id }"><c:out value="${publication.titre } "/></option>
</c:if>
</c:forEach>
</select>

<tr><td><button class="bouton" type=submit>Création emprunt</button></td></tr>
</form>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>