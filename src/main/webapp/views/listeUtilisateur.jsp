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
<tr><td>Nom</td><td>Prénom</td><td>Login</td><td>Adresse mail</td></tr>
<c:forEach items="${utilisateurs }" var="user">
<tr><td>
<c:out value="${user.nom }"/>
</td><td>
<c:out value="${user.prenom }"/>
</td><td>
<c:out value="${user.login }"/>
</td><td>
<c:out value="${user.mail }"/>
</td><td>
<a href="majUtilisateur?id=${ user.id}"><button>Modifier</button></a>
</td><td>
<c:if test="${user.id != utilisateur.id }">
<a href="suppUtilisateur?id=${ user.id}"><button>Supprimer</button></a>
</c:if>
</td></tr>
</c:forEach>
</table>

</br></br>
<a href="bibliothecaire">Retour</a>
</body>
</html>