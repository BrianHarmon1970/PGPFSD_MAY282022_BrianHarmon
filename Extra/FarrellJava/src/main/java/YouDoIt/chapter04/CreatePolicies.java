package YouDoIt.chapter04;
// Java Programming, by Joyce Farrell - Chapter 4 - You Do It p. 189
public class CreatePolicies
{
    public static void main( String[] args )
    {
        CarInusrancePolicy2 first = new CarInusrancePolicy2( 123 ) ;
        CarInusrancePolicy2 second = new CarInusrancePolicy2( 456, 4 ) ;
        CarInusrancePolicy2 third = new CarInusrancePolicy2( 789, 12, "Newcastle" ) ;

       // CarInsurancePolicy fourth = new CarInsurancePolicy(  ) ;

        CarInsurancePolicy.displayHeader();
        first.display();
        second.display();
        third.display();
    }
}
