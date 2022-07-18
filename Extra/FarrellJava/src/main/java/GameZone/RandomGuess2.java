package GameZone;

import javax.swing.*;

public class RandomGuess2 {
    public static void main( String[] args )
    {
        JOptionPane.showMessageDialog( null, "Think of a number between 1 & 10." ) ;
        int random_number = (int)(Math.random() * 10 ) ;
        JOptionPane.showMessageDialog( null, "The number was " + random_number ) ;
    }
}
