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
import java.util.Optional;

@WebServlet(name = "AddWorkServlet", value = "/add-work")
public class AddWorkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean success = true;
        Work newWork = new Work(req.getParameter("title"));
        newWork.setGenre(req.getParameter("genre"));
        newWork.setSummary(req.getParameter("summary"));
        newWork.setMainArtist(new Artist(req.getParameter("artist")));

        try {
            newWork.setRelease(Integer.parseInt(req.getParameter("release")));
        }
        catch (NumberFormatException e) {
            success = false;
        }


        /*for (Work item : Catalogue.listOfWorks) {
            if (item.getTitle().equals(newWork.getTitle()) && (item.getRelease() == newWork.getRelease()) && (item.getMainArtist().getName().equals(newWork.getMainArtist().getName()))) {
                success = false;}}
         */


        Optional<Work> optionalWork=Catalogue.listOfWorks.stream().filter(work -> work.getTitle().equals(newWork.getTitle()) && (work.getRelease() == newWork.getRelease()) && (work.getMainArtist().getName().equals(newWork.getMainArtist().getName()))).findAny();
            if(optionalWork.isPresent()){
                success=false;
            }

        RequestDispatcher dispatcher=null;
            if(success){
                Catalogue.listOfWorks.add(newWork);
                req.setAttribute("identifiantWork",newWork.getId());
                dispatcher = req.getRequestDispatcher("/work-added-success");
                dispatcher.forward(req, resp);

            }
            else {
                dispatcher = req.getRequestDispatcher("/work-added-failure");
                dispatcher.forward(req, resp);
            }
    }
}
