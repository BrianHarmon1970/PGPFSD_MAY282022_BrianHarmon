package exercises.chapter03;
/*

12. a.  Create a class named Student that has fields for an ID number, number
        of credit hours earned, and number of points earned. (For example,
        many schools compute grade point averages based on a scale of 4, so a
        three-credit-hour class in which a student earns an A is worth 12 points. )
        Include methods to assign values to all fields. A Student also has a field for
        grade point average. Include a method to compute the grade point average
        field by dividing points by credit hours earned. Write methods to display the
        values in each Student field. Save this class as Student.java

    b.  Write a class named  ShowStudent that instantiates a Student object from the
        class you created and assign values to its fields. Compute the Student grade
        point average., and then display all the values associated with the Student.
        Save the application as ShowStudent.java

    c.  Create a constructor for the Student class you created. The constructor should
        initialize each Student's ID number to 9999, his or her points earned to 12, and
        credit hours to 3(resulting in a grade point average of 4.0). Write a program
        that demonstrates that the constructor works by instantiating an object and
        displaying the initial values. Save the application as ShowStudent2.java.

 */

public class ShowStudent
{
    static Student student ;
    public static void main( String[] args )
    {
        student = new Student() ;
        student.setStudent_id( 123456 ) ;
        student.setCredit_hours( 12 ) ;
        student.setCredit_points( 40 ) ;
        student.gpa() ; // computes as well as returns gpa

        System.out.print( "\nStudent ID: " ) ; student.printStudent_id();
        System.out.print( "\nCredit Hours: " ) ; student.printCredit_hours();
        System.out.print( "\nCredit Points: " ) ; student.printCredit_points();
        System.out.print( "\nGPA: " ) ; student.printGPA();
        System.out.print("\n") ;
    }
}
