package exercises.chapter04;

import java.time.LocalDate;

/*

3.      c. Modify the FitnessTracker class so that the default constructor calls
        the three-parameter constructor. Save the class as FitnessTracker2.java.
        Create an application to test the new version of the class, and name it
        TestFitnessTracker2.java.

 */
public class FitnessTracker2
{
    private String strActivity ;
    private int nMinutes ;
    private LocalDate date ;

    public FitnessTracker2()
    {
        this( "Running", 0, LocalDate.of( 2022, 1, 1)) ;
    }
    public FitnessTracker2( String activity, int minutes, LocalDate date )
    {
        strActivity = activity ;
        nMinutes = minutes ;
        this.date = date ;
    }
    public String getActivity() { return strActivity;   }
    public int getMinutes() { return nMinutes; }
    public LocalDate getDate() { return date; }
}
