package com.harmonengineering.files ;
import com.harmonengineering.files.FileHandle;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.StringTokenizer;

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
                    com.harmonengineering.files.FileHandler fh = new com.harmonengineering.files.FileHandler( file ) ;
                    fh.WriteText( fileName ) ;
                    fh.AppendText("initial text\n");
                    fh.AppendText("appended text\n");
                    fh.AppendText("final text\n");
                }
                else if ( token.equals("Write"))
                {
                    fileName = "./" + stringReader.nextToken();

                    //FileHandle fh = new FileHandle( fileName ) ;
                    com.harmonengineering.files.FileHandler handler = new com.harmonengineering.files.FileHandler( fileName ) ;
                    handler.WriteText( stringReader.nextToken("\n" ).trim()) ;
                    // handler.CloseWriter();
                }
                else if ( token.equals( "Append" ))
                {
                    fileName = "./" + stringReader.nextToken();
                    com.harmonengineering.files.FileHandler handler = new com.harmonengineering.files.FileHandler( fileName, true ) ;
                    handler.AppendText( stringReader.nextToken("\n" ).trim()+"\n") ;
                }
                else if ( token.equals("Show" ))
                {
                    fileName = "./" + stringReader.nextToken();
                    FileHandle fh = new FileHandle( fileName ) ;
                    com.harmonengineering.files.FileHandler handler = new com.harmonengineering.files.FileHandler( fh ) ;
                    handler.ShowFile() ;
                }
                else if ( token.equals("Delete"))
                {
                    fileName = "./" + stringReader.nextToken();
                    com.harmonengineering.files.FileHandler fh = new com.harmonengineering.files.FileHandler( new FileHandle(fileName) ) ;
                    //FileHandle file = new FileHandle(fileName) ;
                    fh.Delete();
                }
            }
            line = scriptreader.readLine();
        }
    }
}