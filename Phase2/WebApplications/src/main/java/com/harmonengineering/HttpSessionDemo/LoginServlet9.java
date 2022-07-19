package com.harmonengineering.HttpSessionDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet9", value = "/LoginServlet9")
public class LoginServlet9 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String userId = request.getParameter("userid");
        //creating a new hidden form field

        HttpSession session = request.getSession() ;
        session.setAttribute("userid" , "Admin" ) ;

        //// Forwarding request
        //RequestDispatcher dispatcher = getServletContext()
        //        .getRequestDispatcher("/forwarded");
        //dispatcher.forward( request, response );
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/dashboard9");
        dispatcher.forward( request, response );


        //// re-directing
        //response.sendRedirect(request.getContextPath() + "/redirected");

        /*
        out.println("<form action='dashboard9' method='post'>");
        out.println("<input type='hidden' name='userid' id='userid' value='"+userId+"'>");
        out.println("<input type='submit' value='submit' >");
        out.println("</form>");
        out.println("<script>document.forms[0].submit();</script>");
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
