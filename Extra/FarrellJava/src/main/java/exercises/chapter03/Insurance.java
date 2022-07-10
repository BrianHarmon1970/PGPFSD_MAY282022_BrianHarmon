package exercises.chapter03;

import java.util.Scanner;

/*

9.  The Harrison Group Life Insurance company computes annual policy premiums
    based on the age the customer turns in the current calendar year. The premium
    is computed by taking the decade of the customer's age, adding 15 to it, and
    multiplying by 20.  For example, a 34-year-old would pay $360, which is calculated
    by adding the decades(3) to 15, and then multiplying by 20. Write an application
    that prompts a user for current year and a birth year. Pass both to a method
    that calculates and returns a premium amount and then displays the returned
    amount.Save the application as Insurance.java
 */
public class Insurance
{
    public static void main( String[] args )
    {
        int currentYear = getUserNumber( "Enter current year>" ) ;
        int birthYear = getUserNumber( "Enter birth year>") ;
        double premium = computePremium( currentYear, birthYear ) ;
        System.out.println( "Premium: " + premium ) ;
    }
    public static double computePremium( int current_year, int year_of_birth )
    {
        return ((((int)((current_year-year_of_birth) / 3 )+15)*20.0)) ;
    }
    public static int getUserNumber( String prompt )
    {
        int number ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        number =  kb.nextInt() ;
        return number ;
    }
}
