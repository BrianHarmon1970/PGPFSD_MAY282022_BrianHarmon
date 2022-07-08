package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*

15. Write a program that accepts a number of minutes and converts it both to hours
    and days. For example, 6,000 minutes equals 100 hours and equals 4.167 days.
    Save the program as MinutesConversion.java.

 */
public class MinutesConversion
{
    public static void main( String[] args )
    {
        final int MINUTES_PER_HOUR = 60 ;
        final int HOURS_PER_DAY = 24 ;
        final int MINUTES_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR ;

        int minutes ;
        double hours ;
        double days ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter minutes>" ) ;
        minutes = input.nextInt() ;

        hours = minutes / (double)MINUTES_PER_HOUR ;
        days = minutes / (double)MINUTES_PER_DAY ;

        System.out.println( minutes + " minutes is " + hours + " hours or " + days + " days." ) ;



    }
}
