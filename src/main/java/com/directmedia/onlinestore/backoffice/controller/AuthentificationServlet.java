package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "LoginServlet", value = "/login")
public class AuthentificationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String michelLogin = ("michel");
        String carolineLogin = ("caroline");
        String eddLogin=("edd");
        String michelPass = ("123456");
        String carolinePass = ("abcdef");
        String eddPass=("");

        if ((login.equals(michelLogin)) && (password.equals(michelPass)) || (login.equals(carolineLogin)) && (password.equals(carolinePass)) || (login.equals(eddLogin)) && (password.equals(eddPass))) {
            out.println("<html><body>Authentifie avec les identifiants : " + login + "/" + password);
            out.println("<a href=\"homeBack.jsp\"> Bienvenue</a>");
            out.println("</body></html>");
            HttpSession session=request.getSession();
            session.setAttribute("login", login);


        } else {
            out.println("<html><body>login/mdp ERRONE</body></html></br>");
            out.println("<html><body><a href=\"login.html\"> Essaie encore </a></body></html>");
        }
    }
}