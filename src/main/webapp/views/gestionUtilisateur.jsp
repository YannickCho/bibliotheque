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

<a href="ajoutUtilisateur"><button class="bouton">Ajout d'un utilisateur</button></a>
</br></br>
<a href="listeUtilisateur"><button class="bouton">Liste des utilisateurs</button></a>
</br></br>

</br></br>
<a href="bibliothecaire">Retour</a>

</body>
</html>