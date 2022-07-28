/*-----------------------------------------
 * File: ProductQueryFilter.java
 */
package com.harmonengineering.ProductQuery;

import com.harmonengineering.util.ConnectionTool;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.logging.Filter;

public class ProductQueryFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException { }
    public void destroy() { }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter() ;
        out.println( "<br>Doing the filter thing at: ProductQueryFilter::doFilter()!!" ) ;

        ConnectionTool ct = new ConnectionTool( request, response ) ;
        ct.printConnectionHeadInfo(this.getClass().getName()) ;

        Integer productId = parseInteger( request.getParameter( "product_key" )) ;
        if ( productId == null || productId == 0 )
        {
            //ct.sendRedirect( ct.getRequest().getRequestURI() ) ;
            //ct.sendRedirect( "index.html" ) ;

            //ct.sendRedirect(((   HttpServletRequest) request).getRequestURI());
            //ct.refreshCache();

            ct.sendRedirect( "/ProductQuery/DataError.html" ) ;
        }
        else
            chain.doFilter( request, response ) ;

        out.println( "<br>Leaving: ProductQueryFilter::doFilter()!!" ) ;
    }
    Integer parseInteger( String n )
    {
        Integer N ;
        try { N = Integer.parseInt( n ) ; }
        catch ( NumberFormatException e ) { N = null ; }
        return N ;
    }
    boolean isValidInt( String n )
    {
        boolean return_value = true ;
        try { Integer.parseInt( n ) ; }
        catch ( NumberFormatException e ) { return_value = false ; }
        return return_value ;
    }
}
