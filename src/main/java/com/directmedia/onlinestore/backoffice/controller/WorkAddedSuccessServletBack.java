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

@WebServlet(name = "WordAddedSuccessServletBack", value = "/work-added-success")
public class WorkAddedSuccessServletBack extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Success Added Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>L'oeuvre a bien ete ajoutee, son identifiant est le "+req.getAttribute("identifiantWork")+"<h1>");
        out.println("<a href=\"catalogueBack\">Retournez au catalogue</a><br/>");
        out.println("<a href=\"homeBack\">Retournez a l'accueil</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
