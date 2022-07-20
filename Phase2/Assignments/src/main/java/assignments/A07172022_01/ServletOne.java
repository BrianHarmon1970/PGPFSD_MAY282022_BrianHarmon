package assignments.A07172022_01;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletOne", value = "/Servletone")
public class ServletOne extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletConfig config = getServletConfig() ;
        ServletContext context = getServletContext() ;

        int param_d = Integer.parseInt( config.getInitParameter("param_d" )) ;
        int param_a = Integer.parseInt( (context.getInitParameter("param_a" ).toString()) ) ;
        int param_b = Integer.parseInt( (context.getInitParameter("param_b" ).toString()) ) ;
        int param_c = Integer.parseInt( (context.getInitParameter("param_c" ).toString()) ) ;

        PrintWriter writer = response.getWriter() ;
        writer.print( "<html><head><body>" ) ;
        writer.println( "<P> IN SERVICE ONE </p>");
        writer.println( "<p> A=" + param_a + " B=" + param_b + " C=" + param_c + " D=" + param_d + "</p>" ) ;
        writer.println( "<p> A + B + C + D = " + (param_a + param_b + param_c + param_d)+"</p>");
        writer.print( "</body></head></html>" ) ;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}


