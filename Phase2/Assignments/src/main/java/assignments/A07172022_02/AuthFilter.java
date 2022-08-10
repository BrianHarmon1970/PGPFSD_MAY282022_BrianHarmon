package assignments.A07172022_02;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        System.out.println( "In AuthFilter" ) ;
        String userName = request.getParameter("username" ) ;
        int userAge = Integer.parseInt( request.getParameter("userage").toString()) ;
        if( userName.toLowerCase().equals("admin") && userAge >= 30 )
            chain.doFilter(request, response);
        else response.getWriter().println("Invalid User Data. (" + userName + ", " + userAge + ")") ;
        System.out.println("Leaving AuthFilter");
    }
}
