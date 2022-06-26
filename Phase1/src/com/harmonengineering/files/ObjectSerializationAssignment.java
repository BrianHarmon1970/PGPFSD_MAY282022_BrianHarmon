package com.harmonengineering.files;

import java.io.*;

class Student implements Serializable {
    private String StudentName;
    private int RollNo;
    private int age;
    private String address;
    private int height;

    public Student(String sname, int sage, int sheight, int srollno, String saddress) {
        StudentName = sname;
        RollNo = srollno;
        age = sage;
        height = sheight;
        address = saddress;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return StudentName;
    }

    public int getRollNo() {
        return RollNo;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
}


public class ObjectSerializationAssignment
{
    static Student student ;
    public static void main( String[] args )
    {
        student = new Student( "Brian", 130, 6, 5150, "My Address" ) ;
        try
        {
            Serialize( );
            Deserialize();

            System.out.println( "Student Name: " + student.getName());
            System.out.println( "Student Age: " + student.getAge() );
            System.out.println( "Student Address: " + student.getAddress() );
            System.out.println( "Student Roll No.: " + student.getRollNo() );
            System.out.println( "Student height: " + student.getHeight() );
        }
        catch( IOException e )
        {
            System.out.println( "IOException: " + e.getMessage());
        }
    }
    public static void Serialize() throws IOException
    {
        FileOutputStream fout = new FileOutputStream("student.ser" ) ;
        ObjectOutputStream oos = new ObjectOutputStream( fout ) ;
        oos.writeObject( student ) ;


    }
    public static void Deserialize() throws IOException
    {
        try {
            student = null;
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            student = (Student) ois.readObject();
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println("ClassNotFoundException: " + e.getMessage() );
        }
    }
}
