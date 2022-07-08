package YouDoIt.chapter02;// Programming Java - chatper 2 - You Do It p. 78(continued-81)
import java.util.Scanner ;

import static java.lang.System.in;

public class IntegerDemoInteractiveWithName
{
    public static void main( String[] args )
    {
        int anInt  ;
        byte aByte  ;
        short aShort  ;
        long aLong  ;
        String name ;

        Scanner input = new Scanner( in ) ;

        System.out.print( "Please enter an integer >>" ) ;
        anInt = input.nextInt() ;

        System.out.print( "Please enter a byte integer >>" ) ;
        aByte = input.nextByte() ;

        System.out.print( "Please enter a short integer >>" ) ;
        aShort = input.nextShort() ;

        System.out.print( "Please enter a long interger >>" ) ;
        aLong = input.nextLong() ;

        System.out.println( " The int is     " + anInt ) ;
        System.out.println( " The byte is    " + aByte ) ;
        System.out.println( " The short is   " + aShort ) ;
        System.out.println( " The long is    " + aLong ) ;

        System.out.print( "Please enter a name >>" ) ;
        input.nextLine() ;
        name = input.nextLine() ;
        System.out.println( "Thank you, " + name ) ;


    }
}
