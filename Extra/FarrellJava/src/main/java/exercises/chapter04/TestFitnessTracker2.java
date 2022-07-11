package exercises.chapter04;

import java.time.LocalDate;

/*

3.     c. Modify the FitnessTracker class so that the default constructor calls
        the three-parameter constructor. Save the class as FitnessTracker2.java.
        Create an application to test the new version of the class, and name it
        TestFitnessTracker2.java.


 */
public class TestFitnessTracker2
{
    public static void main( String[] args )
    {
        FitnessTracker2 ft2_one = new FitnessTracker2() ;
        displayTracker( ft2_one ) ;
        FitnessTracker2 ft2_two = new FitnessTracker2( "Munching", 45 , LocalDate.now()) ;
        displayTracker( ft2_two ) ;
    }
    public static void displayTracker( FitnessTracker2 ft )
    {
        System.out.println( "Fitness Tracker2" ) ;
        System.out.println( "Activity:\t" + ft.getActivity() ) ;
        System.out.println( "Minutes:\t" + ft.getMinutes()) ;
        System.out.println( "Date:\t\t" + ft.getDate() ) ;
    }
}
