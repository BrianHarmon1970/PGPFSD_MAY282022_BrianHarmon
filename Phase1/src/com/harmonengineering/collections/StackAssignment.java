package com.harmonengineering.collections;

import java.util.Stack;

/*
Stack
1) add 5 fruits
2) add 4 cities
3) add 4 integer variables
4) add two char variables
operations:
1- print stack
2- remove 5 elements
3- peek element
4- remove 2 elements
5- poll 2 elements
6- check top of stack and print
7- check index of "Apple" and "Delhi"
 */
public class StackAssignment
{
    public static void main( String[] args )
    {
        Stack stack = new Stack() ;
        // 5 fruits
        stack.push( "Apple" ) ;
        stack.push( "Banana" ) ;
        stack.push( "Cherry" ) ;
        stack.push( "Blueberry" ) ;
        stack.push( "Raspberry" ) ;
        // 4 cities
        stack.push( "New York" ) ;
        stack.push( "Los Angeles" ) ;
        stack.push( "Dallas" ) ;
        stack.push( "Delhi" ) ;
        // 4 integer values
        stack.push( "8008" ) ;
        stack.push( "8088" ) ;
        stack.push( "80386" ) ;
        stack.push( "80486" ) ;
        // 2 char values
        stack.push( "M" ) ;
        stack.push( "Z" ) ;

        System.out.println( "stack: " + stack ) ;
        for ( int i = 0 ; i < 5 ; ++i )
        {
            stack.pop() ;
        }
        System.out.println( "stack: " + stack ) ;
        System.out.println( "Peek: " + stack.peek() ) ;
        stack.remove( 0 )  ;
        stack.remove( 0 ) ;
        System.out.println( "stack: " + stack ) ;
        System.out.println( "Pop: " + stack.pop() ) ;
        System.out.println( "Pop: " + stack.pop() ) ;
        System.out.println( "stack: " + stack ) ;
        System.out.println( "TOS: " + stack.peek() ) ;
        System.out.println( "index of Apple: " + stack.indexOf("Apple" )) ;
        System.out.println( "index of Delhi: " + stack.indexOf("Delhi" )) ;
    }
}
