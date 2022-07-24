package assignments.A07232022_01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_03", value = "/Servlet_03")

public class Servlet_03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //HttpSession session = request.getSession( false ) ;
        HttpSession session = request.getSession() ;
        String user = request.getParameter( "username" ) ;
        String password = request.getParameter( "password" ) ;
        String age = request.getParameter( "age" ) ;
        String email = request.getParameter( "email" ) ;
        String country = request.getParameter( "country" ) ;

        session.setAttribute( "username" , user ) ;
        session.setAttribute( "password" , password ) ;
        session.setAttribute( "age" , age ) ;
        session.setAttribute( "email" , email ) ;
        session.setAttribute( "country" , country ) ;

        response.sendRedirect( "/Servlet_04" ) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;

    }
}
