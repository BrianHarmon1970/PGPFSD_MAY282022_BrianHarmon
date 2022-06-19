package com.harmonengineering.oop;
class Person
{
    void eat()
    {
        System.out.println( "Person eating." ) ;
    }
    void sleep()
    {
        System.out.println( "Person sleeping." ) ;
    }
    void work()
    {
        System.out.println( "Person working." ) ;
    }
    void doAll()
    {
        eat() ;
        sleep() ;
        work()  ;
    }
}
class Employee extends Person
{
    void work()
    {
        System.out.println( "Employee working." ) ;


    }
    void eat()
    {
        System.out.println( "Employee eating." ) ;
    }

}
class Student extends Person
{
    void sleep()
    {
        System.out.println( "Student sleeping." ) ;
    }
}
class Teacher extends Person
{
    void eat()
    {
        System.out.println( "Teacher eating." ) ;
    }
    void sleep()
    {
        System.out.println( "Teacher sleeping." ) ;
    }
    void work()
    {
        System.out.println( "Teacher working." ) ;
    }

}
class OtherPerson extends  Person
{
    void work()
    {
        System.out.println( "Other person working." ) ;
    }
}
public class Polymorphism {
    public static void main( String[] args )
    {
        Teacher teacher = new Teacher() ;
        Student student = new Student() ;
        Employee employee = new Employee() ;
        OtherPerson other = new OtherPerson() ;

        System.out.println( "\nTeacher" ) ;
        teacher.doAll();

        System.out.println( "\nStudent" ) ;
        ((Person)student).doAll() ;

        System.out.println( "\nEmployee" ) ;
        employee.doAll();

        System.out.println( "\nOther" ) ;
        other.doAll() ;


    }
}
