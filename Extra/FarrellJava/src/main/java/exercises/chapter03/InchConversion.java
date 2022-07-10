package exercises.chapter03;

import java.util.Scanner;

/*
7. There are 12 inches in a foot and 3 feet in a yard. Create a class named
    InchConversion. Its main() method accepts a value in inches from a user at the
    keyboard, and in turn passes the entered value to two methods. One converts the
    value from inches to fee, and the other converts the same value for inches to
    yards. Each method displays the results with appropriate explanation. Save teh
    application as InchConversion.java

 */
public class InchConversion
{

    static final int INCHES_PER_FOOT = 12 ;
    static final int FEET_PER_YARD = 3 ;
    public static void main( String[] args )
    {
        int inches = getUserInches( "Enter number of inches>" ) ;
        inchesToFeet( inches ) ;
        inchesToYards( inches ) ;
    }
    public static int getUserInches( String prompt )
    {
        int inches ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        inches =  kb.nextInt() ;
        return inches ;
    }
    public static int inchesToFeet( int inches )
    {
        int feet = inches / INCHES_PER_FOOT ;
        System.out.println( inches + " inches is " + feet +" feet." ) ;
        return feet ;
    }
    public static int inchesToYards( int inches )
    {
        int yards = (inches / INCHES_PER_FOOT)/FEET_PER_YARD ;
        System.out.println( inches + " inches is " + yards +" yards." ) ;
        return yards ;
    }
}
