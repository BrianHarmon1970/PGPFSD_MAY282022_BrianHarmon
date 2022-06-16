package com.harmonengineering.emailList;

import java.util.ArrayList;
import java.util.Scanner;

public class emailID
{
    public static String email_list[] = {
               "123@java.com" ,
                "John@doe.com"  ,
                "jane@doe.com"  ,
                "August@real.com"
    } ;
    public static void main( String[] args )
    {
        displayEmailList() ;

        String selectString = new String() ;
        Scanner scanner = new Scanner( System.in ) ;

        while ( true )
        {
            System.out.print( "Enter email:> " ) ;
            selectString = scanner.next();
            if ( selectString.equals("exit")) break ;
            if ( selectString.equals("list")) displayEmailList() ;
            else
            {
                System.out.println(selectString);
                if (findEmail(selectString))
                    System.out.println("email found.");
                else System.out.println("email not found.");
            }
        }
    }
    public static void displayEmailList( )
    {
        for (int i = 0; i < email_list.length; ++i)
            System.out.println("email list contents: " + email_list[i]);
    }
    public static boolean findEmail( String selection )
    {
        ArrayList<String> list = new ArrayList<String>( ) ;
        for ( int i = 0 ; i < email_list.length ; ++i )
            list.add( email_list[ i ].toLowerCase() ) ;
        //System.out.println( "Email list contents: " + list ) ;
        return list.contains(selection.toLowerCase());
    }
}
