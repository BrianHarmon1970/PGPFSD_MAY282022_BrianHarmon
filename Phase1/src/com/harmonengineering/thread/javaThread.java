package com.harmonengineering.thread ;

import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

class global
{
    public static final int g_nQueueSize = 10_0000 ;
}

class JThread extends Thread
{
    static ReentrantLock m_bLock = new ReentrantLock() ;
    public void run()
    {
        System.out.println( "Starting thread: " + this.getName() ) ;
        try {
            for ( int i = 0 ; i < global.g_nQueueSize ; ++i ) ;
            Thread.sleep( 1000 ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Exiting thread: " + this.getName() ) ;
    }
    public void exit()
    {
        System.out.println( this.getName() + " Exit." ) ;
    }
}
class JThreadQueue
{
    PriorityQueue<Long> m_queue ;
    ReentrantLock m_bLock ;
    int m_nElementsOffered ;
    int m_nElementsPolled ;
    int m_nSize ;
    JThreadQueue(  )
    {
        m_bLock = new ReentrantLock() ;
        m_bLock.lock() ;
        m_queue = new PriorityQueue<Long>( global.g_nQueueSize );

        m_nElementsOffered = 0 ;
        m_nElementsPolled = 0 ;
        m_nSize = 0 ;
        m_bLock.unlock();
    }
    public boolean offer( int e )
    {
        boolean return_value ;
        m_bLock.lock() ;
        return_value = m_queue.offer( (long) e ) ;
        ++m_nElementsOffered ;
        m_nSize = m_queue.size() ;
        m_bLock.unlock() ;
        return return_value ;
    }
    // same as offer only does not lock the queue
    public boolean Offer( int e )
    {
        boolean return_value ;
        //m_bLock.lock() ;
        return_value = m_queue.offer( (long) e ) ;
        ++m_nElementsOffered ;
        m_nSize = m_queue.size() ;
        //m_bLock.unlock() ;
        return return_value ;
    }
    public Long poll()
    {
        Long return_value ;
        m_bLock.lock();
        return_value = m_queue.poll();
        ++m_nElementsPolled ;
        m_nSize = m_queue.size() ;
        m_bLock.unlock() ;
        return return_value ;
    }
    public int size()
    {
        return m_nSize ;
        /*int return_value ;
        m_bLock.lock() ;
        return_value = m_queue.size() ;
        m_bLock.unlock() ;
        return return_value ;       */
    }

    public int polledCount() { return m_nElementsPolled ; }
    public int offeredCount() { return m_nElementsOffered ; }
    public void lock() { m_bLock.lock() ; }
    public void unlock() { m_bLock.unlock() ; }
}
class JThreadProducer extends JThread
{
    JThreadQueue m_PriorityQueue ;
    JThreadProducer( JThreadQueue pq )
    {
        m_PriorityQueue = pq ;
    }
    public void run()
    {
        // high level granular time bracket to allow the queue to be fully loaded
        // before allowing consumer access to the queue ( if they reach zero they terminate )
        // the queue is locked for the duration of the loading loop
        // this is a little redundant as the per call offer(insertions) are bracketed as well.
        // so on review it seems there is a small opening for a thread to race in as the offer
        // unlocks the queue before being called again ( and so re-locking the queue again )
        // providing an alternative method to insert without locking - leaving this to the higher
        /// level bracket in this case - Offer( element ) - the original offer( element ) will be
        // unchanged providing the lower per call granularity time slice on the queue insert
        m_PriorityQueue.lock() ;
        for (int i = 0; i < global.g_nQueueSize ; ++i )
        {
             m_PriorityQueue.Offer( i ) ;
        }
        m_PriorityQueue.unlock() ;
    }
}
class JThreadConsumer extends JThread
{
    static ReentrantLock m_consoleMutex ;
    JThreadQueue  m_PriorityQueue ;
    StringBuilder m_StringBuilder ;

    JThreadConsumer( JThreadQueue pq )
    {
        m_PriorityQueue = pq ;
        m_consoleMutex = new ReentrantLock( ) ;
    }
    public void run()
    {
        //m_bLock.lock();
        int i  = 0 ;
        int size = 1 ;
        //m_bLock.unlock();

        //StringBuilder stringBuilder = new StringBuilder() ;


        while ( (size = m_PriorityQueue.size()) > 0  )
        {
            i = m_PriorityQueue.poll().intValue() ;


            //System.out.println("Thread: " + this.getName() + " Payload: " + i);

            m_StringBuilder = new StringBuilder( "" ) ;
            m_StringBuilder.append(  this.getName() + " >>") ;
            m_StringBuilder.append( i ) ;
            m_StringBuilder.append( " QSize: " + m_PriorityQueue.size() ) ;
            m_StringBuilder.append( " offered: " + m_PriorityQueue.offeredCount() ) ;
            m_StringBuilder.append( " Polled: " + m_PriorityQueue.polledCount() ) ;

            m_consoleMutex.lock() ;
            System.out.print( "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" ) ;
            System.out.print( "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" ) ;
            System.out.print( "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" ) ;
            System.out.print( m_StringBuilder.toString() ) ;
            System.out.flush() ;

            // for dixsplay stability - small delay while no updates to console
            try { Thread.sleep(0, 10); } catch (InterruptedException e) { e.printStackTrace(); }
            m_consoleMutex.unlock() ;
        }
    }
}
public class javaThread
{
    public static void main( String[] args )
    {
        JThreadQueue q = new JThreadQueue() ;
        System.out.print( "\033[0;97m" ) ;
        //System.out.print( "\033[44m" ) ;
        JThreadProducer source = new JThreadProducer( q )  ;
        source.start() ;
        for ( int i = 0 ; i < 10 ; ++i )
        {
            JThreadConsumer t = new JThreadConsumer( q ) ;
            t.start() ;
        }
    }
}
