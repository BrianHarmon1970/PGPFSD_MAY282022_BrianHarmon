package YouDoIt.chapter04;
// Java Programming, by Joyce Farrell - Chapter 4 - You Do It p. 198
public class CarInusrancePolicy2
{
    private int policyNumber ;
    private int numPayments ;
    private String residentCity ;

    public CarInusrancePolicy2( int num, int payments, String city)
    {
        policyNumber = num ;
        numPayments = payments ;
        residentCity = city ;
    }
    public CarInusrancePolicy2( int num, int payments )
    {
        this( num, payments, "Mayfield" ) ;
    }
    public CarInusrancePolicy2( int num )
    {
        this( num, 2 ) ;
    }
    public static void displayHeader(  )
    {
        System.out.println(( "Policy#"+"\t"+"Payments"+"\t" + "Driver's City"));
    }
    public void display()
    {

        System.out.print( "" + policyNumber ) ;
        System.out.print( "\t\t" + numPayments ) ;
        System.out.println(( "\t\t\t" + residentCity )) ;

        //System.out.print( "Polcy #: " + policyNumber ) ;
        //System.out.print( "\tAnnual payments: " + numPayments ) ;
        //System.out.println(( "\tDriver's city: " + residentCity )) ;
    }
}
