package exercises.chapter03;
/*

11. a.  Create a class named Sandwich. Data fields include a String for the main
        ingredient(such as tuna), a String for bread type(such as wheat), and a
        double for price(such as 4.99). Include methods to get and set values for
        each of these fields. Save the class as Sandwich.java.

    b.  Create an application named TestSandwich that instantiates one Sandwich
        object and demonstrates the use of the set and get methods. Save this
        application as TestSandwich.java.

 */
public class TestSandwich
{
    public static void main( String[] args )
    {
        Sandwich oneSandwich = new Sandwich() ;

        oneSandwich.setKind( "Tuna" ) ;
        oneSandwich.setBread( "Italian" ) ;
        oneSandwich.setPrice( 4.99 ) ;

        System.out.println( "One Sandwich" ) ;
        System.out.println( "===============================" ) ;
        System.out.println( "Type:      \t\t" + oneSandwich.getKind() ) ;
        System.out.println( "Bread Type:\t\t" + oneSandwich.getBread() ) ;
        System.out.println( "Price:     \t\t" + oneSandwich.getPrice() ) ;
    }
}