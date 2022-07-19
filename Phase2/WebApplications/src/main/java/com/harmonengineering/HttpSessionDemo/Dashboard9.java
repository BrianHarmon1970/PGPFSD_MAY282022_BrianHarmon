package com.harmonengineering.HttpSessionDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Dashboard9", value = "/Dashboard9")
public class Dashboard9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession() ;
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String userId = (String) session.getAttribute( "userid" );
        if (userId == null) {
            out.println("No UserId was found in Http session object.<br>");
        } else {
            out.println("UserId found in Http session object: " + userId + "<br>");

        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
