package com.harmonengineering.thread;

class AssignmentThread extends Thread
{
    public void run()
    {
        for ( int i = 0 ; i < 3 ; ++i )
        {
            try {
                sleep(4000);
                printstats( i );
            }
            catch( InterruptedException e )
            {
                System.out.println( "Interruped Exception: " + e.getMessage()) ;
            }
        }

    }
    synchronized void printstats( int run_number )
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "Run number: " + run_number + "\t" ) ;
        sb.append( currentThread().getName()  ) ;
        sb.append( " \t\tThread sate: " + currentThread().getState() ) ;
        sb.append( " \t\tThread priority: " + currentThread().getPriority()) ;
        sb.append( " \t\tAlive: " + currentThread().isAlive()) ;
        sb.append( " \t\tDaemon: " + currentThread().isDaemon() ) ;
        System.out.println( sb.toString() )  ;

    }
}
public class ClassThreadAssignment
{
    public static void main ( String[] args )
    {
        AssignmentThread T1 = new AssignmentThread() ;
        T1.setName( "Thread One   " ) ;
        T1.setPriority( Thread.MAX_PRIORITY ) ;

        AssignmentThread T2 = new AssignmentThread() ;
        T2.setName( "Thread Two   " ) ;
        T2.setPriority( Thread.NORM_PRIORITY ) ;

        AssignmentThread T3 = new AssignmentThread() ;
        T3.setName( "Thread Three" ) ;
        T3.setPriority( Thread.NORM_PRIORITY ) ;

        T1.start() ; T2.start() ; T3.start() ;


    }
}
