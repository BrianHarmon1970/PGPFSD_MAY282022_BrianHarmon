package assignments.A07242022_01;

import java.sql.*;
import java.util.Scanner;

public class JDBCBookProcedure
{
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String urlGlobal =  "jdbc:mysql://localhost:3306" ;

    //private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String user = "root";
    private static final String password = "";
    //private static final int VARCHAR = ;

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static PreparedStatement preparedStatement ;
    private static CallableStatement callStatement ;
    private static Statement stmt;
    private static ResultSet rs;

    private static Scanner input ;
/*
delimiter //
create procedure update_price (IN temp_ISBN varchar(10), IN new_price integer)
begin
update book set price=new_price where ISBN=temp_ISBN;
end; //
DELIMITER ;

delimiter //
create procedure new_update_price (IN author_id int, IN book_id int,  IN new_price integer,
    OUT author_name varchar(20) , OUT author_gender varchar(5),
    OUT book_name varchar(20), OUT book_num_pages integer )
begin
declare author_name varchar(20) ;
declare author_gender varchar( 5 );
declare book_name varchar( 20 ) ;
declare book_num_pages integer ;
declare book_id integer ;
select a.authorname, a.gender, b.book_name, b.pages, b.bookId
into author_name, author_gender, book_name, book_num_pages, book_id
from author a, book b
where a.author_id = b.author and b.bookId = book_id and b.author = author_id ;
update book set price=new_price where book.book_id = book_id ;
end; //
DELIMITER ;
 */
    public static void main(String[] args) {
        try {
            LoadMySqlDriver();
            // opening database connection to MySQL server
            con = getJDBCConnection(url, user, password);
            //updateProcedure();

            String Q1 = "{ call new_update_price( ? , ? , ?, ? , ? , ? , ? ) }" ;
            callStatement = con.prepareCall( Q1 ) ;
            int author_id = 2, book_id = 4 ;
            int new_price = 700 ;
            callStatement.setInt(1, author_id ) ;
            callStatement.setInt( 2, book_id ) ;
            callStatement.setInt( 3, new_price ) ;
            callStatement.registerOutParameter( 6, Types.VARCHAR ) ;
            callStatement.registerOutParameter( 7 , Types.INTEGER);
            callStatement.registerOutParameter( 4, Types.VARCHAR ) ;
            callStatement.registerOutParameter( 5, Types.VARCHAR );

            callStatement.execute() ;

            System.out.println( "Author:\t\t\t" + callStatement.getString(4 )) ;
            System.out.println( "Author Gender:\t" + callStatement.getString(5 )) ;
            System.out.println( "Book Name:\t\t" + callStatement.getString( 6 )) ;
            System.out.println( "pages:\t\t\t" + callStatement.getInt( 7 )) ;

        } catch (SQLException e) {
            System.out.println( e.getLocalizedMessage() ) ;
        }
    }
    public static void updateProcedure() throws SQLException
    {
        String dropSql = " drop procedure new_update_proc " ;
        String createSql = "delimiter // " +
                "create procedure new_update_price (IN author_id int, IN book_id int,  IN new_price integer," +
                "    OUT author_name varchar(20) , OUT author_gender varchar(5)," +
                "    OUT book_name varchar(20), OUT book_num_pages integer )" +
                "begin " +
                "declare author_name varchar(20) ; " +
                "declare author_gender varchar( 5 ); " +
                "declare book_name varchar( 20 ) ; " +
                "declare book_num_pages integer ; " +
                "declare book_id integer ; " +
                "select a.authorname, a.gender, b.book_name, b.pages, b.book_id " +
                "into author_name, author_gender, book_name, book_num_pages, book_id " +
                "from author a, book b " +
                "where a.author_id = b.author_id and b.bookId = book_id and b.author_id = author_id ; " +
                "update book set price=new_price where bookId = book_id ; " +
                "end; // " +
                "DELIMITER ; " ;

        System.out.println(" dropping procedure.. ");
        Statement q1Statement = con.createStatement() ;
        try { q1Statement.execute(dropSql); }  catch(SQLException e)
            { System.out.println( e.getLocalizedMessage()) ;}
        System.out.println(" creating procedure.. ");
        q1Statement = con.createStatement() ;
        q1Statement.execute( createSql ) ;


    }
    public static void LoadMySqlDriver()
    {
        LoadJDBCDriver( "com.mysql.jdbc.Driver" );
    }
    public static void LoadJDBCDriver( String driverURL )
    {
        try {
            Class.forName( driverURL );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getJDBCConnection( String url , String user, String pass ) throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

}
