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

public class Student
{
    private int  student_id ;
    private int  credit_hours ;
    private int  credit_points ;
    private double  grade_point_average ;

    public Student()
    {
        student_id = 9999 ;
        credit_hours = 3 ;
        credit_points = 12 ;
        gpa() ;
    }
    public double gpa()
    {
        grade_point_average = credit_points / (double)credit_hours ;
        return grade_point_average ;
    }
    public void setStudent_id(int student_id) { this.student_id = student_id; }
    public void setCredit_hours(int credit_hours) { this.credit_hours = credit_hours; }
    public void setCredit_points(int credit_points) { this.credit_points = credit_points; }

    public int getStudent_id() { return student_id; }
    public int getCredit_hours() { return credit_hours; }
    public int getCredit_points() { return credit_points; }

    public void printStudent_id() { System.out.print( student_id ) ; }
    public void printCredit_hours() { System.out.print( credit_hours ) ; }
    public void printCredit_points() { System.out.print( credit_points ) ; }
    public void printGPA() { System.out.print( grade_point_average ) ; }
}
