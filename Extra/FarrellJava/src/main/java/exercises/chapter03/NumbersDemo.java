package exercises.chapter03;
/*
4.  a.  Create an application named NumbersDemo whose main() method holds two
        integer variables. Assign values to the variables. In turn, pass each value to
        methods named displayTwiceTheNumber(), displayNumberPlusFive(), and
        displayNumberSquared(). Create each method to perform the task its name
        implies. Save the application as NumbersDemo.java.

        b.  Modify the NumbersDemo class to accept the values of the two integers from a
        user at the keyboard. Save the file as NumbersDemo2.java
*/
public class NumbersDemo {
    public static void main(String[] args)
    {
        int number1 = 3, number2 = 5;
        displayTwiceTheNumber(number1);
        displayTwiceTheNumber(number2);

        displayTheNumberPlusFive(number1);
        displayTheNumberPlusFive(number2);

        displayTheNumberSquared(number1);
        displayTheNumberSquared(number2);
    }
    public static void displayTwiceTheNumber(int n)  {  displayNumber(  "Twice The Number   " , n, n*2 ); }
    public static void displayTheNumberPlusFive(int n) { displayNumber( "The Number Plus 5  " , n, n+5 ); }
    public static void displayTheNumberSquared(int n) {  displayNumber( "The Number Squared " , n, n*n ); }
    public static void displayNumber( String s, int n1, int n2 )
    {
        System.out.println( s + " ("+n1+")  is " + n2 ) ;
    }
}
