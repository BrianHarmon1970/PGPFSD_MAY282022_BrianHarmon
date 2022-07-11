package exercises.chapter04;
/*

1.  Create a class named FormLetterWriter that includes two overloaded methods
    named displaySalutation(). The first method takes one String parameter that
    represents a customer's last  name, and it displays the salutation Dear Mr. or Ms.
    followed by the last name. The second method accepts two String parameters
    that represent a first and last name, and it displays the greeting Dear followed by
    the first name, a space, and the last name. After each salutation, display the rest of
    a short business letter: Thank you for your recent order. Write a main() method
    that test each overloaded method. Save the file as FormLetterWriter.java.

 */
public class FormLetterWriter
{
    public static void main( String[] args )
    {
        System.out.println("-------------------") ;
        displaySalutation( "Washington" ) ;
        displayLetterBody();
        System.out.println("-------------------") ;
        displaySalutation( "Nikoli", "Tesla" ) ;
        displayLetterBody();
        System.out.println("-------------------") ;

    }
    public static void displaySalutation( String lastname )
    {
        System.out.println( "Dear Mr. or Mrs. " + lastname + ",") ;
    }
    public static void displaySalutation( String firstname, String lastname )
    {
        System.out.println( "Dear " + firstname + " " + lastname + "," ) ;
    }
    public static void displayLetterBody()
    {
        System.out.println("") ;
        System.out.println("Thank you for your recent order." ) ;
        System.out.println("") ;
    }
}
