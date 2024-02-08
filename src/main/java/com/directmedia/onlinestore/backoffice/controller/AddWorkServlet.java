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
        String releaseA = String.valueOf(newWork.getRelease());
        newWork.setGenre(req.getParameter("genre"));
        newWork.setSummary(req.getParameter("summary"));
        newWork.setMainArtist(new Artist(req.getParameter("artist")));

        try {
            newWork.setRelease(Integer.parseInt(req.getParameter("release")));

            for (Work item : Catalogue.listOfWorks) {
                boolean isTitle = item.getTitle().contains(newWork.getTitle());
                boolean isArtist = item.getMainArtist().equals(newWork.getMainArtist());
                boolean releaseSaisie = releaseA.matches("^\\d{4}$");
                String releaseControl = Integer.toString(item.getRelease());
                boolean isRelease = releaseControl.contains(releaseA);

                if ((!isTitle) && (!isRelease) && (!isArtist) && (releaseSaisie)) {
                    RequestDispatcher disp = req.getRequestDispatcher("/work-added-success");
                    disp.forward(req, resp);
                    Catalogue.listOfWorks.add(newWork);
                    out.println("<html><body>Le film a ete ajoute -<a href=\"home\"> Retourner a la page d'accueil</a></body></html>");
                } else {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/work-added-failure");
                    dispatcher.forward(req, resp);
                }
            }
        } catch (NumberFormatException e) {
            RequestDispatcher dispt = req.getRequestDispatcher("/work-added-failure");
            dispt.forward(req, resp);


        }
    }
}


