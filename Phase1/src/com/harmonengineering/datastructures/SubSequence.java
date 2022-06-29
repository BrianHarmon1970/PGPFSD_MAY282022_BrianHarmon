package com.harmonengineering.datastructures;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add( 1 ) ; intList.add( 3 ) ; intList.add( 5 ) ;
        intList.add( 7 ) ; intList.add(30);   intList.add(50);
        intList.add(20);   intList.add(40);   intList.add(60);
        intList.add(80);   intList.add(70);   intList.add(20);

        longestSubsequenceMethodA( intList );
        longestSubsequenceMethodB( intList );

        intList.remove(3); intList.remove(2);
        intList.remove(1); intList.remove(0);

        longestSubsequenceMethodA( intList );
        longestSubsequenceMethodB( intList );

        intList.add(10); intList.add(25); intList.add(35);
        intList.add(45); intList.add(65);

        longestSubsequenceMethodA( intList );
        longestSubsequenceMethodB( intList );
    }
    static void longestSubsequenceMethodA( ArrayList<Integer> intList )
    {
        System.out.println( "\nInput Array: " + intList ) ;
        System.out.println( "===  Method A  ===") ;

        int i ;
        int j  ;
        boolean found = false ;
        for ( i=intList.size()  ; i > 0 ; i-- ) {
            if ( found ) break ;
            System.out.println(" size=" + i);
            for (j = (intList.size() - i); j >= 0; j--) {
                if (isIncreasing(intList.subList(j, (j + i)))) {
                    found = true ;
                    break ;
                }
            }
        }
    }
    static boolean isIncreasing( List<Integer> list )
    {
        System.out.println( list ) ;
        for( int i = 1 ; i < list.size() ; ++i )
        {
            if ( list.get( i-1 ) > list.get( i ) )
                return false ;
        }
        System.out.println( "Found sequence: " + list ) ;
        return true ;
    }
    static void longestSubsequenceMethodB( ArrayList<Integer> intList )
    {
        System.out.println( "\nInput Array: " + intList ) ;
        System.out.println( "===  Method B  ===" ) ;
        // another method
        int highStart = 0 ;
        int highLength = 0 ;
        int currentStart = 0 ;
        int currentLength = 1 ;
        int ndx = 1 ;

        while( ndx  <=  (intList.size())  )
        {
            if ((ndx == intList.size()) ||(intList.get( ndx - 1) > intList.get( ndx )) )
            {
                System.out.println( " current_start: " + currentStart + " current_length: " + currentLength ) ;
                if ( currentLength > highLength )
                {
                    highStart = currentStart ;
                    highLength = currentLength ;
                    System.out.println( " high_start: " + highStart + " high_length: " + highLength ) ;
                }
                currentStart += currentLength ;
                currentLength = 0;
            }
            ++currentLength ;
            ndx++ ;
        }
        System.out.println( "found sequence at: " + highStart  ) ;
        System.out.println( "length is: " + highLength ) ;
        System.out.println( " high_start: " + highStart + " high_length: " + highLength ) ;
        System.out.println( intList.subList( highStart, highStart+highLength )) ;
    }
}