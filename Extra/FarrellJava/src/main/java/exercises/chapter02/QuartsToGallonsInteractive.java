package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*
5. Convert the QuartsToGallons program to an interactive application. Instead
    of assigning a value to the number of quarts, accept the value from th user as
    input. Save the revised program as QuartsToGallonsInteractive.java.

 */
public class QuartsToGallonsInteractive
{
    public static void main( String[] args )
    {
        final int QUARTS_PER_GALLON = 4 ;
        int required_quarts  ;
        Scanner input = new Scanner( in ) ;

        System.out.print( "Enter required quarts>") ;
        required_quarts = input.nextInt() ;

        int gallons = ( required_quarts / QUARTS_PER_GALLON ) ;
        int quarts = ( required_quarts % QUARTS_PER_GALLON ) ;
        System.out.println( "A paint job that needs " + required_quarts +
                " quarts requires " + gallons + " gallons plus " + quarts + " quarts"
        ) ;
    }
}