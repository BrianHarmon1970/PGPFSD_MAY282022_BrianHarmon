package jdbc.program;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.Scanner;

public class JavaToMySQL {

	// JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/db_world";

    //private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String user = "root";
    private static final String password = "";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
    	
    	//Creating an object of the class
    	JavaToMySQL ob = new JavaToMySQL();
    	
        Scanner input = new Scanner(System.in);  // taking the user input from the console
    	
        System.out.println("===================== MENU==========================");
        System.out.println("1. Retieve the employees Data"); 
        System.out.println("2. Count number of Employees");
        System.out.println("3. Insert the new employee Record");
        System.out.println("4. Update the employee Record");
        System.out.println("5. Delete one employee Record" ) ;
        System.out.println("====================================================");
    	System.out.println("Enter your choice from (1-5" +
                "): ");
    	
    	int number = input.nextInt();
    	System.out.println("You entered option" + number);
    	
    	switch(number)
    	{
    	    case 1: ob.retrieveData();
    	        break;
    	
    	    case 2: ob.countEmployees();
    	        break;
    	        
    	    case 3: ob.insertRecord();
    	        break;
    	        
    	    case 4: ob.updateRecord();
    	        break;

            case 5: ob.deleteRecord() ;
                break;

    	}	
        
    }
	
    public void retrieveData()
    {
    	String query1= "select empid, empname, salary from emp";
    	
    	try {     	
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  	
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();
    	
    	rs = stmt.executeQuery(query1); 
    	
    	while (rs.next()) 
    	{ 
    	   int id = rs.getInt(1); 
    	   String name = rs.getString(2); 
    	   String salary = rs.getString(3); 
    	   System.out.printf("empid : %d, empname: %s, salary : %s %n", id, name, salary); 
    	}
       }
    	catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
   }
    
    public void countEmployees()
    {
    	String query = "select count(*) from emp";

        try {     	
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        	
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of employees in the company : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
    
    public void insertRecord()
    {
    	String query = "INSERT INTO db_world.emp (empid, empname, salary) \n" + 
                       " VALUES (113, 'Sonam', 34000);";
        try {     	
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        	
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            int v= stmt.executeUpdate(query);
            if(v==1)
            {
            	System.out.println("Record is inserted");
            }
            else
            {
            	System.out.println("Not inserted");
            }

        } catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }        
        }
    }
    
    public void updateRecord()
    {
    	String query = "UPDATE db_world.emp SET salary = 90000 WHERE empid in (108, 105)";
		 try {     	
		 	try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		 	
		     // opening database connection to MySQL server
		     con = DriverManager.getConnection(url, user, password);
		
		     // getting Statement object to execute query
		     stmt = con.createStatement();
		
		     // executing SELECT query
		     stmt.executeUpdate(query);
		
		 } catch (SQLException sqlEx) {
		     sqlEx.printStackTrace();
		 } finally {
		     //close connection ,stmt and resultset here
		     try { con.close(); } catch(SQLException se) { /*can't do anything */ }
		     try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
		    //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
		 }
	  }
    /**************************************************************************
     * Assignment July 23 2022 - compile and run JavaToMySQL application and
     * modify adding delete record feature
     */
    public void deleteRecord()
    {
        //String query = "DELETE FROM db_world.emp WHERE empid = " ;
        String query2 = " delete from emp where empid = " ;
        String query1 = "(select(MAX(emp.empid)) as bigone from db_world.emp )"  ;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            //System.out.println( stmt.executeUpdate(query) );
            ResultSet rs = stmt.executeQuery( query1 ) ;
            int highnum =0 ;
            if( rs.next() ) highnum = rs.getInt("bigone" ) ;
            System.out.print( "bigone is " + highnum ) ;
            stmt.executeUpdate( query2 + highnum ) ;

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

    }

}
