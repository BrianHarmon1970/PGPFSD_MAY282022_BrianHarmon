package exercises.chapter04;

import java.time.LocalDate;

/*
11. Create a class named Person that holds the following fields: two String objects
    for the Person's first and last name and a LocalDate object for the Person's
    birthdate. Create a class named Couple that contains two Person objects. Creat a
    class named Wedding for a wedding planner that includes the date of the wedding
    the names of the Couple being married and a String for the location. Provide
    constructors for each class that accept parameters for each field, and provide get
    methods for each field. Then write a program that creates two Wedding objects
    and in turn passes each to a method that displays all the details.Save the files as
    Person.java, Couple.java, Wedding.java and TestWedding.java.
 */
public class TestWedding
{
    public static void main( String[] args )
    {
        Wedding aWedding ;
        Person  aMan ;
        Person  aWoman ;
        Couple  aCouple ;
        LocalDate aDate ;
        aMan = new Person( "A" , "Man", LocalDate.of( 1977, 1, 12) ) ;
        aWoman = new Person( "A" , "Woman", LocalDate.of( 1967, 10, 12)) ;
        aCouple = new Couple( aMan, aWoman ) ;
        aWedding = new Wedding( aCouple, LocalDate.now(), "Somewhere, SomeState") ;
        displayWedding( aWedding ) ;

        Wedding anotherWedding = new Wedding(
            new Couple(
                    new Person("Pinky","Mouse", LocalDate.now().minusYears(31).minusDays( 123 )),
                    new Person("Pippie","Longstocking", LocalDate.now().minusDays(64*365))
            ),
            LocalDate.now().plusDays( 180 ), "The South Seas" ) ;
        displayWedding( anotherWedding ) ;

    }
    public static void displayWedding( Wedding theWedding )
    {
        Person man = theWedding.getTheMarriage().getMan() ;
        Person woman = theWedding.getTheMarriage().getWoman() ;
        LocalDate date = theWedding.getTheWeddingDate() ;
        System.out.println(  woman.getFirstName() + " " + woman.getLastName() + " and " +
                man.getFirstName() + " " + man.getLastName() + " to be wed " +
                date.getDayOfWeek() + " " + date.getMonth().name() + " " + date.getDayOfMonth() +
                " in " + theWedding.getTheLocation()) ;

        System.out.print( man.getFirstName() + " was born " + man.getDateOfBirth()) ;
        System.out.print("\t\t") ;
        System.out.println( woman.getFirstName() + " was born " + woman.getDateOfBirth()) ;
    }
}
