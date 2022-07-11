package YouDoIt.chapter04;
// Java Programming, by Joyce Farrell - Chapter 4 - You Do It p. 189
public class CarInsurancePolicy
{
    private int policyNumber ;
    private int numPayments ;
    private String residentCity ;

    public CarInsurancePolicy( int num, int payments, String city)
    {
        policyNumber = num ;
        numPayments = payments ;
        residentCity = city ;
    }
    public CarInsurancePolicy( int num, int payments )
    {
        policyNumber = num ;
        numPayments = payments ;
        residentCity = "Mayfield" ;
    }
    public CarInsurancePolicy( int num )
    {
        policyNumber = num ;
        numPayments = 2 ;
        residentCity = "Mayfield" ;
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