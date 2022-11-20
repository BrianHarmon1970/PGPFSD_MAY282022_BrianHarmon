package YouDoIt.chapter04;
// Java Programming, by Joyce Farrell - Chapter 4 - You Do It p. 214

import javax.swing.JOptionPane ;
import java.time.* ;

public class TimedResponse
{
    public static void main( String[] args )
    {
        LocalDateTime time1, time2 ;
        int seconds1, seconds2, difference ;

        time1 = LocalDateTime.now() ;
        seconds1 = time1.getSecond() ;

        JOptionPane.showConfirmDialog
            ( null, "Is stealing ever justified? ") ;
        time2 = LocalDateTime.now() ;
        seconds2 = time2.getSecond() ;

        difference = seconds2 - seconds1 ;
        JOptionPane.showMessageDialog( null, "End seconds: " + seconds2 +
                "\nStart seconds: " + seconds1 +
                "\nIt took " + difference + " seconds for you to answer" ) ;
    }
}
