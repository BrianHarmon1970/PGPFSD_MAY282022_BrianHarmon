package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*

13. In the ChiliToGo program in EExercise 12, the costs to produce an adult meal and
    a child's meal are $4.35 and #3.10, respectively. Modify the ChiliToGo program to
    display the total profit for each type of meal as well as the grand total profit. Save
    teh program as ChiliToGoProfit.java

 */
public class ChiliToGoProfit
{
    public static void main( String[] args )
    {
        final double ADULT_MEAL_PRICE = 7.00 ;
        final double CHILD_MEAL_PRICE = 4.00 ;

        final double ADULT_MEAL_COST = 4.35 ;
        final double CHILD_MEAL_COST = 3.10 ;

        int adult_meals = 0 ;
        int child_meals = 0 ;
        int total_meals = 0 ;

        double adult_total = 0.0 ;
        double child_total = 0.0 ;
        double total_price = 0.0 ;

        double adult_cost = 0.0 ;
        double child_cost = 0.0 ;
        double total_cost = 0.0 ;

        double adult_net = 0.0 ;
        double child_net = 0.0 ;
        double total_net = 0.0 ;

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

        adult_cost = ADULT_MEAL_COST * adult_meals ;
        child_cost = CHILD_MEAL_COST * child_meals ;
        total_cost = adult_cost + child_cost ;


        adult_net = adult_total - adult_cost  ;
        child_net = child_total - child_cost  ;
        total_net =  total_price - total_cost ;

        System.out.println( "---------------------------------------------------------------" ) ;
        System.out.println( "                    collected\t\tcost\t\tnet profit" ) ;
        System.out.println( "Adult meals: \t\t$" + adult_total + "\t\t\t$" + adult_cost + "\t\t$" + adult_net ) ;
        System.out.println( "Child meals: \t\t$" + child_total + "\t\t\t$" + child_cost + "\t\t$" + child_net ) ;
        System.out.println( "Total:       \t\t$" + total_price + "\t\t\t$" + total_cost + "\t\t$" + total_net ) ;
        System.out.println( "---------------------------------------------------------------" ) ;
    }
}
