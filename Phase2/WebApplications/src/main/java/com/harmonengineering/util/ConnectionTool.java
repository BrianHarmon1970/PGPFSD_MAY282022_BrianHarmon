/*-----------------------------------------
 * File: ConnectionTool.java
 */
package com.harmonengineering.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ConnectionTool
{
    /*********************************************
     *  ConnectionTool - encapsulating some of the
     *  features developed for UserLogin which could be
     *  more generally useful, perhaps more to come.
     */
    private HttpServletRequest m_httpServletRequest ;
    private HttpServletResponse m_httpServletResponse ;
    private HttpSession m_httpSession ;

    public ConnectionTool( HttpServletRequest request, HttpServletResponse response )
    {
        m_httpServletRequest = request ;
        m_httpServletResponse = response ;
        m_httpSession = request.getSession() ;
    }
    public ConnectionTool(ServletRequest request, ServletResponse response )
    {
        m_httpServletRequest = (HttpServletRequest) request ;
        m_httpServletResponse = (HttpServletResponse) response ;
        m_httpSession = ((HttpServletRequest) request).getSession() ;
    }

    public HttpServletResponse getResponse() { return m_httpServletResponse ; }
    public HttpServletRequest getRequest() { return m_httpServletRequest ; }

    public void printConnectionHeadInfo( String heading )
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

        w.println( "<html><head>") ;
        w.println( "<style>div { border-top: 1px solid #999; " ) ;
        w.println( "border-bottom: 1px solid #999 ;}</style>") ;
        w.println( "<Title>" ) ;
        w.println( heading ) ;
        w.println("</Title><body>") ;
        w.println( "<div>") ;// w.println("<b>" + heading + "</b>") ;
        w.println("Servlet context: " + context_name );
        w.println("<br>context path:    " + context_path );

        w.println("<br>context servlet path:    " + servlet_path );
        w.println("<br>context real path:    " + real_path );
        w.println("<br>request URI: " + URI);
        w.println( "<br>request URL: " +  getRequest().getRequestURL() ) ;
        w.println("</div></body></html>") ;
    }
    public void resetCache(  )
            throws IOException
    {
        refreshCache( ) ;
        disableCache( ) ;
    }
    public void disableCache( )
    {
        m_httpServletResponse.setHeader("Pragma", "No-cache");
        m_httpServletResponse.setHeader("Cache-Control", "no-store");
        m_httpServletResponse.setDateHeader("Expires", 0);
    }
    public void refreshCache(  )
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
    public void sendRedirectNoCache( String uri )
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
    public void sendRedirect( String uri )
            throws IOException
    {
        String url = m_httpServletResponse.encodeRedirectURL(
                m_httpServletRequest.getContextPath() + uri ) ;
        m_httpServletResponse.sendRedirect( url );
    }
}