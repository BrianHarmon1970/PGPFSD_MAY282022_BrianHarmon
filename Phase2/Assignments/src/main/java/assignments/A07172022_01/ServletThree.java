package assignments.A07172022_01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletThree", value = "/Servletthree")
public class ServletThree extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletContext context = getServletContext() ;
        int param_d = Integer.parseInt( getInitParameter("param_d" )) ;
        int param_a = Integer.parseInt( context.getInitParameter("param_a" ).toString() ) ;
        int param_b = Integer.parseInt( context.getInitParameter("param_b" ).toString() ) ;
        int param_c = Integer.parseInt( context.getInitParameter("param_c" ).toString() ) ;

        PrintWriter writer = response.getWriter() ;
        writer.print( "<html><head><body>" ) ;
        writer.println( "<P> IN SERVICE THREE </p>");
        writer.println( "<p> A=" + param_a + " B=" + param_b + " C=" + param_c + " D=" + param_d + "</p>" ) ;
        writer.println( "<p>  (1)  A + B +  D = " + ( param_a + param_b + param_d ) ) ;
        writer.println( "<b><br>  (2)  Largest param value is  " +
                        Math.max(Math.max(Math.max( param_c , param_d ), param_b), param_a ) + ".</p>" ) ;
        writer.print( "</body></head></html>" ) ;

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
