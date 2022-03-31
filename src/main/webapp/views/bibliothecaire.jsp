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

<a href="gestionUtilisateur"><button class="bouton">Gestion des utilisateurs</button></a>
</br></br>
<a href="gestionPublication"><button class="bouton">Gestion des publications</button></a>
</br></br>
<a href="gestionEmprunt"><button class="bouton">Gestion des emprunts</button></a>
</br></br>

</body>
</html>