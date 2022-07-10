package exercises.chapter03;

import java.util.Scanner;

/*

8.  Assume that a gallon of paint covers about 350 square feet of wall space. Create
    an application with a main() method that prompts the user for the length, width,
    and height of a rectangular room. Pass these three values toa method that does the following:

        Calculates the wall area for a room

        Passes teh calculated wall area to another method that calculates and returns
        the number of gallons of paint needed.

        Displays the number of gallons needed

        Computes the price based on a paint price of $32 pre gallon, assuming that
        the painter can buy any fraction of a gallon of paint at the same price as a
        whole gallon.

        Returns the price to the main() method

    The main() method displays the final price. For example, the cost to paint
    a 15-by-20-foot room with 10-foot ceilings is $64. Save the application as
    PaintCalculator.java

 */
public class PaintCalculator
{
    static final double SQUARE_FEET_PER_GALLON = 350.0 ;
    static final double PRICE_PER_GALLON = 32.00 ;
    public static void main( String[] args )
    {
        System.out.println( "\n****** Paint Calculator ******" ) ;
        System.out.println( "Enter the job dimensions" ) ;
        double length = getUserNumber( "Length>" ) ;
        double width = getUserNumber( "Width>" ) ;
        double height = getUserNumber( "Height>" ) ;
        double price = getJobPrice( length, width, height ) ;
        System.out.println( "The price to paint a " + length + " ft x " + width +
                " ft room with a " + height + " ft ceiling will be $" + price ) ;
    }
    static double getJobPrice( double l , double w, double h )
    {
        double area = (((l * h)*2) + ((w * h)*2))  ;
        double gallons = getJobGallons( area ) ;
        System.out.println("The job will require " + gallons +
                " gallons of paint to cover " + area +" square feet." ) ;
        return PRICE_PER_GALLON * gallons ;
    }
    static double getJobGallons( double area )
    {
        return area / SQUARE_FEET_PER_GALLON ;

    }
    static double getUserNumber( String prompt )
    {
        double number ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        number =  kb.nextDouble() ;
        return number ;
    }
}
