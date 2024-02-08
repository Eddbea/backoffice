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


    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=resp.getWriter()) {
            out.println("<!doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Added Failure Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Une erreur est survenue, l'oeuvre n'a pas ete ajoutee</h1>");
            out.println("<a href=\"catalogueBack\">Retournez au catalogue</a><br/>");
            out.println("<a href=\"homeBack\">Retournez a l'accueil</a>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
