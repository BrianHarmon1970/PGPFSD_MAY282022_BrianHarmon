package com.harmonengineering.FormFieldsTracking;

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet8")
public class LoginServlet8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet8() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String userId = request.getParameter("userid");
        //creating a new hidden form field
        out.println("<form action='dashboard8' method='post'>");
        out.println("<input type='hidden' name='userid' id='userid' value='"+userId+"'>");
        out.println("<input type='submit' value='submit' >");
        out.println("</form>");
        out.println("<script>document.forms[0].submit();</script>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
