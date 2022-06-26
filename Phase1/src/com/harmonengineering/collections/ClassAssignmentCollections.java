package com.harmonengineering.collections;

import java.util.*;

public class ClassAssignmentCollections
{
    public static void main( String[] args )
    {
        LinkedHashSet L1 = new LinkedHashSet() ;
        AssignemntOne();
        AssignementTwo();
    }
    public static void AssignemntOne()
    {
        LinkedHashSet L1 = new LinkedHashSet() ;

        LinkedHashSet<Integer> L2 = new LinkedHashSet<Integer>() ;

        L1.add( 123 ) ;
        L1.add( 321 ) ;
        L1.add( 1023.00 ) ;
        L1.add( 1023.24 ) ;
        L1.add( 'X' ) ;
        L1.add( 'V' ) ;
        L1.add( true ) ;
        System.out.println( "L1 contents: " + L1 ) ;

        Scanner coninput = new Scanner( System.in ) ;
        for ( int i = 0 ; i < 8 ; ++i )
        {
            System.out.print( "Enter>" ) ;
            L2.add(coninput.nextInt());
        }
        System.out.println( "L2 contents: " + L2 ) ;
    }
    public static void AssignementTwo()
    {
        TreeSet<String> LangSet = new TreeSet<String>() ;

        LangSet.add("C++" ) ;
        LangSet.add( "Java" ) ;
        LangSet.add( "Python" ) ;
        LangSet.add( "COBOL" ) ;
        LangSet.add( "FORTRAN" ) ;
        LangSet.add( "TypeScript" ) ;
        System.out.println( "Languages: " + LangSet ) ;

        LangSet.remove("COBOL" ) ;
        LangSet.remove( "FORTRAN" ) ;
        System.out.println( "Languages: " + LangSet ) ;

        System.out.println( "Java included? " + ( LangSet.contains("Java") ? "true" : "false")) ;
        LangSet.clear() ;
        System.out.println( "Languages: " + LangSet ) ;
    }
}
