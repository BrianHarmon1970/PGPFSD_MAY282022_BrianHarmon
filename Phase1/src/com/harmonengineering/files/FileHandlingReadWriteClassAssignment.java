package com.harmonengineering.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingReadWriteClassAssignment
{
    public static void main( String[] args )
    {
        try {
            FileWriter writer = new FileWriter("weekend.txt");
            Scanner scanner = new Scanner(System.in);
            System.out.print( "Enter>" ) ;
            writer.write( scanner.nextLine() ) ;
            writer.close() ;

            FileReader reader = new FileReader( "weekend.txt" ) ;
            char[] buffer = new char[ 256 ] ;
            reader.read( buffer ) ;
            reader.close() ;

            System.out.println( "read buffer: " + new String( buffer ) ) ;
        }
        catch ( IOException e )
        {
            System.out.println(" IOException: " + e.getMessage());
        }
    }
}
