package exercises.chapter02;
/*
4.  Write a program that declares a named constant to hold the number of quarts in
        a gallon (4). Also declare a variable to represent the number of quarts needed for
        a painting job, and assign an appropriate value -- for example, 18. Compute and
        display  the number of gallons and quarts needed for the job. Display explanatory
        text with the values--for example, "A job that needs 18 quarts requires 4 gallons
        plus 2 quarts". Save the program as QuartsToGallons.java.
*/
public class QuartsToGallons
{

    public static void main( String[] args )
    {
        final int QUARTS_PER_GALLON = 4 ;
        int required_quarts = 18 ;
        int gallons = ( required_quarts / QUARTS_PER_GALLON ) ;
        int quarts = ( required_quarts % QUARTS_PER_GALLON ) ;
        System.out.println( "A paint job that needs " + required_quarts +
                " quarts requires " + gallons + " gallons plus " + quarts + " quarts/"
        ) ;
    }
}
