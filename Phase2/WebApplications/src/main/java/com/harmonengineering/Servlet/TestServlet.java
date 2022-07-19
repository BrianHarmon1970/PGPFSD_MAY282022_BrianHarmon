package com.harmonengineering.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TestServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        HttpSession session = request.getSession() ;
        response.setContentType("text/html");
        response.getWriter().append("<h1>").append("Session Details").append("</h1>") ;
        response.getWriter().append( "<html><body>") ;
        PrintWriter out = response.getWriter() ;
        out.append( "<b>Session Details<b>" ) ;

        out.println("<p>") ;
        out.print( "SessionId: " + session.getId() + "<br>" ) ;
        out.print( "SessionCreationTime: " + session.getCreationTime() + "<br>" ) ;
        out.print( "SessionLastAccessedTime: " + session.getLastAccessedTime() + "<br>" ) ;
        out.print( "SessionMaxInactiveInterval: " + session.getMaxInactiveInterval()+ "<br>" ) ;
        out.print( "SessionHashcode: " + session.hashCode()+ "<br>" ) ;
        out.print( "SessionServletContextName: " + session.getServletContext().getServletContextName()+ "<br>" ) ;
        out.println("</p>") ;

        out.println() ; out.println() ;
        out.println( "<b>Session Attributes<b>" ) ;
        out.println("<p>") ;
        Enumeration<String> AttributeNames = session.getAttributeNames() ;
        while (AttributeNames.hasMoreElements()) {
            String hName = AttributeNames.nextElement();
            String hValue = session.getAttribute( hName ).toString();
            out.println("<b> hName </b>"+hName );
            out.println("<b> hValue </b>"+ hValue +"<br>"  );
        }
        out.println("</p>") ;
    }
}
