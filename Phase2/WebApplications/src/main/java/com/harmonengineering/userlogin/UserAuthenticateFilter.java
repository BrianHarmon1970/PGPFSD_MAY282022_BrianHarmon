package com.harmonengineering.userlogin;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "UserAuthenticateFilter")
public class UserAuthenticateFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException { }
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        RequestDispatcher dispatcher ;
        String user = request.getParameter( "username" ) ;
        //String pass = request.getParameter( "password" ) ;

        if( user.equals("Admin"))
        {
            HttpServletResponse rsp = (HttpServletResponse) response ;
            chain.doFilter(request, response);
        }
        else
        {
            dispatcher = request.getRequestDispatcher( "/UserLogin/DenyRetry.html") ;
            dispatcher.forward( request, response ) ;
        }
    }
}
