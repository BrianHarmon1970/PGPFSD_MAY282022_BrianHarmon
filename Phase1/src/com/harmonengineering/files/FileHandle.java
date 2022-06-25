package com.harmonengineering.files ;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
