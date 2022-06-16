package com.harmonengineering.emailList;

import java.util.ArrayList;
import java.util.Scanner;

public class emailID
{
    public static class EmailList {
        public static String email_list[] = {
                "123@java.com",
                "John@doe.com",
                "jane@doe.com",
                "August@real.com"
        };
        public boolean findEmail( String selection )
        {
            ArrayList<String> list = new ArrayList<String>( ) ;
            for ( int i = 0 ; i < email_list.length ; ++i )
                list.add( email_list[ i ].toLowerCase() ) ;
            //System.out.println( "Email list contents: " + list ) ;
            return list.contains( selection.toLowerCase());
        }
        public void display( )
        {
            for (int i = 0; i < email_list.length; ++i)
                System.out.println("email list contents: " + email_list[i]);
        }
    }
    public static class User
    {
        boolean m_userQuit ;
        Scanner m_scanner ;
        public User()
        {
            m_userQuit = false ;
            m_scanner = new Scanner( System.in ) ;
        }
        public String getEmail()
        {
            String input = new String() ;
            System.out.print( "Enter email:> " ) ;
            input = m_scanner.next() ;
            if ( input.equals( "exit" )) m_userQuit = true ;
            return ( input ) ;
        }
        public boolean isQuit() { return m_userQuit ; }
    }
    public static void main( String[] args )
    {
        System.out.println() ;
        System.out.println( " <<<=================== This is the Email List App ===================>>> " ) ;
        System.out.println( " Enter a valid email address at the prompt to check it's availability" ) ;
        System.out.println( " Alternatively you may select one of the following special commands:" ) ;
        System.out.println( "   list -- list the contents of the email list " ) ;
        System.out.println( "   exit -- causes the application to close and terminate" ) ;
        System.out.println( " <<<=================================================================>>> " ) ;

        EmailList email_list = new EmailList() ;
        User user = new User() ;

        String selectString = new String() ;
        while ( !user.isQuit())
        {
            selectString = user.getEmail() ;
            if ( selectString.equals("exit")) continue; ;
            if ( selectString.equals("list")) email_list.display() ;
            else
            {
                System.out.println(selectString);
                if ( email_list.findEmail(selectString))
                    System.out.println("email found.");
                else System.out.println("email not found.");
            }
        }
    }
}
