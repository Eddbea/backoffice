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
<html>
<head>
    <title>Back-office-Catalogue</title>
</head>
<body>
<%
    if (Catalogue.listOfWorks.isEmpty()) {
        Artist tomCruise = new Artist("Tom Cruise");
        Artist leonardoDiCaprio = new Artist("Leonardo Di Caprio");
        Artist louisDeFunes = new Artist("Louis de Funes");

        Work minorityReport = new Work("Minority Report");
        Work bad = new Work("Bad");
        Work leGendarmeDeSaintTropez = new Work("Le gendarme de Saint Tropez");

        minorityReport.setMainArtist(tomCruise);
        bad.setMainArtist(leonardoDiCaprio);
        leGendarmeDeSaintTropez.setMainArtist(louisDeFunes);

        minorityReport.setRelease(2002);
        bad.setRelease(1987);
        leGendarmeDeSaintTropez.setRelease(1964);

        minorityReport.setSummary("Minority Report place le spectateur dans un futur proche cyberpunk, une dystopie dont le cadre est à Washington de 2054 où des êtres humains mutants, les précogs, peuvent prédire les crimes à venir grâce à leur don de prescience");
        bad.setSummary("Bad est le septième album de Michael Jackson et son 3e album solo chez Epic/Sony et le 3e et dernier album co-produit par Quincy Jones. C'est l'un des albums les plus vendus de l'histoire et celui qui contient le plus de morceaux classés no 1 dans les palmarès.");
        leGendarmeDeSaintTropez.setSummary("le film raconte les aventures de Ludovic Cruchot, un gendarme très « service-service », muté dans la cité balnéaire de Saint-Tropez, sur la côte d'Azur, avec le grade de maréchal-des-logis-chef.");

        minorityReport.setGenre("Science Fiction");
        bad.setGenre("Pop");
        leGendarmeDeSaintTropez.setGenre("Comédie");

        Catalogue.listOfWorks.add(minorityReport);
        Catalogue.listOfWorks.add(bad);
        Catalogue.listOfWorks.add(leGendarmeDeSaintTropez);
    }
%>
<h1>Oeuvres au Calalogue :</h1>

<%for (Work item : Catalogue.listOfWorks) {
    String newTitle = item.getTitle();
    Integer newRelease = item.getRelease();
    String newArtist = item.getMainArtist().getName();
%>
    <%=newTitle%> - (<%=newRelease%>) - (<%=newArtist%>)

<br/>

<%}%>
<a href="add-work-form.html">Ajouter une oeuvre au catalogue</a><br/>
<a href="homeBack.jsp">Retournez a l'accueil</a>

</body>
</html>
