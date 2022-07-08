package exercises.chapter02;
/*
8.  Write a program that declares a variable named inches, which holds a length
    in inches, and assign a value . Display the value in feet and inches; for example,
    86 inches becomes 7 feet and 2 inches. Be sure to use a named constant where
    appropriate. Save the program InchesToFeet.java

 */
public class InchesToFeet
{
    public static void main( String[] args )
    {
        final int INCHES_PER_FOOT = 12 ;
        int total_inches = 86 ;

        int feet = total_inches / INCHES_PER_FOOT ;
        int inches = total_inches % INCHES_PER_FOOT ;

        System.out.println( total_inches + " is " + feet + " feet " + inches + " inches." ) ;
    }
}
