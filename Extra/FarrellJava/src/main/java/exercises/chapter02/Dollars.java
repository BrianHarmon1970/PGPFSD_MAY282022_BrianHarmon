package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*

14. Write a program that calculates and display the converts of an entered number
    of dollars into currency denominations - 20s, 10s, 5s, and 1s. Save the program as
    Dollars.java.

 */
public class Dollars
{
    public static void main( String[] args )
    {
        double dollars ;
        int     twenties ;
        int     tens ;
        int     fives ;
        int     ones ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter dollar amount>" ) ;
        dollars = input.nextDouble() ;

        twenties = (int)dollars / 20 ;
        tens =  ((int)dollars-(twenties*20)) / 10 ;
        fives = ((int)dollars-(twenties*20)-(tens*10)) / 5 ;
        ones =  ((int)dollars-(twenties*20)-(tens*10)-(fives*5)) ;

        System.out.println( "Twenties - " + twenties ) ;
        System.out.println( "    Tens - " + tens ) ;
        System.out.println( "   Fives - " + fives ) ;
        System.out.println( "    Ones - " + ones ) ;
    }
}
