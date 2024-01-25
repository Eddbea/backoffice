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
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "LoginServlet", value = "/login")
public class AuthentificationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();

        String michelLogin = ("michel");
        String carolineLogin = ("caroline");
        String michelPass = ("123456");
        String carolinePass = ("abcdef");

        if ((login.equals(michelLogin)) && (password.equals(michelPass)) || (login.equals(carolineLogin)) && (password.equals(carolinePass))) {
            out.println("<html><body>Authentifie avec les identifiants : " + login + "/" + password);
            out.println("<a href=\"homeBack\"> Bienvenue</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>login/mdp ERRONE</body></html></br>");
            out.println("<html><body><a href=\"login.html\">   Essaie encore </a></body></html>");
        }
    }
}