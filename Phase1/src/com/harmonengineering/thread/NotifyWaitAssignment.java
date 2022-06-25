package com.harmonengineering.thread;

class Customer
{
    Double AccountValue = 10000.00 ;
    synchronized public void Withdraw( Double amount )
    {
        if ( amount > AccountValue )
        {
            System.out.println( "Amouunt: " + amount + " Current Balance: " + AccountValue +
                    "  Insufficient funding, waiting for deposit." ) ;
            try
            {
                wait() ;
                Withdraw( amount ) ;
            }
            catch( Exception e ) {}
        }
        else {
            AccountValue -= amount ;
            System.out.println( "Withdraw amount: " + amount + " AccountValue: " + AccountValue ) ;
        }
    }
    synchronized public void Deposit( Double amount )
    {
        AccountValue += amount ;
        System.out.println( "Depost amount: " + amount + " AccountValue: " + AccountValue ) ;
        notify();
    }
}
public class NotifyWaitAssignment
{
    public static void main(  String[] args )
    {
        Customer c = new Customer() ;
        new Thread()
        {
            public void run()
            {
                c.Withdraw(5000.00) ;
            }
        }.start();

        new Thread()
        {
            public void run()
            {
                c.Withdraw(4000.00) ;
            }
        }.start();
        new Thread()
        {
            public void run()
            {
                c.Withdraw(10000.00) ;
            }
        }.start();

        try {
            Thread.sleep(100);
        } catch ( Exception e ) {}
        new Thread()
        {
            public void run()
            {
                c.Deposit(20000.00) ;
            }
        }.start();
    }
}
