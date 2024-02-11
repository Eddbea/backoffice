package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkAddedFailureServletBack", value = "/work-added-failure")
public class WorkAddedFailureServletBack extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sucess Added Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Une erreur est survenue, l'oeuvre n'a pas ete ajoutee<h1>");
        out.println("<a href=\"catalogueBackJsp.jsp\">Retournez au catalogue</a><br/>");
        out.println("<a href=\"homeBack.jsp\">Retournez a l'accueil</a>");
        out.println("</body>");
        out.println("</html>");
    }
}