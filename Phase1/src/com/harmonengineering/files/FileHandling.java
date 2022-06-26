package com.harmonengineering.files;

import java.io.*;
import java.nio.file.*;
import java.sql.Time;
import java.time.*;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class FileHandling
{
    public static void main( String[] args )
    {
        //File file = new File("newfile.dat" )  ;
        try
        {
            FileHandler fh = new FileHandler( "./script.txt" , false) ;
            if ( fh.getHandle().Exists())
                fh.RunScript() ;

            FileHandler fhWrite = new FileHandler( new FileHandle("./WriteFile.txt" )) ;
            fhWrite.WriteText( "11111111111\n");
            fhWrite.AppendText("22222222222\n");
            fhWrite.AppendText("33333333333\n");
            fhWrite.AppendText("44444444444\n");
            fhWrite.AppendText("5555555555\n");
            fhWrite.AppendText("66666666666\n");
            fhWrite.AppendText("77777777777\n");

            FileHandler fhAppend = new FileHandler( "./AppendFile.txt", true ) ;
            fhAppend.AppendText( "XXXOOOXXX\n") ;
            fhAppend.AppendText( "OOOXXXOOO\n") ;

            fhWrite.ShowFile() ; fhWrite.ShowDetail();
            fhAppend.ShowFile() ; fhAppend.ShowDetail();
        }
        catch ( IOException e )
        {
            System.out.println( "IOException: " + e.getMessage() ) ;
        }
    }
}
