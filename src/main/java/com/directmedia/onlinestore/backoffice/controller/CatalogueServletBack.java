package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CatalogueServletBack", value = "/catalogueBack")
public class CatalogueServletBack extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

            response.setContentType("application/json");
            PrintWriter out=response.getWriter();
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.writeValue(out,Catalogue.listOfWorks);

        }
    }
}