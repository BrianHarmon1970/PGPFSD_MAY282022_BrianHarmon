package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*
11. Meadowdale Dairy Farm sells organic brown eggs to local customers. IT charges
    $3.25 for a dozen eggs, or 45 cents for individual eggs that are not part of a
    dozen. Write a program that prompts a user for teh number of eggs in the
    order and then display the amount owed with a full explanation. For example,
    typical output might be, Your ordered 27 eggs. That's 2 dozen at $3.25 per
    dozen and 3 loose eggs at 45 cents each for a total of $7.85. Save the program
    as Eggs.java.
 */
public class Eggs
{
    public static void main( String[] args )
    {
        final double COST_PER_DOZEN = 3.25 ;
        final double COST_PER_SINGLE = 0.45 ;
        final int    EGGS_PER_DOZEN = 12 ;

        int total_egg_count = 0  ;
        int dozen_count = 0 ;
        int single_count = 0 ;
        double total_price = 0.0 ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter number of eggs in order>" ) ;
        total_egg_count = input.nextInt() ;

        dozen_count = total_egg_count / EGGS_PER_DOZEN ;
        single_count = total_egg_count % EGGS_PER_DOZEN ;
        total_price = (single_count*COST_PER_SINGLE) + (dozen_count*COST_PER_DOZEN) ;
        System.out.println( "You ordered " + total_egg_count + " eggs." ) ;
        System.out.println( "That is " + dozen_count + " dozen eggs @$"+ COST_PER_DOZEN + "/dozen for $" + (dozen_count*COST_PER_DOZEN) ) ;
        System.out.println( "and " + single_count + " singles @&" + COST_PER_SINGLE + "/egg for $" + (single_count*COST_PER_SINGLE))  ;
        System.out.println( "for a total price of $" + total_price ) ;
    }
}
