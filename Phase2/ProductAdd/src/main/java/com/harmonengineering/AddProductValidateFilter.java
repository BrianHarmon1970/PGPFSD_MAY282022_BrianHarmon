/****************************
 *  AddProductValidateFilter.java
 */
package com.harmonengineering;
import com.ecommerce.EProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;

import static java.lang.String.valueOf;
import static java.lang.System.out;


public class AddProductValidateFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void destroy() {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {

        response.setContentType("text/html");
        response.getWriter().println( "ValidateFilter") ;
        String productName = request.getParameter("product_name" ) ;
        String productPrice = request.getParameter("product_price" ) ;

        if ( isValidNumber(productPrice) && isValidText( productName ) )
        {
            EProduct newProduct = new EProduct() ;
            newProduct.setName( productName ) ;
            newProduct.setPrice(BigDecimal.valueOf(Double.parseDouble(productPrice))) ;
            request.setAttribute("validatedProduct", (Object)newProduct) ;
            if(  isValidDecimal( newProduct.getPrice(), 10, 2 ))
                chain.doFilter(request,response) ;
        }
        { // else (by fall through)
            RequestDispatcher dispatcher ;
            dispatcher = request.getRequestDispatcher("ProductError.jsp");
            dispatcher.forward(request, response);
        }
    }
    boolean isValidText( String s )
    {
        return  (s != null && !s.isBlank()) ;
    }
    boolean isValidNumber( String s )
    {
        return isValidInteger(s) || isValidDouble(s);
    }
    boolean isValidInteger( String s )
    {
        boolean return_value = true ;
        if (s != null && !s.isBlank()) {
            try {
                int n = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                return_value = false;
            }
        }
        return return_value ;
    }
    boolean isValidDouble( String s )
    {
        boolean return_value = true ;
        if (s != null && !s.isBlank()) {
            try {
                Double n = Double.parseDouble(s);
            } catch (NumberFormatException e)
            {
                return_value = false;
            }
        }
        return return_value ;
    }
    boolean isValidDecimal( BigDecimal doubleNumber, int wholePartLength, int decimalLength )
            throws IOException
    {
        String str = valueOf(doubleNumber) ;
        char[] bytes = new char[1024] ; int length ;
        StringReader strReader = new StringReader( str ) ;
        length = strReader.read(bytes) ;
        int i ;
        for ( i = 0 ; i < length ; ++i )
        {
            if ( bytes[i] == '.' )
                break ;
            out.print(bytes[i]);
        }
        int wpart = i ;
        int dpart = length-(i+1) ;
        return ( wpart <= (wholePartLength-decimalLength) && dpart <= decimalLength ) ;
    }
}
