/****************************
 *  ListProductServlet.java
 */
package com.harmonengineering;

import com.ecommerce.EProduct;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListProductServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html") ;
        PrintWriter out = response.getWriter() ;
        out.print( "ListProduct" ) ;

        HibernateSession hSession = new HibernateSession() ;
        Session session = hSession.createSession();
        ProductData productDataManager = new ProductData() ;
        productDataManager.setSession( session ) ;

        out.print("<table><thead><tr>") ;
        out.print("<td>Name</td><td>Price</td><td>Date Added</td>" ) ;
        out.print("</tr></thead>") ;
        List<EProduct> list = productDataManager.ListProducts() ;
        for( EProduct i : list )
        {
            out.print("<tr>") ;
           out.print( "<td>" + i.getName() + "</td>" ) ;
           out.print( "<td>" + i.getPrice() + "</td>" ) ;
           out.print( "<td>" + i.getDateAdded().toString() + "</td>" ) ;
           out.print( "</tr>" ) ;
        }
        out.print("</table" ) ;
        session.close() ;
        hSession.closeHibernate();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet( request, response ) ;
    }
}
