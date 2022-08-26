package com.harmonengineering.beans;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Date;


public class FlightDetailBean
{
    private int     ID ;
    private String departureCity ; // departing city
    private String arrivalCity ;// arrival city
    private String travelDate ; // travel date
    private String  airlineName ; // airline
    private Integer     requiredSeats ;// requested seats
    private double  ticketPrice ;

    public FlightDetailBean() { /*this( new FlightDetailBean()) ;*/ }
    public FlightDetailBean(FlightDetailBean bean)
    {
        this.ID = bean.ID ;
        this.departureCity = bean.departureCity ;
        this.arrivalCity = bean.arrivalCity ;
        this.travelDate = bean.travelDate ;
        this.airlineName = bean.airlineName ;
        this.requiredSeats = bean.requiredSeats ;
        this.ticketPrice = bean.ticketPrice ;
    }
    public void setID(int ID) { this.ID = ID; }
    public int getID() { return ID; }

    public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }
    public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }
    public void setTravelDate(String travelDate) { this.travelDate = travelDate ;  }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public void setRequiredSeats( Integer requiredSeats) {this.requiredSeats = requiredSeats; }
    public void setTicketPrice( double ticketPrice) { this.ticketPrice = ticketPrice ; }

    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public String getTravelDate() {  return travelDate ;}
    public String getAirlineName() { return airlineName;  }
    public Integer getRequiredSeats() { return requiredSeats; }
    public double getTicketPrice() { return ticketPrice; }

    public void sprint(JspWriter out) throws IOException
    {
        out.println( "ID: " + ID +  departureCity  +    arrivalCity );
    }
}

class StringPrintStream
{
    StringOutputStream sos ;
    PrintStream strStream ;
    public StringPrintStream()
    {
        sos = new StringOutputStream() ;
        strStream = new PrintStream( sos, true ) ;
    }
    public void useIt()
    {
        int DummyNumber = 2540 ;
        strStream.println( "dpartureCity: " + DummyNumber );
        //System.out.println( strStream ) ;
        //System.out.print( strStream.toString() ) ;

    }
    //public PrintWriter out() { return strSream( ) ;}
    public String getString()
    {
        return sos.toString() ;
    }
}

class StringOutputStream extends OutputStream {

    StringBuffer mBuf;
 /*   public String getString() {
        return mBuf.toString();
    }*/
    public StringOutputStream()
    {
        mBuf = new StringBuffer() ;
    }
    public void write(int b) throws IOException
    {
        mBuf.append( b ) ;
    }
}