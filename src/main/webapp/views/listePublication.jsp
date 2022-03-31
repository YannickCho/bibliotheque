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
<body>
<c:if test="${utilisateur != null }">
<div id="id1">
<c:out value="Bonjour ${utilisateur.prenom } ${utilisateur.nom }"/></br>
<a href="deconnect">Déconnexion</a>
</br></br>
</div>
</c:if>
</br></br>

<table border=2>
<tr><td>Titre</td><td>Auteur</td><td>Année de parution</td><td>Mois de parution</td><td>Jour de parution</td><td>Nombre de pages</td><td>Quantité</td></tr>
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
<a href="majPublication?id=${ publication.id}"><button>Modifier</button></a>
</td><td>
<a href="suppPublication?id=${ publication.id}"><button>Supprimer</button></a>

</td></tr>
</c:forEach>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>