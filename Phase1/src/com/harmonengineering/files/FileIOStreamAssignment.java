package com.harmonengineering.files;

import java.io.*;

public class FileIOStreamAssignment
{
    public static void main( String[] args )
    {
        try
        {
            FileOutputStream fout = new FileOutputStream("day2.txt", true);
            BufferedOutputStream bout = new BufferedOutputStream( fout, 1023 ) ;
            BufferedInputStream  bis  = new BufferedInputStream( System.in, 1024 ) ;
            System.out.println( "Enter input text. '@' for end of input") ;
            int ch ;
            while( (ch = bis.read()) != '@' )
            {
                bout.write( ch ) ;
            }

            //bout.flush() ;
            bout.close() ;
            fout.close() ;

            ReadFile() ;
            System.out.println() ;

        }
        catch( IOException e ) {
            System.out.println("IOException: " + e.getMessage());
        }

    }
    static void ReadFile() throws IOException
    {
        FileInputStream fin = new FileInputStream( "day2.txt" ) ;

        int ch ;
        while((ch = fin.read()) != -1 )
        {
            System.out.print( (char)ch) ;
        }
        fin.close() ;

    }
}
