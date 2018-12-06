/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seagull
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response, String name, int numb1, int numb2)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result Page</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Simple Maths</h1>");
            out.println("<p>" + name + "<p>");
            out.println("<br>The first number you put was" + numb1);
            out.println("<br>The second number you put was" + numb2);
            out.println("<br>First Number ADDED the second is" + (numb1 + numb2));
            out.println("<br>First Number SUBTRACTED the second is" + (numb1 - numb2));
            out.println("<br>First Number DIVIDED BY the second is" + (numb1 / numb2));
            out.println("<br>First Number MULTIPLIED the second is" + (numb1 * numb2));
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        int numb1 = Integer.parseInt(request.getParameter("numb1"));
        int numb2 = Integer.parseInt(request.getParameter("numb2"));
        processRequest(request, response, name, numb1, numb2);
            
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
