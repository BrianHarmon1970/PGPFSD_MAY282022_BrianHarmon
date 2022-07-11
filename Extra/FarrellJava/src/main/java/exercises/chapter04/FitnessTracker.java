package exercises.chapter04;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
3.  a.  Create a FitnessTracker class that includes dat fields for a fitness activity,
        the number of minutes spent participating, and the date. The class includes
        methods to get each field. In addition, create a default constructor that
        automatically  sets the activity to running, the minutes to o, and the date to
        January 1 of the current year. Save teh file as FitnessTracker.java. Create an
        application that demonstrates each method works correctly, and save it as
        TestFitnessTracker.java.

    b. Create an additional overloaded constructor fo the FitnessTracker class
        you created in Exercise 3a. This constructor receives parameters for each of
        the data fields and assigns them appropriately. Add any needed statements
        to the TestFitnessTracker application to ensure that the overloaded
        constructor works correctly, save it, and the test it.
 */
public class FitnessTracker
{
    private String strActivity ;
    private int nMinutes ;
    private LocalDate date ;

    public FitnessTracker()
    {
        strActivity = "Running" ;
        nMinutes = 0 ;
        date = LocalDate.of( 2022, 1, 1 ) ;
    }
    public FitnessTracker( String activity, int minutes, LocalDate date )
    {
        strActivity = activity ;
        nMinutes = minutes ;
        this.date = date ;
    }
    public String getActivity() { return strActivity;   }
    public int getMinutes() { return nMinutes; }
    public LocalDate getDate() { return date; }
}
