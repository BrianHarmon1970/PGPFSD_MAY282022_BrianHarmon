package assignments.A07232022_01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_02", value = "/Servlet_02")
public class Servlet_02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html" ) ;
        PrintWriter p = response.getWriter();
        Cookie[] cookies = request.getCookies() ;
        p.println( "<b>Cookies</b><br>" ) ;
        for ( int i = 0 ; i < cookies.length ; ++i )
        {
            p.println( i+1 + " " +cookies[ i ].getName() + " " + cookies[ i ].getValue() + "<br>" ) ;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;

    }
}
