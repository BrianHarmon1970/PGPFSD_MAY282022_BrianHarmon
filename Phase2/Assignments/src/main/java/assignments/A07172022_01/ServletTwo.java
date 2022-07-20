package assignments.A07172022_01;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletTwo", value = "/Servlettwo")
public class ServletTwo extends HttpServlet
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
        writer.print( "<html><head>" ) ;
        writer.println( "<P> IN SERVICE TWO </p>");
        writer.print( "</head><body>" ) ;
        writer.println( "<p> A=" + param_a + " B=" + param_b + " C=" + param_c + " D=" + param_d + "</p>" ) ;
        writer.println( "<p>  (1)  A * D = " + ( param_a * param_d )) ;
        writer.println( "<br><b>  (2)  B - C = " + (param_b - param_c ) + "<br></p>") ;
        writer.print( "</body></html>" ) ;

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
