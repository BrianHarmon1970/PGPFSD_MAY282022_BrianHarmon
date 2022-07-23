package com.harmonengineering.userlogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.getWriter().println( " USER LOGIN SERVLET" ) ;
        request.getSession().setAttribute("validatedLogin", "true" ) ;

        // re-directing to /UserLogin and allow for the gate servlet filter to re-direct
        // accordingly
        response.sendRedirect(request.getContextPath() + "/UserLogin" );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
