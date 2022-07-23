package com.harmonengineering.userlogin;

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
    class ConnectionTool
    {
        /*********************************************
         *  ConnectionTool - encapsulating some of the
         *  features developed for UserLogin which could be
         *  more generally useful, perhaps more to come.
         */
        private HttpServletRequest m_httpServletRequest ;
        private HttpServletResponse m_httpServletResponse ;
        private HttpSession m_httpSession ;

        ConnectionTool( HttpServletRequest request, HttpServletResponse response )
        {
            m_httpServletRequest = request ;
            m_httpServletResponse = response ;
            m_httpSession = request.getSession() ;
        }
        ConnectionTool( ServletRequest request, ServletResponse response )
        {
            m_httpServletRequest = (HttpServletRequest) request ;
            m_httpServletResponse = (HttpServletResponse) response ;
            m_httpSession = ((HttpServletRequest) request).getSession() ;
        }
        void printConnectionHeadInfo( String heading )
                throws IOException
        {
            PrintWriter w = m_httpServletResponse.getWriter();
            String URI = m_httpServletRequest.getRequestURI();
            ServletContext servletContext = m_httpServletRequest.getServletContext() ;
            String servlet_context_path = m_httpServletRequest.getServletContext().getContextPath() ;
            String servlet_path = m_httpServletRequest.getServletPath() ;
            String real_path = m_httpServletRequest.getSession().getServletContext().getRealPath( servlet_context_path ) ;
            String context_path = servletContext.getContextPath();
            String context_name = servletContext.getServletContextName();

            w.println("<b>" + heading + "</b>") ;
            w.println("<br>Servlet context: " + context_name );
            w.println("<br>context path:    " + context_path );

            w.println("<br>context servlet path:    " + servlet_path );
            w.println("<br>context real path:    " + real_path );
            w.println("<br>request URI: " + URI);
        //    System.out.println("request URI: " + URI);
        }
        void resetCache(  )
                throws IOException
        {
            refreshCache( ) ;
            disableCache( ) ;
        }
        void disableCache( )
        {
            m_httpServletResponse.setHeader("Pragma", "No-cache");
            m_httpServletResponse.setHeader("Cache-Control", "no-store");
            m_httpServletResponse.setDateHeader("Expires", 0);
        }
        void refreshCache(  )
                throws IOException
        {
            String uri = m_httpServletRequest.getRequestURI() ;

            m_httpServletResponse.setHeader("Refresh", "0; URL=" +
                    m_httpServletRequest.getContextPath() + uri );
            // try { Thread.sleep( 50 ) ; }
            //catch( InterruptedException e )
            //    { System.out.print( e.getMessage() ); }
            m_httpServletResponse.setHeader("Refresh", "-1; URL=" +
                    m_httpServletRequest.getContextPath() + uri );
        }
        void sendRedirectNoCache( String uri )
                throws IOException
        {
            // presently does not do anything different from redirect
            // in fact when originally written measures of cache control
            // were included but timing issues prevented the permanent inclusion
            // here.... retained for experimentation until better understood
            // about the timing in controlling the cache.. it would be desirable
            // if it could all be contained here.... perhaps that is missing the
            /// point  but not giving up on it yet.
            String url = m_httpServletResponse.encodeRedirectURL(
                    m_httpServletRequest.getContextPath() + uri ) ;
            m_httpServletResponse.sendRedirect( url );
        }
        void sendRedirect( String uri )
                throws IOException
        {
            String url = m_httpServletResponse.encodeRedirectURL(
                    m_httpServletRequest.getContextPath() + uri ) ;
            m_httpServletResponse.sendRedirect( url );
        }
    }
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