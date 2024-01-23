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

     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param response an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String titre = req.getParameter("Titre");
        String anneeSortie = req.getParameter("Annee de sortie");
        String genre=req.getParameter("Genre");
        String resume=req.getParameter("Resume");
        String mainArtist=req.getParameter("Artiste principal");


        Work work=new Work(titre);
        Artist artist=new Artist(mainArtist);
        work.setTitle(titre);
        //work.setRelease.(anneeSortie);
        work.setGenre(genre);
        work.setSummary(resume);
        Catalogue.listOfWorks.add(work);

        out.println("<html><body><h1>OnlineStore - test</h1></body></html>");
    }
}
