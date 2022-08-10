package assignments.A07232022_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_01", value = "/Servlet_01")
public class Servlet_01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String user_name = request.getParameter("username" ) ;
        String password = request.getParameter( "password" ) ;

        Cookie userCookie = new Cookie( "username", user_name ) ;
        Cookie passCookie = new Cookie( "password", password ) ;

        response.addCookie( userCookie ) ;
        response.addCookie( passCookie ) ;

        //response.sendRedirect( "/A07232022_01/Servlet_02" ) ;
        response.sendRedirect( "/Servlet_02" ) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
