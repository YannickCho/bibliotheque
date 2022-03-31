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
</br></br>

<table border=2>
<tr><td>Emprunteur</td><td>Publication</td><td>Date début</td><td>Date fin</td></tr>
<c:forEach items="${emprunts }" var="emprunt">
<tr><td>
<c:out value="${emprunt.emprunteur.prenom } ${emprunt.emprunteur.nom }"/>
</td><td>
<c:out value="${emprunt.publication.titre }"/>
</td><td>
<c:out value="${emprunt.dateDebut  }"/>
</td><td>
<c:out value="${emprunt.dateFin  }"/>
</td><td>
<c:if test="${emprunt.dateFin ==null}">
<form action="retour" method=post>
<button type=submit name="id" value="${emprunt.id }">Retour</button>
</form>
</c:if>
</td></tr>
</c:forEach>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>