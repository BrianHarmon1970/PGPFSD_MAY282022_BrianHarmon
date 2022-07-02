package com.harmonengineering.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
Assignment 3:
Use LinkedList only in the below program
   - Add 6 months (May, June, July, August, April, November)
   - Add 'December' month as last
   - Add 'January' month as first
   - Add 'March' and then add 'Febuary' using the index based
   - Add 'September' and then add 'October' using the index based
(1) Print the linkedlist in such a way that proper order of months are displayed
(2) Get all the even months and print them
(3) Get all the odd months and print them
(4) Use iterator to fetch and print all months
(5) Print the first and last month of the year together
(6) remove your birthday month from the linkedList and print it
(7) Check whether this linkedList contains any winter month inside it or not?
(8) Fetch the first and last months using peek()
(9) Remove the first and last months using poll()
 */
public class ListAssignment {
    public static void main(String[] args) {
        AssignmentThree();
        AssignmentFour();
    }

    public static void AssignmentThree()
    {
        System.out.println( "\n== Assignment Three ==\n" );
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("May");
        ll.add("June");
        ll.add("July");
        ll.add("August");
        ll.add("April");
        ll.add("November");

        ll.addFirst("January");
        ll.addLast("December");

        ll.add(1, "March");
        ll.add(1, "February");
        ll.add(8, "September");
        ll.add(9, "October");

        System.out.println("LinkedList contents: " + ll);
        System.out.print("[ " + ll.get(0) + ", ");
        System.out.print(ll.get(1) + ", ");
        System.out.print(ll.get(2) + ", ");
        System.out.print(ll.get(7) + ", ");
        System.out.print(ll.get(3) + ", ");
        System.out.print(ll.get(4) + ", ");
        System.out.print(ll.get(5) + ", ");
        System.out.print(ll.get(6) + ", ");

        System.out.print(ll.get(8) + ", ");
        System.out.print(ll.get(9) + ", ");
        System.out.print(ll.get(10) + ", ");
        System.out.print(ll.get(11) + " ]");
        System.out.println();
        //System.out.print( ll.get( 0 ) ) ;
        int i;
        System.out.println("\nEven Months: ");
        for (i = 1; i <= 12; ++i) {
            if ((i % 2) == 0)
                System.out.print(ll.get(i - 1) + " ");
        }
        System.out.println("\nOdd Months: ");
        for (i = 1; i <= 12; ++i) {
            if ((i % 2) == 1)
                System.out.print(ll.get(i - 1) + " ");
        }
        System.out.println("\nIterated Contents: ");
        Iterator it = ll.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("First: " + ll.getFirst() + " " + "Last: " + ll.getLast());
        ll.remove("November");
        System.out.println("Contents: " + ll);

        LinkedList<String> winter = new LinkedList<String>() ;
        System.out.println( " =Winter Months= " ) ;
        winter.add( "October" )  ;
        winter.add( "November" ) ;
        winter.add( "December" ) ;
        winter.add( "January" ) ;
        winter.add( "February" ) ;
        winter.add( "March" ) ;

        ListIn( ll , winter ) ;
    }

    public static void ListIn( LinkedList dataset, LinkedList compset )
    {
        Iterator id = dataset.iterator() ;
        Iterator ic = compset.iterator() ;
        while( id.hasNext() ) {
            Object o = id.next();
            ic = compset.iterator() ;
            while (ic.hasNext()) {

                if (o.equals(ic.next()))
                    System.out.println(" " + o + " ");
            }
        }
    }
    public static void AssignmentFour()
    {
        System.out.println( "\n== Assignment Four ==\n" );
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer,  String>() ;
        lhm.put( 1001, "Apple" ) ;
        lhm.put( 2002, "Banana" ) ;
        lhm.put( 3003, "Kiwi" ) ;
        lhm.put( 4004, "Strawberry" ) ;
        lhm.put( 1010, "Grape" ) ;
        lhm.put( 9009, "Lemon" ) ;
        lhm.put( 8008, "Mango" ) ;
        lhm.put( 7777, "Coconut" ) ;
        lhm.put( 0110, "Raspberry" ) ;
        lhm.put( 5005, "Cherry" ) ;
        System.out.println( lhm ) ;

        Iterator i = lhm.keySet().iterator();

        System.out.println( " Key set: " + lhm.keySet() ); ;
        System.out.println( " Values: " + lhm.values() ) ;

        System.out.println( " Contains Banana: " + ( lhm.containsValue("Banana"))) ;
        System.out.println( " Contains Apple: " + ( lhm.containsValue("Apple"))) ;

        lhm.remove( 4004, "Strawberry" ) ;
        lhm.remove( 8008 ) ;
        System.out.println( lhm ) ;
        System.out.println( "HashCode: " + lhm.hashCode() ) ;
        lhm.clear() ;
        System.out.println( lhm ) ;

    }
}
