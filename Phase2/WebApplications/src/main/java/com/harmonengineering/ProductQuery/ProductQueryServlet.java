/*-----------------------------------------
 * File: ProductQueryServlet.java
 */
package com.harmonengineering.ProductQuery;

import com.ecommerce.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.ecommerce.DBConnection;

abstract class LittleServletWrapper extends HttpServlet
{
    protected HttpServletRequest m_request ;
    protected HttpServletResponse m_response ;
    protected PrintWriter   htmlOut ;
    abstract protected void Process(  ) throws IOException, ServletException, SQLException, ClassNotFoundException;
    //abstract protected void FirstCall( ) throws IOException, ServletException ;

    private void doHttpQuery( HttpServletRequest rq, HttpServletResponse rs )
    {
        m_request = rq ;
        m_response = rs ;
        try
        {
            m_response.setContentType("text/html" ) ;
            htmlOut = m_response.getWriter() ;

            Process();
        }
        catch ( ServletException e )
        {
            System.out.println( "ServletException: " + e.getMessage() ) ;
        }
        catch ( IOException e )
        {
            System.out.println( "IOException: " + e.getMessage() ) ;
        }
        catch ( SQLException e )
        {
            System.out.println( "SQLException: " + e.getMessage() ) ;
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println( "ClassNotFoundException: " + e.getMessage() ) ;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response )
    { doHttpQuery( request, response ) ; }
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
    { doHttpQuery( request, response ) ; }
}

public class ProductQueryServlet extends LittleServletWrapper
{
    class ProductRow { public Integer ID; public String Name; public Double Price; }
    private Connection dbConnection ;
    private Statement   sqlStatement ;
    private ResultSet   sqlResultSet ;
    //private PrintWriter htmlOut ;
    protected void Process() throws IOException//, SQLException, ClassNotFoundException
    {
        htmlOut.println( "<br> Doing the Service at: ProductQueryServlet.Process()! " ) ;

        try
        {
            dbConnection = makeDBConnection("/WEB-INF/config.properties").getConnection();
            String product_id = m_request.getParameter("product_key");

            sqlStatement = dbConnection.createStatement(
                    sqlResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ProductRow product = getProductRow(Integer.parseInt(product_id));
            ShowResult(product_id, product);

            sqlStatement.close();
            dbConnection.close() ;
            htmlOut.println( "<br> Leaving: ProductQueryServlet.Process() " ) ;
        }
        catch( SQLException e )
        {
            logMessage( "SQL Error: " +
                    e.getErrorCode() +
                    " " + e.getMessage() + "<br>" +
                    e.getLocalizedMessage() +
                    "<br> (SQLException) " ) ;
        }
        catch( ClassNotFoundException e )
        {
            logMessage( "Error: " +
                    e.getMessage() + "<br>" +
                    e.getLocalizedMessage() +
                    "<br> (ClassNotFoundException) " ) ;
        }
    }
    void logMessage( String msg )
    {
        htmlOut.println( msg ) ;
        System.out.println( msg ) ;
        HtmlAlert( msg ) ;
    }
    void HtmlAlert( String msg )
    {
        htmlOut.print("<html>") ;
        htmlOut.print( "<head><style>" ) ;
        htmlOut.print( " h1 { border-bottom: 5px solid #333;" ) ;
        htmlOut.print( " background-color: blue ; ") ;
        htmlOut.print( "border-top: 5px solid #333;}" ) ;
        htmlOut.print( " p  { margin-left: 30px; color: white;}" ) ;
        htmlOut.print( " </style> " ) ;
        htmlOut.print( "<Title>Query Result</Title></head>" ) ;
        htmlOut.print( "<body><br>" ) ; // Body Tag.... Oh..

        htmlOut.print("<h1><p> " +msg+"</h2></p></h1>");

        htmlOut.print("<br></body>") ;
        htmlOut.print("</html>") ;
    }
    protected void ShowResult( String product_key, ProductRow product )
    {
        htmlOut.println( "<br> Showing up for: ShowResult()<br>" ) ;
        htmlOut.print("<html>") ;
        htmlOut.print( "<head><style>" ) ;
        htmlOut.print( " h1 { border-bottom: 5px solid #333; border-top: 5px solid #333;}" ) ;
        htmlOut.print( " p  { margin-left: 30px; }" ) ;
        htmlOut.print( " </style> " ) ;
        htmlOut.print( "<Title>Query Result</Title></head>" ) ;
        htmlOut.print( "<body><br>" ) ; // Body Tag.... Oh..
        if( product == null ) {
            htmlOut.print("<h1><p>No Matching Result Found.<br> <h2>(PRODUCT_KEY:"+product_key+")</h2></p></h1>");
            htmlOut.print("<br><form method='post'>" ) ;
            htmlOut.print( "<button formaction='/' type=submit>Home</button>") ;
            htmlOut.print(" <button formaction='/ProductQuery/' type=submit>Retry</button>" ) ;
            htmlOut.print( "</form><br>") ;
        } else {
            htmlOut.print( "<table border=5>") ;
            htmlOut.print( "<thead><tr><th colspan=3>PRODUCT</th></tr></thead>" ) ;
            htmlOut.print( "<tbody>" ) ;
            htmlOut.print( "<thead><tr><td>ID</td><td>Name</td><td>Price</td></tr></thead>" ) ;
            htmlOut.print( "<tr><td>" + product.ID.toString() + "</td>" ) ;
            htmlOut.print( "<td>" + product.Name.toString() + "</td>" ) ;
            htmlOut.print( "<td>" + product.Price.toString() + "</td></tr>" ) ;
            htmlOut.print( "</tbody>" ) ;
            htmlOut.print( "</table>" ) ;
        }
        htmlOut.print("<br></body>") ;
        htmlOut.print("</html>") ;
        htmlOut.println( "Leaving: ShowResult()" ) ;
    }
    protected ProductRow getProductRow( Integer ID  ) throws SQLException
    {
        ProductRow Row = null ;
        htmlOut.println( "<br>getProductRow: "+ ID ) ;

        String Q1 = "select ID, name, price from eproduct where ID = " + ID  ;
        String Q2_Bad = "select Nuts, Screwy, Bananas from DeezTreez where ID = " + ID  ;
        String Q3_Bad = "select ID, name, price from DeezTreez where ID = " + ID  ;
        String Q4_Bad = "select Nuts, Screwy, Bananas from eproduct where ID = " + ID  ;

        sqlResultSet = sqlStatement.executeQuery( Q1 ) ;
        if ( sqlResultSet.next() )
        {
            Row = new ProductRow();
            Row.ID = sqlResultSet.getInt("ID");
            Row.Name = sqlResultSet.getString("name");
            Row.Price = sqlResultSet.getDouble("price");
        }
        return Row ;
    }
    private DBConnection makeDBConnection( String resourceName )
        throws IOException, SQLException, ClassNotFoundException
    {
        InputStream in = getServletContext().getResourceAsStream( resourceName ) ;
        Properties props = new Properties();
        props.load(in);
        return new DBConnection(props.getProperty("url"),
                                    props.getProperty("userid"),
                                        props.getProperty("password"));
    }
}
