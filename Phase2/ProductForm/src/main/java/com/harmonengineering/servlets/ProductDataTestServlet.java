/****************************
 *  ProductDataTestServlet.java
 */
package com.harmonengineering.servlets;

import com.ecommerce.EProduct;
import com.harmonengineering.beans.ValidatorBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;

import static java.lang.String.valueOf;
import static java.lang.System.out;

public class ProductDataTestServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        ValidatorBean validator = new ValidatorBean() ;
        EProduct eProduct = new EProduct() ;

        String productPrice = request.getParameter("product_price" ) ;

        eProduct.setID( 0 ) ;
        eProduct.setName( request.getParameter("product_name" )) ;
        eProduct.setDateAdded( new Date() ) ;
        if( validator.isValidText( productPrice ) && validator.isValidNumber( productPrice ))
            eProduct.setPrice(BigDecimal.valueOf(Double.parseDouble(productPrice))) ;
        request.setAttribute( "EProductBean" , eProduct ) ;

        RequestDispatcher dispatcher ;
        dispatcher = request.getRequestDispatcher("ProductDisplay.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet( request, response ) ;
    }
}
