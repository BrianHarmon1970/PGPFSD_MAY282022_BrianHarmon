package assignments.A07172022_02;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "ValidateFilter")
public class ValidateFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        System.out.println("In ValidateFilter" ) ;
        String uname = request.getParameter("username" ) ;
        String uage = request.getParameter("userage"  ) ;
        boolean validAgeInput = true ;
        try
        {
            int userAge = Integer.parseInt( uage ) ;
        } catch( NumberFormatException e )
        {
            validAgeInput = false ;
        }
        if( validAgeInput && !uname.isBlank() && !uage.isBlank())
            chain.doFilter(request, response);
        else response.getWriter().println( "Please provide valid user name and age." ) ;
        System.out.println("Leaving ValidateFilter");
    }
}
