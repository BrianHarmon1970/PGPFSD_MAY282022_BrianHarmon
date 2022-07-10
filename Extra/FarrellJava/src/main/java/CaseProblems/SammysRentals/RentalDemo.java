package CaseProblems.SammysRentals;

import java.util.Scanner;

import static java.lang.System.in;

/*

    c. Use the SammysRentalPriceWithMethods class you created in Step 2a as a
        starting point for a program that demonstrates the Rental class you created
        in Step 2b, but make the following changes:

        You already have a method that gets a number of minutes from a user;
        now add a method that gets a contract number. The main() method s
        should declare a Rental object, call the two data entry methods, and use
        their returned values to set the fields in the Rental object.

        From the SammysRentalPriceWithMethods class, call the REntalDemo
        method that displays the company motto with the border. The method
        is accessible because it is public. but you must fully qualify the
        name because it is in another class.

        Revise the method that displays the rental details so that it accepts the
        newly created Rental object. The method should display the contract
        number, and it still should display the hours and minutes, the hourly rate,
        and the total price.

    Save the program as RentalDemo.java

 */
public class RentalDemo
{
    public static void main( String[] args )
    {
        Rental r = new Rental() ;

        r.setHoursAndMinutes( getUserMinutes() ) ;
        SammysRentalPriceWithMethods.printMottoWithBorders();
        printInvoice( r ) ;

    }
    static void printMottoWithBorders()
    {
        System.out.println( " SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS" ) ;
        System.out.println( "S                                        S" ) ;
        System.out.println( "S    Sammy's makes it fun in the sun     S" ) ;
        System.out.println( "S                                        S" ) ;
        System.out.println( " SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS" ) ;
    }
    static int getUserMinutes( )
    {
        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter number of minutes rented>" ) ;
        return input.nextInt() ;
    }
    static void printInvoice( Rental rental )
    {
        int hours ;
        int minutes ;
        double TotalPrice ;

        hours = rental.getHours() ; //rented_minutes / MINUTES_PER_HOUR ;
        minutes = rental.getMinutes() ;//rented_minutes % MINUTES_PER_HOUR ;
        TotalPrice = rental.getTotalPrice() ; // ((hours * HOUR_RATE)+(minutes * MINUTE_RATE )) ;

        System.out.println( rental.getMinutesRented() + " minutes rented - " +
                hours + " hours @ $" + Rental.HOUR_RATE + "/hr and " +
                minutes + " additional minutes @ $" + Rental.MINUTE_RATE+ "/min " +
                "for a total price of $" + TotalPrice ) ;
    }
}
