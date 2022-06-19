package com.harmonengineering.oop;

public class InnerClassEmployee
{
    int salary = 100000 ;
    class PermEmploy
    {
        String code = "PE01" ;
        Double hike = 0.45 ;

        void newSalary()
        {
            System.out.println( "new salary:" + salary * (1+hike)) ;
        }
        void display()
        {
            System.out.println( "salary: " + salary + "\ncode: " + code + "\nhike: " + hike );
        }
    }
    class TempEmployee
    {
        String code = "TE01" ;
        Double hike = 0.3 ;

        void newSalary()
        {
            System.out.println( "new salary:" + salary * (1+hike)) ;
        }

        void display()
        {
            System.out.println( "salary: " + salary + "\ncode: " + code + "\nhike: " + hike );
        }
    }
    void Role()
    {
        class ContractEmployee
        {
            String code = "CE01" ;
            Double hike = 0.3 ;

            void newSalary()
            {
                System.out.println( "new salary:" + salary * (1+hike)) ;
            }

            void display()
            {
                System.out.println( "salary: " + salary + "\ncode: " + code + "\nhike: " + hike );
            }
        }
        ContractEmployee ce = new ContractEmployee() ;
        ce.newSalary() ;
        ce.display() ;
    }
    void display()
    {
        PermEmploy pe = new PermEmploy() ;
        pe.newSalary();
        pe.display();

        TempEmployee te = new TempEmployee() ;
        te.newSalary();
        te.display();
    }
    public static void main( String[] args )
    {
        InnerClassEmployee e = new InnerClassEmployee() ;
        e.display() ;
        e.Role() ;
    }
}


