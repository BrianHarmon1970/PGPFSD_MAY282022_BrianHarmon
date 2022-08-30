/****************************
 *  AddProductServlet.java
 */
package com.harmonengineering;

import com.ecommerce.EProduct;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.getWriter().println( "AddProductServlet") ;
        HibernateSession hSession = new HibernateSession() ;
        Session session = hSession.createSession();
        ProductData productDataManager = new ProductData() ;
        productDataManager.setSession( session ) ;
        EProduct eProduct = (EProduct) request.getAttribute("validatedProduct" ) ;
        if( eProduct != null )
        {
            //String productName = request.getParameter("product_name") ;
            //String productPrice = request.getParameter( "product_price") ;
            //productDataManager.AddProduct(productName,productPrice  ) ;
            productDataManager.AddProduct( eProduct ) ;
            request.removeAttribute("validatedProduct") ;
        }
        session.close() ;
        hSession.closeHibernate() ;

        RequestDispatcher dispatcher ;
        dispatcher = request.getRequestDispatcher("listProducts");
        dispatcher.forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
        doGet( request, response ) ;
    }

}
