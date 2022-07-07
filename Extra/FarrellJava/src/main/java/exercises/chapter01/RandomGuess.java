package exercises.chapter01;
import javax.swing.JOptionPane ;

// Java Programming, Joyce Farrell
// Chapter 1 Game Zone
/*
Write a Java application that displays two dialog boxes in sequence. The first asks
        you to think of a number between 1 and 10. The second displays a randomly
        generated number, the user can see whether his or her guess was accurate.
        (In future chapters. you will improve this game so that the user can enter a
        guess and the program can determine whether the user was correct. If you
        wish, you also can tell the user how far off the guess was, whether the guess was
        high or low, and provide a specific number of repeat attempts.)
 */
public class RandomGuess
{
    public static void main( String[] args )
    {
        JOptionPane.showMessageDialog( null, "Think of a number between 1 & 10." ) ;
        int random_number = (int)(Math.random() * 10 ) ;
        JOptionPane.showMessageDialog( null, "The number was " + random_number ) ;
    }    
}
