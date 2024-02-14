<%--
  Created by IntelliJ IDEA.
  User: eddbea
  Date: 09/02/2024
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Accueil du Back Office</title>
</head>
<body>
<h1>OnlineStore - Gestion de la boutique</h1>

    <c:if test="${not empty login}">
    Bonjour ${login} <a href="logout"> (Deconnexion)</a><br/>

</c:if>
        <a href="login.html"> Authentification</a></br>
        <a href="catalogueBackJsp.jsp"> Accès au catalogue</a></br>
        <a href="add-work-form.html"> Ajouter une oeuvre au catalogue</a>

</body>
</html>
