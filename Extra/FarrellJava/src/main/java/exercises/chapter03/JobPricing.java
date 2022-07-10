package exercises.chapter03;

import java.util.Scanner;

/*
10. Herbert's Home Repair estimates each job cost as the cost of materials plus $35
    per hour while on the job, plus $12 per hour for travel time to the job site. Create
    a class that contains a main() method that prompts the user for th name of a
    job (for example, Smith bathroom remodel), the cost of material, the number of
    hours of work required, and the number of hours travel time. Pass the numeric
    data to a method that computes estimate for the job and returns the computed
    value to the main() method where the job name and estimated price are
    displayed. Save the program as JobPricing.java.

 */
public class JobPricing
{
    static final double ONSITE_RATE = 35.00 ;
    static final double TRAVEL_RATE = 12.00 ;

    public static void main( String[] args )
    {
        String job_name = getUserString( "Enter job name> " ) ;

        double material_cost = getUserNumber( "Enter material cost> " ) ;
        double onsite_hours = getUserNumber( "Enter required onsite hours> ") ;
        double travel_hours = getUserNumber( "Enter travel time hours> " ) ;


        double estimated_price = calculateEstimate( material_cost, onsite_hours, travel_hours ) ;
        System.out.println( "Job: " + job_name + " -- $" + estimated_price ) ;
    }
    static double calculateEstimate( double material_cost, double onsite_hours, double travel_hours )
    {
        return ((onsite_hours*ONSITE_RATE)+(travel_hours*TRAVEL_RATE)+(material_cost)) ;
    }
    static double getUserNumber( String prompt )
    {
        double number ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        number =  kb.nextDouble() ;
        return number ;
    }
    static String getUserString( String prompt )
    {
        String string ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        string =  kb.nextLine() ;
        return string ;
    }
}
