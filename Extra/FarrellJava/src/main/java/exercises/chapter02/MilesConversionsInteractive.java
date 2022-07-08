package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*

7.  Convert the MIleConversion program to be an interactive application. Instead of
    assigning a value to the miles variable, accept it from the user as input. Save the
    revised program as MIleConversionsInteractive.java.

 */
public class MilesConversionsInteractive
{
    public static void main( String[] args )
    {
        final int FEET_PER_MILE = 5280 ;
        final int INCHES_PER_MILE = FEET_PER_MILE * 12 ;
        final int YARDS_PER_MILE = FEET_PER_MILE / 3  ;

        int miles = 110 ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter number of miles>" ) ;
        miles = input.nextInt() ;

        int inches = miles * INCHES_PER_MILE ;
        int feet = miles * FEET_PER_MILE ;
        int yards = miles * YARDS_PER_MILE ;

        System.out.println( "The number of inches in " + miles + " miles is " + inches ) ;
        System.out.println( "In " + miles + " miles there are " + yards + " yards." ) ;
        System.out.println( "The number of feet in " + miles + " miles is " + feet ) ;
    }
}
