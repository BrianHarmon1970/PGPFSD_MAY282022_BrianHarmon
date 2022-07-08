package exercises.chapter02;
/*

6. Write a program that declares named constants to represent the number of
    inches, feet, and yard in a mile. Also declare a variable to represent a number
    of miles and assign a value to it. Compute and display, with explanatory text, the
    value in inches, feet and yards. Save the program as MilesConversions.java.

 */
public class MilesConversions
{
    public static void main( String[] args )
    {
        final int FEET_PER_MILE = 5280 ;
        final int INCHES_PER_MILE = FEET_PER_MILE * 12 ;
        final int YARDS_PER_MILE = FEET_PER_MILE / 3  ;

        int miles = 110 ;

        int inches = miles * INCHES_PER_MILE ;
        int feet = miles * FEET_PER_MILE ;
        int yards = miles * YARDS_PER_MILE ;

        System.out.println( "The number of inches in " + miles + " miles is " + inches ) ;
        System.out.println( "In " + miles + " miles there are " + yards + " yards." ) ;
        System.out.println( "The number of feet in " + miles + " miles is " + feet ) ;
    }
}
