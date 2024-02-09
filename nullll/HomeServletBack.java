package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServletBack", value = "/homeBack")
public class HomeServletBack extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        //HttpSession session=req.getSession();
        //response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
       // out.println("<html><body>Bonjour "+req.getSession().getAttribute("login")+"<a href=\"logout\"> " +
                //"(Deconnexion)</a></body></html>");
        out.println("<html><body><h1>OnlineStore - Gestion de la boutique</h1></body></html>");
        out.println("<a href=\"login.html\">Authentification</a></br>");
        out.println("<a href=\"catalogueBack\">Accès au catalogue</a></br>");
        out.println("<a href=\"add-work-form.html\">Ajouter une oeuvre au catalogue</a>");
        out.println("</body></html>");
    }
}