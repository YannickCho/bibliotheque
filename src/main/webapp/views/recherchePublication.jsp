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
<body>
<c:if test="${utilisateur != null }">
<div id="id1">
<c:out value="Bonjour ${utilisateur.prenom } ${utilisateur.nom }"/></br>
<a href="deconnect">Déconnexion</a>
</br></br>
</div>
</c:if>
</br></br>

<form action=recherchePublication method="post">
<table>
<tr><td>Type</td>
<td>
<select name="type">
<option value="">-</option>
<option value="LIVRE">Livre</option>
<option value="MAGAZINE">Magazine</option>
<option value="JOURNAL">Journal</option>
</select>
</td><td></td>
<td>Titre</td>
<td><input type="text" name="titre"/>
</td><td></td>
<td>Auteur</td>
<td><input type="text" name="auteur"/>
</td>
</tr>
</table>
</br>
<button class="bouton" type="submit">Recherche</button>

</form>

</br></br>
<table border=2>
<tr><td>Titre</td><td>Auteur</td><td>Année de parution</td><td>Mois de parution</td><td>Jour de parution</td>
<td>Nombre de pages</td><td>Quantité</td></tr>
<c:forEach items="${publications }" var="publication">
<tr><td>
<c:out value="${publication.titre }"/>
</td><td>
<c:if test="${publication.auteur != null }">
<c:out value="${publication.auteur }"/>
</c:if>
</td><td>
<c:out value="${publication.anneePublication }"/>
</td><td>
<c:if test="${publication.getMoisPublication() != 0 }">
<c:out value="${publication.moisPublication }"/>
</c:if>
</td><td>
<c:if test="${publication.jourPublication != 0 }">
<c:out value="${publication.jourPublication }"/>
</c:if>
</td><td>
<c:out value="${publication.nbPages }"/>
</td><td>
<c:out value="${publication.quantite }"/>
</td><td>
<a href="reservation?id=${ publication.id}"><button>Réserver</button></a>
</td></tr>
</c:forEach>
</table>

</br></br>
<a href="emprunteur">Retour</a>
</body>
</html>