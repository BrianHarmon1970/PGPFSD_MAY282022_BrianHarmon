package com.harmonengineering.exceptions;

//You need to check the salary of the person and based on that need to return the output from the program.
//        if salary < 2100  then return custom exception message as "you need to work hard"
//        if salary is between 2100 and 5000 then return custom exception message as "your salary is somehow good"
//        if salary is between 5100 and 9000 then return custom exception message as "salary is very good"
//        Design the custom exception class in this and take salary from the user.

import java.util.Scanner;

class SalaryException extends Exception
{
    SalaryException( String message )
    {
        super(message) ;
    }
}
class SalaryExceptionLevel1 extends SalaryException
{
    SalaryExceptionLevel1(  )
    {
        super( "You need to work hard" ) ;
    }
}
class SalaryExceptionLevel2 extends SalaryException
{
    SalaryExceptionLevel2(  )
    {
        super( "Your salary is somehow good." ) ;
    }
}
class SalaryExceptionLevel3 extends SalaryException
{
    SalaryExceptionLevel3(  )
    {
        super( "Your salary is very good." ) ;
    }
}

public class SalaryCustomException
{
    public static void main( String[] args )
    {
        Double salary ;
        Scanner scanner = new Scanner( System.in ) ;
        while ( true ) {
            System.out.print("Enter Salary: ");
            salary = scanner.nextDouble();
            try {
                validateSalary(salary);
            } catch (SalaryException e) {
                System.out.println("Salary exception: " + e.getMessage());
            }
        }
    }
    static void validateSalary( Double salary ) throws SalaryException
    {
        //  validate( salary ) ;
        if ( salary < 2100.00 )
            throw new SalaryExceptionLevel1() ;
        if ( salary <= 5000 )
            throw new SalaryExceptionLevel2( ) ;
        if ( salary <= 9000 )
            throw new SalaryExceptionLevel3(  ) ;
    }

}
