package com.harmonengineering.Hibernate;


import java.io.IOException;
        import java.io.PrintWriter;

        import javax.servlet.ServletConfig;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.transaction.*;
        import javax.xml.bind.*;

        import java.io.Serializable;
        import java.math.BigDecimal;
import java.util.*;

import com.ecommerce.*;
import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.Transaction;
        import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/HibernateProductDetailsServlet")

public class HibernateProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PrintWriter out ;

    public HibernateProductDetailsServlet() { super();  }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            List<EProduct> list = session.createQuery("from EProduct").list();

            out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Product Listing</b><br>");
            for(EProduct p: list) {
                PrintCollections( p ) ;
                ProductComponentPrint( p ) ;
                out.println("<hr>");
            }
            session.close();
            out.println("</body></html>");
        } catch (Exception ex) {
            throw ex;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    void PrintCollections( EProduct p )
    {
        out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString());

        List<Color> colors = p.getColors();
        out.println("Colors: ");
        for(Color c: colors) {
            out.print(c.getName() + "&nbsp;");
        }
        Collection<ScreenSizes> sizes= p.getScreensizes();
        out.println(", Screen Sizes: ");
        for(ScreenSizes s: sizes) {
            out.print(s.getSize() + "&nbsp;");
        }
        Set<OS> os= p.getOs();
        out.println(", OS : ");
        for(OS o: os) {
            out.print(o.getName() + "&nbsp;");
        }
        Map finances = p.getFinance();
        out.println(", Finance Options: ");
        if (finances.get("CREDITCARD") != null) {
            Finance f = (Finance) finances.get("CREDITCARD");
            out.println(f.getName() + " &nbsp;");
        }
        if (finances.get("BANK") != null) {
            Finance f = (Finance) finances.get("BANK");
            out.println(f.getName() + " &nbsp;");
        }
    }
    void ProductComponentPrint( EProduct p ) {


        out.println("<b>Component Mapping</b><br>");

            out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                    ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString());
            ProductParts parts = p.getParts();
            out.println("Parts =" + parts.getCpu() + ", " + parts.getHdd() + ", " + parts.getRam());
            out.println("<hr>");

    }
}

