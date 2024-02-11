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

@WebServlet(name = "LogoutServletBack", value = "/logout")
public class LogoutServletBack extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    resp.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        session.invalidate();
        PrintWriter out = resp.getWriter();
        out.print("<html><body>Vous avez ete deconnecte, cliquez<a href=\"login.html\"> ici </a>pour vous reconnecter</body></html>");
    }
}
