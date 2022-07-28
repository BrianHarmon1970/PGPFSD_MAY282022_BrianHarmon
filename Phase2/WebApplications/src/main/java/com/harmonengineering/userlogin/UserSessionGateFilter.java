package com.harmonengineering.userlogin;

import com.harmonengineering.util.ConnectionTool;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.http.HttpResponse;

@WebFilter(filterName = "UserSessionGateFilter")
public class UserSessionGateFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException {    }
    public void destroy() {  }
/*
    void sendRedirectNoCache( ServletRequest request , ServletResponse response ,String uri )
            throws IOException
    {
        HttpServletResponse rsp = (HttpServletResponse) response ;
        HttpServletRequest req = (HttpServletRequest) request ;

        String url = rsp.encodeRedirectURL( req.getContextPath() + uri ) ;
        rsp.sendRedirect( url );
    }
    void disableCache( ServletResponse response )
    {
        HttpServletResponse rsp = (HttpServletResponse) response ;
//        rsp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        rsp.setHeader("Pragma", "no-cache");
//        rsp.setDateHeader("Expires", 0);

        //rsp.setStatus(200);
        rsp.setHeader("Pragma", "No-cache");
        rsp.setHeader("Cache-Control", "no-store");
        rsp.setDateHeader("Expires", 0);
    }
    void refreshCache( ServletRequest request , ServletResponse response )
            throws IOException
    {
        HttpServletResponse rsp = (HttpServletResponse) response ;
        HttpServletRequest req = (HttpServletRequest) request ;
        String uri = req.getRequestURI() ;

        rsp.setHeader("Refresh", "0; URL=" + req.getContextPath() + uri );
       // try { Thread.sleep( 50 ) ; }
        //catch( InterruptedException e )
        //    { System.out.print( e.getMessage() ); }
        rsp.setHeader("Refresh", "-1; URL=" + req.getContextPath() + uri );
    }
    void resetCache(  ServletRequest request , ServletResponse response )
            throws IOException
    {
        refreshCache( request, response ) ;
        disableCache( response ) ;
    }
*/
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        ConnectionTool cTool = new ConnectionTool( request, response ) ;
        cTool.printConnectionHeadInfo( "Session Gateway Filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String URI = req.getRequestURI();

        PrintWriter w = response.getWriter();

        System.out.println("request URI: " + URI);
        String isValid = (String) session.getAttribute("validatedLogin");

        //w.println("<br>isValid: " + isValid);
        cTool.resetCache( ) ;
        if (isValid != null && isValid.equals("true"))
        {
            if (URI.equals("/UserLogin/UserLogin.html") ||
                    URI.equals("/UserLogin"))
            {
                //w.println("<br>dispatching UserDashboard.html");
                cTool.sendRedirect( "/UserLogin/UserDashboard.html" ) ;
            } else chain.doFilter(request, response);
        }
        else
        {
            if (URI.equals("/UserLogin/UserDashboard.html") ||
                    URI.equals("/UserLogin"))
            {
                //w.println("<br>dispatching UserLogin.html");
                cTool.sendRedirect( "/UserLogin/UserLogin.html" ) ;
            } else chain.doFilter(request, response);
        }
    }
}