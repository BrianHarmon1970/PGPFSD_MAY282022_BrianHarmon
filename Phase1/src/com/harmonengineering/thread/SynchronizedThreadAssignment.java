package com.harmonengineering.thread;

import java.nio.channels.ScatteringByteChannel;

abstract class Process
{
    int result ;
    public abstract void doProcess() ;
    public int getResult() { return result ; }
}
abstract class binaryProcess extends  Process
{
    int binary_parameterA ;
    int binary_parameterB ;
    public void SetParameters( int A, int B  )
    {
        binary_parameterA = A ;
        binary_parameterB = B ;
    }
}
abstract class unaryProcess extends Process
{
    int unary_parameter ;
    public void SetParameter( int p )
    {
        unary_parameter = p ;
    }
}
class Factorial extends unaryProcess
{
    Factorial( int param )
    {
        SetParameter( param ) ;
    }
    public void doProcess()
    {
        result = factorial( unary_parameter ) ;
    }
    int factorial( int p )
    {
        if ( p > 1 )
             return  p * (factorial(p - 1)) ;
        else return 1 ;
    }
}
class Sum extends binaryProcess
{
    Sum( int paramA , int paramB )
    {
        SetParameters( paramA, paramB ) ;
    }
    public void doProcess()
    {
        result = binary_parameterA + binary_parameterB ;
    }
}
class ProcessThread extends Thread
{
    final static Boolean codesync = true ;
    Process process ;
    ProcessThread( Process p )
    {
        process = p ;
    }
    public void run()
    {
        synchronized ( ProcessThread.codesync )
        {
            process.doProcess();
            System.out.println(currentThread().getName() + " result: " + process.getResult());
        }
    }
}

public class SynchronizedThreadAssignment
{
    public static void main( String[] args )
    {
        ProcessThread p1 = new ProcessThread( new Factorial( 6 )) ;
        ProcessThread p2 = new ProcessThread( new Factorial( 10 )) ;
        ProcessThread p3 = new ProcessThread( new Sum( 4, 5 )) ;
        ProcessThread p4 = new ProcessThread( new Sum( 30, 20 )) ;

        p1.setName( "P1" ) ;
        p2.setName( "P2" ) ;
        p3.setName( "P3" ) ;
        p4.setName( "P4" ) ;

        try {
            p2.start();            Thread.sleep(100);
            p4.start();            Thread.sleep(100);
            p1.start();            Thread.sleep(100);
            p3.start();            Thread.sleep(100);
        }
        catch ( InterruptedException e )
        {
            System.out.println( "Interrupted: " + e.getMessage() ) ;
        }
    }
}
