package exercises.chapter03;

import java.util.Scanner;

/*
6.  To encourage good grades, Hermosa High School has decided to award each
        student a bookstore credit that is 10 times the student's grade point average. In
        other words, a student with a 3.2.grade point average receives a $32 credit. Create
        a class that prompts a student for a name and a graade point average, and then
        passes the values to a method that displays a descriptive message. The message
        uses the student's name, echos the grade point average, and computes and
        displays the credit. Save the application as BookstoreCredit.java.
*/
public class BookstoreCredit
{
    public static void main( String[] args )
    {
        String name = "" ;
        double gpa = 0.0 ;
        //double credit = 0.0 ;
        Scanner kb = new Scanner( System.in ) ;
        name = getUserName("Enter name>") ;
        gpa = getUserGpa("Enger GPA>" ) ;
        showCredit( name, gpa ) ;
    }
    public static void showCredit( String name, double gpa )
    {
        double credit = gpa * 10 ;
        System.out.println( "Student name: " + name ) ;
        System.out.println( "Student GPA: " + gpa ) ;
        System.out.println( "Student credit: " + credit ) ;
    }
    public static String getUserName( String prompt )
    {
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        return kb.nextLine() ;
    }
    public static double getUserGpa( String prompt )
    {
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        return kb.nextDouble() ;
    }
}
