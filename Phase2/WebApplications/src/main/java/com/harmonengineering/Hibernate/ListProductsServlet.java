package com.harmonengineering.Hibernate;

import com.ecommerce.EProduct;
import com.ecommerce.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.ecommerce.HibernateUtil_EXperiMental ;

public class ListProductsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ListProductsServlet() {  super();  }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            SessionFactory factory = HibernateUtil_EXperiMental.getSessionFactory();

            Session session = factory.openSession();
            EProduct eProduct = new EProduct(  ) ;
            //session.getEntityManagerFactory().createEntityManager().persist(eProduct ) ;
            //session.persist( eProduct ) ;
            // using HQL

            Query<EProduct> q = session.createQuery("from com.ecommerce.EProduct" ) ;
            //ArrayList<com.ecommerce.EProduct.EProduct> list = new ArrayList<com.ecommerce.EProduct.EProduct>( q.getResultList() );

            List<EProduct> list = q.list() ;

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Product Listing</b><br>");
            for(EProduct p: list) {

                out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                        ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
            }
            out.println(list.size() + " Rows. <br>" ) ;

            session.close();
            out.println("</body></html>");

        } catch (Exception ex) {
            throw ex;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
           doGet(request, response);
    }

}

