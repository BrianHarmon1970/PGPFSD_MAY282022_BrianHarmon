package exercises.chapter03;

import java.util.Scanner;

/*
13. a.  Create a class named Lease with fields that hold an apartment tenant's name,
        apartment number, monthly rent amount, and term of the lease in months.
        Include a constructor that initializes the name to "XXX", the apartment
        number to 0, the rent to 1000, and the term to 12. Also include methods to
        get and set each of the fields. Include a nonstatic method named addPetFee()
        that adds $10 to the monthly rent value and calls a static method named
        explainPetPolicy() that explains the pet fee. Save the class as Lease.java.

    b.  Create a class named TestLease who's main() method declares four Lease
        objects. Call a getData() method three times. Within the method, prompt a
        user for values for each field for a Lease, and return aLease object to the main()
        method where it is assigned to one of main()'s Lease objects. Do not prompt the
        user for values for the fourth Lease object, but let it continue to hold the default
        values. Then in main(), pass one of the Lease objects to a showValues() method
        that displays the data. Then call the addPetFee() method using the passed Lease
        object and confirm that the fee explanation statement is displayed. Next, call the
        showValues method for the Lease object again and confirm that th pet fee has
        been added to the rent. Finally, call the showValues() method with each of the
        other three objects, confirm that two hold the values you supplied as input and
        one holds the constructor default values. Save the application as TestLease.java.
 */
public class TestLease
{
    public static void main( String[] args )
    {
        Lease l1  ;
        Lease l2  ;
        Lease l3  ;
        Lease l4  = new Lease() ;

        l1 = getData(  ) ;
        l2 = getData(  ) ;
        l3 = getData(  ) ;

        ShowValues( l1 ) ;
        l1.addPetFee();
        ShowValues( l1 ) ;
        ShowValues( l2 ) ;
        ShowValues( l3 ) ;
        ShowValues( l4 ) ;
    }
    public static void ShowValues( Lease l )
    {
        System.out.println("\n------------------------------");
        System.out.println( "Tenant Name: " + l.getTenantName() );
        System.out.println( "Apartment No.: " + l.getApartmentNumber() ) ;
        System.out.println( "Rent Amount: $" + l.getMonthlyRentAmount() ) ;
        System.out.println( "Lease Term: " + l.getLeaseTerm() ) ;
    }
    public static Lease getData( )
    {

        Lease l = new Lease() ;
        System.out.println("Enter values" ) ;
        l.setTenantName( getUserString( "Tenant Name> " )) ;
        l.setApartmentNumber( getUserNumber( "Apartment Number> " )) ;
        l.setMonthlyRentAmount( getUserRealNumber( "Monthly Rent Amount> " )) ;
        l.setLeaseTerm( getUserNumber( "Term> " )) ;
        return l ;
    }
    static String getUserString( String prompt )
    {
        String string  ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        string =  kb.nextLine() ;
        return string ;
    }
    static int getUserNumber( String prompt )
    {
        int number ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        number =  kb.nextInt() ;
        return number ;
    }
    static double getUserRealNumber( String prompt )
    {
        double number ;
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        number =  kb.nextDouble() ;
        return number ;
    }
}
