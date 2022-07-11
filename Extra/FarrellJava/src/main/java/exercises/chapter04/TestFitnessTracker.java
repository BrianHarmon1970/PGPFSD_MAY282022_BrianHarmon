package exercises.chapter04;

import java.time.LocalDate;

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

    c. Modify the FitnessTracker class so that the default constructor calls
        the three-parameter constructor. Save the class as FitnessTracker2.java.
        Create an application to test the new version of the class, and name it
        TestFitnessTracker2.java.


 */
public class TestFitnessTracker
{
    public static void main( String[] args )
    {
        FitnessTracker ft = new FitnessTracker() ;
        displayTracker( ft ) ;
        FitnessTracker ft2 = new FitnessTracker( "Coding", 20 , LocalDate.now()) ;
        displayTracker( ft2 ) ;
    }
    public static void displayTracker( FitnessTracker ft )
    {
        System.out.println( "Fitness Tracker" ) ;
        System.out.println( "Activity:\t" + ft.getActivity() ) ;
        System.out.println( "Minutes:\t" + ft.getMinutes()) ;
        System.out.println( "Date:\t\t" + ft.getDate() ) ;
    }
}
