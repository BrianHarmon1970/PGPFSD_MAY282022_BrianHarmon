package com.harmonengineering.userlogin;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "UserValidationFilter")
public class UserValidationFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException {    }
    public void destroy() {    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        RequestDispatcher dispatcher ;
        String user = request.getParameter( "username" ) ;
        String pass = request.getParameter( "password" ) ;


        if( ((user != null ) && ( pass != null)) &&
                !request.getParameter("username" ).isBlank() &&
                !request.getParameter("password").isBlank())
            chain.doFilter(request, response);
        else
        {
            dispatcher = request.getRequestDispatcher( "/UserLogin/DataError.html") ;
            dispatcher.forward( request, response ) ;
        }
    }
}
