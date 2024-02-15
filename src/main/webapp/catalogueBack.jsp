<%@ page import="com.directmedia.onlinestore.core.entity.Catalogue" %>
<%@ page import="com.directmedia.onlinestore.core.entity.Artist" %>
<%@ page import="com.directmedia.onlinestore.core.entity.Work" %><%--
  Created by IntelliJ IDEA.
  User: eddbea
  Date: 10/02/2024
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Catalogue BackOffice</title>
</head>
<body>

<h1>Oeuvres au Calalogue :</h1>

<c:forEach items="${Catalogue.listOfWorks}" var="Liste">
    ${Liste.title}
    ${Liste.mainArtist.name}
    (${Liste.release})<br>
</c:forEach>
<br/>
<a href="add-work-form.html">Ajouter une oeuvre au catalogue</a><br/>
<a href="homeBack.jsp">Retournez a l'accueil</a>
</body>
</html>
