package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddWorkServlet", value = "/add-work")
public class AddWorkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        Work newWork = new Work(req.getParameter("title"));
        newWork.setRelease(Integer.parseInt(req.getParameter("release")));
        newWork.setGenre(req.getParameter("genre"));
        newWork.setSummary(req.getParameter("summary"));
        newWork.setMainArtist(new Artist(req.getParameter("artist")));

        String convertRelease=String.valueOf(newWork.getRelease());
        String[] entier=convertRelease.split("");
        String titleControl=newWork.getTitle();
        String mainArtistControl= String.valueOf(newWork.getMainArtist());

        Work workTest=new Work();
        workTest.setRelease(Integer.parseInt(convertRelease));
        workTest.setTitle(titleControl);
        workTest.setMainArtist(newWork.getMainArtist());


           if((entier.length==4)&&(!Catalogue.listOfWorks.contains(titleControl))&&(!Catalogue.listOfWorks.contains(mainArtistControl))){
               RequestDispatcher disp=req.getRequestDispatcher("/work-added-success");
               disp.forward(req,resp);
           }
           else {
               RequestDispatcher disp=req.getRequestDispatcher("/work-added-failure");
               disp.forward(req,resp);
           }

        Catalogue.listOfWorks.add(newWork);
        out.println("<html><body>Le film a ete ajoute -<a href=\"home\"> Retourner a la page d'accueil</a></body></html>");
    }
}
