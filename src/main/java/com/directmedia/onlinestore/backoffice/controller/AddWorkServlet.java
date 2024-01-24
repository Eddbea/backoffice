package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddWorkServlet", value = "/add-work")
public class AddWorkServlet extends HttpServlet {
    /**
     * @param req      an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        Work newWork = new Work(req.getParameter("title"));
        newWork.setRelease(Integer.parseInt(req.getParameter("release")));
        newWork.setGenre(req.getParameter("genre"));
        newWork.setSummary(req.getParameter("summary"));
        newWork.setMainArtist(new Artist(req.getParameter("artist")));
        Catalogue.listOfWorks.add(newWork);

        out.println("<html><body>Le film a ete ajoute -<a href=\"homeBack\"> Retourner a la page d'accueil</a></body></html>");

    }
}
