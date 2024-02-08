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
        //newWork.setTitle("title"); constructeur title

        newWork.setGenre(req.getParameter("genre"));
        newWork.setSummary(req.getParameter("summary"));
        newWork.setMainArtist(new Artist(req.getParameter("artist")));
        String releaseA = String.valueOf(newWork.getRelease());

        try {
            newWork.setRelease(Integer.parseInt(req.getParameter("release")));
            releaseA.matches("^\\d{4}$");








        } catch (NumberFormatException e) {
            RequestDispatcher disp = req.getRequestDispatcher("/work-added-failure");
            disp.forward(req, resp);
        }

        if ((!Catalogue.listOfWorks.contains(newWork.getTitle())&&(!Catalogue.listOfWorks.contains(releaseA)) && (!Catalogue.listOfWorks.contains(newWork.getMainArtist())))) {
            RequestDispatcher disp = req.getRequestDispatcher("/work-added-success");
            disp.forward(req, resp);
            Catalogue.listOfWorks.add(newWork);
            out.println("<html><body>Le film a ete ajoute -<a href=\"home\"> Retourner a la page d'accueil</a></body></html>");
        }
        else {
            RequestDispatcher disp = req.getRequestDispatcher("/work-added-failure");
            disp.forward(req, resp);
        }

    }
}

