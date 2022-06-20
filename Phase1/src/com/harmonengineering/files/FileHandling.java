package com.harmonengineering.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class FileHandle
{
    File m_file ;
    String m_strFileName ;
    FileHandle( String filename ) throws IOException
    {
        m_strFileName = new String( filename ) ;
        m_file = new File( m_strFileName ) ;
        if (!m_file.exists()) {
            createFile() ;
        }
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
    /*
    public boolean createFile( String filename ) throws IOException
    {
        m_strFileName = filename ;
        //m_file = new File( filename ) ;
        return m_file.createNewFile() ;
    }*/
    public String getFileName() { return m_strFileName ;  }
}
class FileHandler
{
    FileWriter m_writer ;
    FileReader m_reader ;
    BufferedReader m_bufferedReader ;
    FileHandle m_FileHandle ;

    FileHandler( FileHandle fh ) throws IOException
    {
        m_FileHandle = fh ;
        m_reader = new FileReader( m_FileHandle.getFileName() ) ;
        m_bufferedReader = new BufferedReader( m_reader ) ;
        if (!m_FileHandle.Exists()) {
            m_FileHandle.createFile() ;
        }
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
        System.out.println( "<===[ " + m_FileHandle.getFileName() + " ]===>" ) ;

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
        m_writer.write( "\n" ) ;
        m_writer.close();
    }
}
public class FileHandling
{
    public static void main( String[] args )
    {
        //File file = new File("newfile.dat" )  ;
        try
        {
            //BufferedReader reader = new BufferedReader( new FileReader( "test.dat" )) ;
            String line ; //= reader.readLine() ;
            BufferedReader scriptreader = new BufferedReader( new FileReader( "./script.txt" )) ;
            line = scriptreader.readLine() ;
            FileWriter writer  ;
            while ( line != null ) {
                //System.out.println(line);
                StringTokenizer stringReader = new StringTokenizer( line ) ;
                while ( stringReader.hasMoreTokens() ) {
                    String token = stringReader.nextToken();
                    String fileName = new String() ;

                    if (token.equals("create")) {
                        fileName = "./" + stringReader.nextToken();
                        File f = new File(fileName);
                        f.createNewFile();
                        writer = new FileWriter(fileName);
                        writer.write(fileName + "\n");
                        writer.write("initial text\n");
                        writer.append("appended text\n");
                        writer.write("final text\n");
                        writer.close();
                    }
                    else if ( token.equals("Create" ))
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
                    else if ( token.equals("write"))
                    {
                        fileName = "./" + stringReader.nextToken();
                        File f = new File(fileName);
                        f.createNewFile();
                        writer = new FileWriter( fileName ) ;
                        writer.write( stringReader.nextToken("\n").trim()) ;
                        writer.write( "\n" ) ;
                        writer.close();
                    }
                    else if ( token.equals("Write"))
                    {
                        fileName = "./" + stringReader.nextToken();

                        FileHandle fh = new FileHandle( fileName ) ;
                        FileHandler handler = new FileHandler( fh ) ;
                        handler.WriteText( stringReader.nextToken("\n" ).trim()) ;
                    }
                    else if ( token.equals( "append" ))
                    {
                        fileName = "./" + stringReader.nextToken();
                        writer = new FileWriter( fileName ) ;
                        writer.append( stringReader.nextToken("\n" ).trim()) ;
                        //writer.write( "\nextra line text") ;
                        writer.write( "\n" ); ;
                        writer.flush() ;
                        writer.close() ;
                    }
                    else if ( token.equals( "Append" ))
                    {
                        fileName = "./" + stringReader.nextToken();
                        //FileHandle fh = new FileHandle( fileName ) ;
                        FileHandler handler = new FileHandler( new FileHandle(fileName)) ;
                        handler.AppendText( stringReader.nextToken("\n" ).trim()) ;
                    }
                    else if ( token.equals("show" ))
                    {
                        int linecount = 0 ;
                        fileName = "./" + stringReader.nextToken();
                        System.out.println( "<===[ " + fileName + " ]===>" ) ;
                        BufferedReader showReader = new BufferedReader( new FileReader( fileName )) ;
                        String readline = showReader.readLine() ;

                        while ( readline != null ) {
                            ++linecount ;
                            System.out.println(linecount + " " +readline);
                            readline = showReader.readLine();
                        }
                        System.out.println("") ;
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
