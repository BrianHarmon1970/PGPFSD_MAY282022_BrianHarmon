package com.harmonengineering.HttpSessionDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResetSessionServlet", value = "/ResetSessionServlet")
public class ResetSessionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String context_path = request.getContextPath();
        HttpSession session = request.getSession( ) ;
        session.invalidate();
        response.sendRedirect(context_path + "/" ) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
