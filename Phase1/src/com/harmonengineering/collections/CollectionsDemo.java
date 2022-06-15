package com.harmonengineering.collections;

import java.util.*;
import java.lang.* ;

class CIterableDemo
{
    Collection m_collection ;
    public void doIterableDemo()
    {
        System.out.println("") ;
        System.out.println( "----- Iterable Demo ------" ) ;
        Iterator i = m_collection.iterator() ;
        while ( i.hasNext() )
            System.out.println("value -> " + i.next());

    }
    void SetImplementation( Collection c )
    {
        m_collection = c ;
    }
}
abstract class CCollectionDemo extends CIterableDemo
{
    abstract public void doDemo() ;
    public void doCollectionDemo()
    {
        // Object savearray[] = m_collection.toArray() ;
        ArrayList savearray = new ArrayList() ;
        savearray.addAll( m_collection ) ;

        System.out.println( "---- Collection interface Demo ----" ) ;
        System.out.println( "Adding - 'New element 1'" ) ;
        System.out.println( "Adding - 5150 " ) ;

        m_collection.add( "New element 1" ) ;
        m_collection.add( "5150" ) ;
        DisplayCollection() ;
        System.out.println( "Contains 'New element 1': " + ( m_collection.contains( "New element 1" ) ? "True" : "False" )) ;
        System.out.println( "Contains '5150': " + ( m_collection.contains( 5150 ) ? "True" : "False" )) ;

        System.out.println( "Removing - 'New element 1'") ;
        m_collection.remove( "New element 1" ) ;

        DisplayCollection() ;
        System.out.println( "Contains 'New element 1': " + ( m_collection.contains( "New element 1" ) ? "True" : "False" )) ;
        System.out.println( "Contains '5150': " + ( m_collection.contains( 5150 ) ? "True" : "False" )) ;

        m_collection.retainAll( savearray ) ;
        DisplayCollection() ;
        System.out.println( "Contains 'New element 1': " + ( m_collection.contains( "New element 1" ) ? "True" : "False" )) ;
        System.out.println( "Contains '5150': " + ( m_collection.contains( 5150 ) ? "True" : "False" )) ;
    }
    void DisplayCollection()
    {
        // doIterableDemo() ; // uses the iterator to display all contents
        System.out.println( "Collection contents: " + m_collection ) ;
        System.out.println("Collection haschode: " + m_collection.hashCode());
        System.out.println("Collection is empty: " + (m_collection.isEmpty() ? "True" : "False"));
        System.out.println("Collection size: " + m_collection.size());

    }
}
abstract  class CListDemo extends CCollectionDemo
{
    List m_list ;
    public void doListDemo()
    {
        m_list = (List)m_collection ;

        m_collection.add( "Brian Harmon" ) ;
        m_collection.add( 1235 ) ;
        m_collection.add( 'B' ) ;
        m_collection.add( true ) ;

        doIterableDemo();
        doCollectionDemo() ;

        System.out.println( "----- List interface Demo -----" ) ;
        System.out.println( "Index of object valued '1235': " + m_list.indexOf(1235)) ;
        System.out.println( "Last index of object valued 'Brian Harmon': " + m_list.lastIndexOf("Brian Harmon") );
        m_list.add( 3, "Julias Caesar" ) ;

        Iterator i = m_list.listIterator() ;
        while ( i.hasNext() )
            System.out.println("value -> " + i.next());

        System.out.println( "Setting value at index 3 -> 'Johnny'") ;
        m_list.set( 3, "Johnny" ) ;
        System.out.println( "value at index 3 -> " + m_list.get( 3 ) ) ;
        //m_list.removeRange( 2, 4 ) ;
        System.out.println( "List contents: " + m_list ) ;
        System.out.println( "Removing index 3" ) ;
        m_list.remove( 3 ) ;
        System.out.println( "List contents: " + m_list ) ;
        System.out.println( "Adding value 'Brian Harmon' at index 3" ) ;
        m_list.add( 3, "Brian Harmon" ) ;
        System.out.println( "List contents: " + m_list ) ;
        System.out.println( "Last index of object valued 'Brian Harmon': " + m_list.lastIndexOf("Brian Harmon") );

        //sort(Comparator<? super E> c)
        //addAll(int index, Collection<? extends E> c)
        //replaceAll(UnaryOperator<E> operator)

        DisplayCollection() ;
    }
}
class CArrayListDemo extends CListDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< ARRAYLIST DEMO >>========") ;
        ArrayList arraylist = new ArrayList() ;
        SetImplementation( arraylist ) ;

        doListDemo() ;
        System.out.println( "arraylist contents: " + arraylist ) ;
        ArrayList arraylistclone = (ArrayList)arraylist.clone() ;
        List arraylistsub = arraylist.subList(1, 3) ;
            
        System.out.println( "Cloned arraylist contents: " + arraylistclone ) ;
        System.out.println( "SubList arraylistsub(1,3) contents: " + arraylistsub ) ;
        //ensureCapacity(int minCapacity)
        //trimToSize()
    }
}
class ClinkedListDemo extends CListDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< LINKEDLIST DEMO >>========") ;
        LinkedList linkedlist = new LinkedList() ;
        SetImplementation( linkedlist ) ;
        doListDemo() ;

        // Linked list special interface
        /*
        add(int index, E element)
        add(E e)
        addFirst(E e)
        addLast(E e)
        element()
        get(int index)
        getFirst()
        getLast()
        offer(E e)
        offerFirst(E e)
        offerLast(E e)
        peek()
        peekFirst()
        peekLast()
        poll()
        pollFirst()
        pollLast()
        pop()
        push(E e)
        removeFirst()
        removeLast()
        */
    }
}
class CVectorDemo extends CListDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< VECTOR DEMO >>========") ;
        Vector vector = new Vector() ;
        SetImplementation( vector ) ;
        doListDemo() ;
    }
}
class CStackDemo extends CListDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< STACK DEMO >>========") ;
        Stack stack = new Stack() ;
        SetImplementation( stack )  ;
        doListDemo() ;
