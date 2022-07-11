package GameZone;
/*
1   Dice are used in many games. One die can be thrown to randomly show a
    value from 1 through 6. Design a Die class that can hold an integer data field
    for a value ( from 1 to 6 ). Include a constructor that randomly assigns a
    value to a die object. Appendix D contains information about generating random
    numbers. To fully understand the process, you must learn more bout Java
    classes and methods. However, for now, you can copy the following statement
    to generate a random number between 1 and 6 and assign it to a variable.
    Using this statement assumes you have assin=gned appropriate values to the
    static constants.

    randomValue 5 ((int)(Math.random() * 100 ) % HIGHEST_DIE_VALUE+
        LOWEST_DIE_VALUE) ;

    Also includdee a method in the class to return a die's value. Save the class as
    Die.java. Write an application that randomly "throws" two dice and displays
    their values. After you read the chapter "Making Decision", you will be able to
    have the game determine th higher die. For now, just observ how the values
    change as you execute the program multiple times. Save the application as
    TwoDice.java.
 */
public class TwoDice
{
    public static void main( String[] args )
    {
        Die one = new Die();
        Die two = new Die();

        System.out.println("Die one: " + one.getValue() + "\t" + "Die two: " + two.getValue()) ;
    }
}
