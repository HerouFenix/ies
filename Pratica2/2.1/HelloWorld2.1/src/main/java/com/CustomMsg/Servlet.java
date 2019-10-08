package com.CustomMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CustomMsg", urlPatterns = {"/custom"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World!</h3>");

        if (request.getParameter("username") != null) {
            out.println("<p>Boas meu puto " + request.getParameter("username") + "!</p>");
        }else {
            out.println("<p>Por favor especifica o teu nome no url, para que te possa cumprimentar ;)</p>");
            out.println("<p> URL: http://localhost:8080/custom?username=<NOME> </p>");
        }

    }
}





