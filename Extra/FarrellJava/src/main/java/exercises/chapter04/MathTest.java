package exercises.chapter04;
/*
7.  a.  Write a Java application that uses the Math class to determine the answers for
        each of the following:

        a.  The square root of 37
        b.  The sine and cosine of 300
        c.  The value of the floor, ceiling, and round of 22.8
        d.  The larger and the smallest of the character 'D' and the  integer 71
        3.  A random number between 0 and 20 ( Hint: the random() method returns a
            value between 0 and 1; you want a number that is 20 times larger.)

        Save the application as MathTest.java

 */
public class MathTest
{
    public static void main( String[] args )
    {
        showValue( "The square root of 37 is ", Math.sqrt( 37 )) ;
        showValue( "The sin of 300 is " ,  Math.sin( 300 )) ;
        showValue( "The cosine of 300 is ", Math.cos( 300 )) ;
        showValue( "The smaller of 'D' and 71 is ", (Math.min( 71, 'D'))) ;
        showValue( "The larger of 'D' and 71 is ", Math.max( 'D',71 )) ;
        showValue( "A random number between( 0-20 ) is ", (int)(Math.random() * 20.0) ) ;
    }
    static void showValue( String value_name, double value )
    {
        System.out.println( value_name + value ) ;
    }

}
