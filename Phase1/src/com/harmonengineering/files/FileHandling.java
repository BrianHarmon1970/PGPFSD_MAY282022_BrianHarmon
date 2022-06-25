package com.harmonengineering.files;

import java.io.*;
import java.nio.file.*;
import java.sql.Time;
import java.time.*;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

class FileHandle
{
    File m_file ;
    String m_strFileName ;
    FileHandle( String filename ) throws IOException
    {
        construct( filename, false ) ;
    }
    FileHandle( String filename, boolean create ) throws IOException
    {
        construct( filename, create ) ;
        //m_strFileName = new String( filename ) ;
        //m_file = new File( m_strFileName ) ;
        //if (!m_file.exists()) {
        //    createFile() ;
        //}
    }
    void construct( String filename, boolean  create ) throws IOException
    {
        m_strFileName = new String( filename ) ;
        m_file = new File( m_strFileName ) ;
        if (!m_file.exists() && create ) {
            createFile() ;
        }
    }
    public String getPath()
    {
        return m_file.getPath() ;
    }
    public File File() { return m_file ; }
    public void deleteFile() throws IOException
    {
        System.out.println( "File: " + m_file.getName()) ;
        System.out.println( "File name: " + m_strFileName ) ;
        Files.deleteIfExists(Paths.get( m_strFileName ));
        //return m_file.delete() ;
    }
    public boolean Exists() { return m_file.exists() ; }
    public boolean createFile() throws IOException
    {
        System.out.println("Create File: " + m_strFileName ) ;
        return m_file.createNewFile();//createFile( m_strFileName ) ;
    }
    public String getFileName() { return m_strFileName ;  }
}
class FileHandler
{
    FileWriter m_writer ;
    FileReader m_reader ;
    BufferedReader m_bufferedReader ;
    FileHandle m_FileHandle ;
    FileHandler( String fname, boolean create ) throws IOException
    {
        m_FileHandle = new FileHandle( fname ) ;
        construct( create ) ;
    }
    FileHandler( String fname ) throws  IOException
    {
        m_FileHandle = new FileHandle( fname ) ;
        construct( false );
    }
    FileHandler( FileHandle fh ) throws IOException
    {
        m_FileHandle = fh ;
        construct( false ) ;
    }
    void construct( boolean create ) throws  IOException
    {
        if (!m_FileHandle.Exists() && (create)) {
            m_FileHandle.createFile() ;
        }
        if ( m_FileHandle.Exists() ) {
            m_reader = new FileReader(m_FileHandle.getFileName());
            m_bufferedReader = new BufferedReader(m_reader);
        }
    }
    public FileHandle getHandle( )
    {
        return m_FileHandle ;
    }
    public void Delete() throws IOException
    {
        m_reader.close() ;
        //m_writer.close() ;
        m_bufferedReader.close() ;
        m_FileHandle.deleteFile() ;
    }
    public void ShowFile(  ) throws IOException
    {
        int linecount = 0 ;
        System.out.println( "<===[ " + m_FileHandle.getPath() + " ]===>" ) ;

        String readline = m_bufferedReader.readLine() ;
        while ( readline != null )
        {
            ++linecount ;
            System.out.println(linecount + " " +readline);
            readline = m_bufferedReader.readLine();
        }
    }
    public void AppendText( String text ) throws IOException
    {
        if (!m_FileHandle.Exists()) {
            m_FileHandle.createFile() ;
        }
        m_writer = new FileWriter( m_FileHandle.getFileName(), true ) ;
        m_writer.write( text ); ;
        //m_writer.write( "\n" ); ;
        m_writer.close() ;
    }
    public void WriteText( String text ) throws IOException
    {
        m_writer = new FileWriter( m_FileHandle.getFileName(), false ) ;
        m_writer.write( text ) ;
        //m_writer.write( "\n" ) ;
        m_writer.close();
    }
    void CloseWriter() throws IOException
    {
        m_writer.close();
        m_writer = null ;
    }
    void ShowDetail() throws IOException
    {
        //final Path path = FileSystems.getDefault().getPath(m_FileHandle.getFileName());
        final Path path  = m_FileHandle.File().toPath() ;
        System.out.println( " Name: " + m_FileHandle.File().getName() + " Size: " + Files.size( path )) ;
        System.out.println( "Path: " + m_FileHandle.File().getPath() ) ;
        System.out.println( "Absolute Path: " + m_FileHandle.File().getAbsolutePath() ) ;
        System.out.println( "length: " + m_FileHandle.File().length() );
        System.out.println( "Parent: " + m_FileHandle.File().getParent());

        Date d = new Date( m_FileHandle.File().lastModified() ) ;
        System.out.println( "Last Modified: " + d ) ;
    }
    void RunScript() throws IOException
    {
        String line ; //= reader.readLine() ;
        //BufferedReader scriptreader = new BufferedReader( new FileReader( "./script.txt" )) ;
        BufferedReader scriptreader = m_bufferedReader ;
        line = scriptreader.readLine() ;
        FileWriter writer = m_writer ;
        while ( line != null ) {
            //System.out.println(line);
            StringTokenizer stringReader = new StringTokenizer( line ) ;
            while ( stringReader.hasMoreTokens() ) {
                String token = stringReader.nextToken();
                String fileName = new String() ;

                if ( token.equals("Create" ))
                {
                    fileName = "./" + stringReader.nextToken();

                    File f = new File(fileName);
                    f.createNewFile();
                    FileHandle file = new FileHandle( fileName ) ;

                    file.createFile() ;
                    FileHandler fh = new FileHandler( file ) ;
                    fh.WriteText( fileName ) ;
                    fh.AppendText("initial text\n");
                    fh.AppendText("appended text\n");
                    fh.AppendText("final text\n");
                }
                else if ( token.equals("Write"))
                {
                    fileName = "./" + stringReader.nextToken();

                    //FileHandle fh = new FileHandle( fileName ) ;
                    FileHandler handler = new FileHandler( fileName ) ;
                    handler.WriteText( stringReader.nextToken("\n" ).trim()) ;
                   // handler.CloseWriter();
                }
                else if ( token.equals( "Append" ))
                {
                    fileName = "./" + stringReader.nextToken();
                    FileHandler handler = new FileHandler( fileName, true ) ;
                    handler.AppendText( stringReader.nextToken("\n" ).trim()+"\n") ;
                }
                else if ( token.equals("Show" ))
                {
                    fileName = "./" + stringReader.nextToken();
                    FileHandle fh = new FileHandle( fileName ) ;
                    FileHandler handler = new FileHandler( fh ) ;
                    handler.ShowFile() ;
                }
                else if ( token.equals("Delete"))
                {
                    fileName = "./" + stringReader.nextToken();
                    FileHandler fh = new FileHandler( new FileHandle(fileName) ) ;
                    //FileHandle file = new FileHandle(fileName) ;
                    fh.Delete();
                }
            }
            line = scriptreader.readLine();
        }
    }
}
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
        finally
        {
            System.out.println( "finally: " ) ;
        }
    }
}