/*
        push()
        pop()
        peek()
        empty()
        search()
 */
    }
}

abstract class CQueueDemo extends CCollectionDemo
{
    Queue   m_queue ;
    public void doQueueDemo()
    {
        m_queue = (Queue) m_collection ;

        m_collection.add( "Brian Harmon" ) ;
        m_collection.add( "1235" )  ;
        m_collection.add( "B" ) ;
        m_collection.add( "true" ) ;

        doIterableDemo() ;
        doCollectionDemo() ;
        System.out.println( "----- Queue interface demo -----" ) ;

        System.out.println( "Element(peek): " + m_queue.element() ) ;
        System.out.println( "Adding 2 elements" ) ;
        m_queue.add( "Element1" ) ;
        m_queue.add( "Element2" ) ;
        System.out.println( "Element(peek): " + m_queue.element() ) ;
        System.out.println( "Queue contents: " + m_queue ) ;
        System.out.println( "Remove: " + m_queue.remove() ) ;
        System.out.println( "Element(peek): " + m_queue.element() ) ;
        System.out.println( "Remove: " + m_queue.remove() ) ;


        System.out.println( "Element(peek): " + m_queue.peek() ) ;
        System.out.println( "Adding 2 elements" ) ;
        m_queue.offer( "Element1" ) ;
        m_queue.offer( "Element2" ) ;
        System.out.println( "Element(peek): " + m_queue.peek() ) ;
        System.out.println( "Queue contents: " + m_queue ) ;
        System.out.println( "Remove: " + m_queue.poll() ) ;
        System.out.println( "Element(peek): " + m_queue.peek() ) ;
        System.out.println( "Remove: " + m_queue.poll() ) ;

    }
}
class CPriorityQueueDemo extends CQueueDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< PRIORITY QUEUE DEMO >>========") ;
        PriorityQueue priorityQueue = new PriorityQueue() ;
        SetImplementation( priorityQueue ) ;

        doQueueDemo() ;
