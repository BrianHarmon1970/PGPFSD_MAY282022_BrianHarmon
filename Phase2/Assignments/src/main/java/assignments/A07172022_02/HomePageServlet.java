package assignments.A07172022_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "HomePageServlet", value = "/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("Entering Home Page");
        Writer writer = response.getWriter() ;
        writer.write( "    ==== HOME PAGE =====    " ) ;
        System.out.println("Leaving Home Page");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;

    }
}
