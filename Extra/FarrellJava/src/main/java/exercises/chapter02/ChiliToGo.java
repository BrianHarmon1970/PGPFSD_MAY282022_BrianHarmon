package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*

12. The Huntington Boys and Girls Club is conducting a fundraiser by selling chili
    dinners to go. The price is $7 for an adult meal and $4 for child's meal. Write a
    program that accepts the number of each type of meal ordered and display the
    total money collected for adult meals, children's meals, and all meals. Save the
    total money collected for adult meals, children's meals , and all meals. Save the
    program as ChiliToGo.java.

 */
public class ChiliToGo
{
    public static void main( String[] args )
    {
        final double ADULT_MEAL_PRICE = 7.00 ;
        final double CHILD_MEAL_PRICE = 4.00 ;

        int adult_meals = 0 ;
        int child_meals = 0 ;
        int total_meals = 0 ;

        double adult_total = 0.0 ;
        double child_total = 0.0 ;
        double total_price = 0.0 ;

        System.out.println( "============================================" ) ;
        System.out.println( " Adult chili dinner \t$" + ADULT_MEAL_PRICE ) ;
        System.out.println( " Child chili dinner \t$" + CHILD_MEAL_PRICE ) ;
        System.out.println( "============================================" ) ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter the number of adult meals required>" ) ;
        adult_meals = input.nextInt() ;
        System.out.print( "Enter the number of child meals required>" ) ;
        child_meals = input.nextInt() ;
        total_meals = adult_meals + child_meals ;

        adult_total = ADULT_MEAL_PRICE * adult_meals ;
        child_total = CHILD_MEAL_PRICE * child_meals ;
        total_price = adult_total + child_total ;

        System.out.println( "----------------------------------------" ) ;
        System.out.println( "Adult meals: \t$" + adult_total ) ;
        System.out.println( "Child meals: \t$" + child_total) ;
        System.out.println( "Total:       \t$" + total_price ) ;      ;
        System.out.println( "----------------------------------------" ) ;

    }
}