/*
        offer()
        peek()
        poll()
        size()
*/
    }
}
abstract class CDequeDemo extends CQueueDemo
{
    Deque m_deque ;
    public void doDequeDemo()
    {
        m_deque = (Deque) m_collection ;
        doQueueDemo() ;
        System.out.println( "----- Deque interface demo -----" ) ;

        /*
        addFirst(e)
        offerFirst(e)
        addLast(e)
        offerLast(e)
        removeFirst()
        pollFirst()
        removeLast()
        pollLast()
        getFirst()
        peekFirst()
        getLast()
        peekLast()
         */
    }

}
class CArrayDequeDemo extends CDequeDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< ARRAY DEQUE DEMO >>========") ;
        ArrayDeque arrayDeque = new ArrayDeque() ;
        SetImplementation( arrayDeque ) ;

        doDequeDemo() ;
    }
}

abstract class CSetDemo extends CCollectionDemo
{
    Set m_set ;
    public void doSetDemo()
    {
        m_set = (Set)m_collection ;

        m_set.add( "Brian Harmon" ) ;
        m_set.add( "1235" )  ;
        m_set.add( "B" ) ;
        m_set.add( "true" ) ;

        doIterableDemo();
        doCollectionDemo() ;
        System.out.println( "----- Set interface demo -----" ) ;
    }
}
abstract class CSortedSetDemo extends CSetDemo
{
    SortedSet m_sortedset ;
    public void doSortedSetDemo()
    {
        m_sortedset = (SortedSet) m_collection ;

        m_sortedset.add( "Brian Harmon" ) ;
        m_sortedset.add( "1235" )  ;
        m_sortedset.add( "B" ) ;
        m_sortedset.add( "true" ) ;

        //doSetDemo() ;
        doIterableDemo() ;
        //doCollectionDemo() ;

        System.out.println("----- Set interface demo -----") ;
        System.out.println( "First element: " + m_sortedset.first()) ;
        System.out.println( "Last element: " + m_sortedset.last()) ;

        Object[] array = m_sortedset.toArray() ;
        System.out.println( "First Two: " + m_sortedset.headSet( array[2] )) ;
        System.out.println( "Middle Two: " +
                m_sortedset.subSet( array[ (array.length/2)-1],
                                    array[ (array.length/2)+1 ] )) ;
        System.out.println( "Last Two: " + m_sortedset.tailSet( array[array.length-2] )) ;
    }
}
class CHashSetDemo extends CSetDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< HASH SET DEMO >>========") ;
        HashSet hashSet = new HashSet() ;
        SetImplementation( hashSet ) ;
        doSetDemo() ;
    }
}
class CLinkedHashSetDemo extends CSetDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< LINKED HASH SET DEMO >>========") ;
        LinkedHashSet linkedHashSet = new LinkedHashSet() ;
        SetImplementation( linkedHashSet ) ;
        doSetDemo() ;
    }
}
class CTreeSetDemo extends CSortedSetDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< TREESET DEMO >>========") ;
        TreeSet treeSet = new TreeSet() ;
        SetImplementation( treeSet ) ;
        doSortedSetDemo() ;
    }
}
abstract class CAbstractMapDemo
{
    Map m_map ;
    public void SetImplementation( Map c )
    {
        m_map = c ;
    }
    public void doAbstractMapDemo()
    {
        m_map.put( "100", "Brian Harmon" ) ;
        m_map.put( "200" , "1235" ) ;
        m_map.put( "300" , "Leonardo" ) ;
        m_map.put( "400" , "Constantine" ) ;
        m_map.put( "500",  "B" ) ;
        m_map.put( "600", "true" ) ;

        Collection collection ;
        collection =  m_map.values()  ;
        System.out.println( "Value collection contents: " + collection ) ;
        collection = m_map.keySet() ;
        System.out.println( "Key value collection contents: " + collection ) ;
    }
}
class CHashtableDemo extends CAbstractMapDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< HASHTABLE DEMO >>========") ;
        Hashtable hashTable = new Hashtable();
        SetImplementation(hashTable);
        doAbstractMapDemo();
    }
}
class CLinkedHashMapDemo extends CAbstractMapDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< LINKEDHASHMAP DEMO >>========") ;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SetImplementation( linkedHashMap ) ;
        doAbstractMapDemo() ;
    }
}
class CHashMapDemo extends CAbstractMapDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< HASHMAP DEMO >>========") ;
        HashMap hashMap = new HashMap();
        SetImplementation( hashMap ) ;
        doAbstractMapDemo();
    }
}

abstract class CSortedMapDemo extends CAbstractMapDemo
{
    SortedMap m_sortedmap ;
    public void doSortedMapDemo()
    {
        m_sortedmap = (SortedMap) m_map ;
        m_sortedmap.put( "100", "Brian Harmon" ) ;
        m_sortedmap.put( "200" , "1235" ) ;
        m_sortedmap.put( "300" , "Leonardo" ) ;
        m_sortedmap.put( "400" , "Constantine" ) ;
        m_sortedmap.put( "500",  "B" ) ;
        m_sortedmap.put( "600", "true" ) ;

        System.out.println( "Entry set: " + m_sortedmap.entrySet()) ;
        System.out.println( "Key set: " + m_sortedmap.keySet() ) ;
        System.out.println( "Value collection contents: " + m_sortedmap.values() ) ;
        System.out.println( "First key: " + m_sortedmap.firstKey() +
                " value -> " + m_sortedmap.get( m_sortedmap.firstKey())) ;
        System.out.println( "Last key: " + m_sortedmap.lastKey() +
                " value -> " + m_sortedmap.get( m_sortedmap.lastKey())) ;
    }
}

class CTreeMapDemo extends CSortedMapDemo
{
    public void doDemo()
    {
        System.out.println( "=========<< TREEMAP DEMO >>========") ;
        TreeMap treeMap = new TreeMap() ;
        SetImplementation(treeMap);
        doSortedMapDemo();
    }
}

public class CollectionsDemo
{
    public static void main( String[] args )
    {
        CArrayListDemo arraylistDemo = new CArrayListDemo();
        ClinkedListDemo linkedlistDemo = new ClinkedListDemo() ;
        CVectorDemo vectorDemo = new CVectorDemo() ;
        CStackDemo stackDemo = new CStackDemo() ;
        CPriorityQueueDemo priorityQueueDemo = new CPriorityQueueDemo() ;
        CArrayDequeDemo arrayDequeDemo = new CArrayDequeDemo() ;
        CHashSetDemo hashSetDemo = new CHashSetDemo() ;
        CLinkedHashSetDemo linkedHashSetDemo = new CLinkedHashSetDemo() ;
        CTreeSetDemo treeSetDemo = new CTreeSetDemo() ;

        CHashtableDemo hashtableDemo = new CHashtableDemo() ;
        CLinkedHashMapDemo linkedHashMapDemo = new CLinkedHashMapDemo() ;
        CHashMapDemo hashMapDemo = new CHashMapDemo() ;
        CTreeMapDemo treeMapDemo = new CTreeMapDemo() ;

        System.out.println( "Hello. !!! JBomb! " ) ;

        arraylistDemo.doDemo() ;
        linkedlistDemo.doDemo() ;
        vectorDemo.doDemo() ;
        stackDemo.doDemo() ;
        priorityQueueDemo.doDemo() ;
        arrayDequeDemo.doDemo() ;
        hashSetDemo.doDemo() ;
        linkedHashSetDemo.doDemo() ;
        treeSetDemo.doDemo() ;

        hashtableDemo.doDemo() ;
        linkedHashMapDemo.doDemo() ;
        hashMapDemo.doDemo() ;
        treeMapDemo.doDemo() ;
    }
}