package GameZone;

import java.time.LocalDateTime;
import java.util.Scanner;

public class LotteryHandler
{
    DigitComparator dc ;
    void Main(String[] args)
    {
        dc = new DigitComparator() ;
        LotteryNumber L1 = new LotteryNumber(7, 5, 7);
        LotteryNumber L2 = new LotteryNumber(5, 5, 7);

        showLotteryNumber(L1);
        showLotteryNumber(L2);
        dc.debug_compare( L1, L2 ) ;

        LotteryNumber L3 = new LotteryNumber(7, 5, 7);
        LotteryNumber L4 = new LotteryNumber(7, 5, 7);
        showLotteryNumber(L3);
        showLotteryNumber(L4);
        dc.debug_compare( L3, L4 ) ;

        LotteryNumber L5 = new LotteryNumber(5, 7, 5);
        LotteryNumber L6 = new LotteryNumber(5, 5, 7);
        showLotteryNumber(L5);
        showLotteryNumber(L6);
        dc.debug_compare( L5, L6 ) ;

        LotteryNumber L7 = new LotteryNumber(2, 8, 6);
        LotteryNumber L8 = new LotteryNumber(2, 3, 6);
        showLotteryNumber(L7);
        showLotteryNumber(L8);
        dc.debug_compare( L7 , L8 ) ;

        //LotteryNumber  L9 = new LotteryNumber( 5, 8, 2 ) ;
        //LotteryNumber L10 = new LotteryNumber( 3, 2, 5 ) ;
        LotteryNumber L9 = new LotteryNumber(8, 8, 8);
        LotteryNumber L10 = new LotteryNumber(8, 2, 5);
        showLotteryNumber(L9);
        showLotteryNumber(L10);
        dc.debug_compare( L9 , L10 ) ;

        LotteryNumber L11 = new LotteryNumber(4, 6, 6);
        //LotteryNumber L12 = new LotteryNumber( 6, 4, 6 ) ;
        LotteryNumber L12 = new LotteryNumber(4, 6, 5);

        showLotteryNumber(L11);
        showLotteryNumber(L12);
        dc.debug_compare( L11 , L12 ) ;

        LotteryNumber L13 = new LotteryNumber(3, 4, 4);
        //LotteryNumber L14 = new LotteryNumber(  9, 1, 4 ) ; // A rotation
        //LotteryNumber L14 = new LotteryNumber(   4, 9 , 1) ;// B Another rotation
        LotteryNumber L14 = new LotteryNumber(1, 4, 9);// C there are three

        showLotteryNumber(L13);
        showLotteryNumber(L14);
        dc.debug_compare( L13 , L14 ) ;

        LotteryNumber L15 = new LotteryNumber( 4, 8, 5);
        LotteryNumber L16 = new LotteryNumber( 3, 5, 5);// C there are three

        showLotteryNumber(L15);
        showLotteryNumber(L16);
        dc.debug_compare( L15 , L16 ) ;

        try {   LotteryTicket lt = new LotteryTicket(L12);
            LotteryDraw ld = new LotteryDraw(L11);
            showWin(ld, lt);
/*
        runComp( L1, L2 , 1_000_000_000 ) ;
        runComp( L5, L6 , 1_000_000_000 ) ;
        runComp( L3, L4 , 1_000_000_000 ) ;
        runComp( new LotteryNumber( 1, 2,3),
                 new LotteryNumber( 9, 2, 7 ),
                1_000_000_000 ) ;
*/
            displayIntro();

            LotteryDraw draw = new LotteryDraw();
            LotteryTicket ticket = new LotteryTicket();
            //ticket.UserPick();
            ticket.RandomPick();

            LotteryTicket ticketTwo = new LotteryTicket();
            ticketTwo.RandomPick();

            showLotteryNumber(ticket.getTicketNumber());
            showLotteryNumber(ticketTwo.getTicketNumber());
            showLotteryNumber(draw.getDrawNum());

            System.out.println(" ticket 1 matches: " + dc.debug_compare( ticket.getTicketNumber(), draw.getDrawNum()));
            System.out.println(" ticket 2 matches: " + dc.debug_compare( ticketTwo.getTicketNumber(), draw.getDrawNum()));

            showWin(draw, ticket);
            showWin(draw, ticketTwo);
            showWin(draw, new LotteryTicket(1, 2, 3));
            showWin(draw, new LotteryTicket(9, 2, 7));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
            showWin(draw, new LotteryTicket(new LotteryNumber()));
        } catch ( LotteryException e )
        {
            System.out.println(e.getLotteryErrorMessage()) ;
        }
    }
    int getUserNumber()
    {
        Scanner input = new Scanner( System.in ) ;
        System.out.print( "Number>" ) ;
        return input.nextInt() ;
    }
    int getRandom()
    {
        return (int)(Math.random() * 9) + 1 ;
    }
    void showLotteryNumber( LotteryNumber num )
    {
        //System.out.println( num.getN1() + " " +
        //                    num.getN2() + " " +
        //                    num.getN3() + " " ) ;
        printLotteryNumber( num ) ;
        System.out.println() ;
    }
    void printLotteryNumber( LotteryNumber num )
    {
        System.out.print( num.getN1() + " " +
                num.getN2() + " " +
                num.getN3() + " " ) ;
    }
    void showWin( LotteryDraw draw, LotteryTicket tkt ) throws LotteryException
    {
        DigitComparator dc = new DigitComparator() ;
        LotteryNumber drawnum = draw.getDrawNum() ;
        LotteryNumber ticketnum = tkt.getTicketNumber() ;
        int match_count = dc.compare( drawnum , ticketnum ) ;
        System.out.print( "Draw: " ) ; printLotteryNumber( drawnum );
        System.out.print( "\tTicket: " ) ; printLotteryNumber( ticketnum ) ;
        System.out.print( "\tmatch: " + match_count ) ;
        System.out.print( "\twin: $" + getWin( match_count )) ;
        System.out.println() ;
    }

    double getWin( int match_count ) throws LotteryException
    {
        switch ( match_count )
        {
            case 0: return     0.00 ;
            case 1: return    10.00 ;
            case 2: return   100.00 ;
            case 3: return  1000.00 ;
            default: {

                StringBuilder sb = new StringBuilder() ;
                sb.append( " GetWin  invald match count" + match_count ) ;
                throw  new LotteryException( sb.toString() ) ;
            }
        }
    }
    static void displayIntro()
    {
        System.out.println("-----------------------------------------" ) ;
        System.out.println(" Matching Numbers                Award($)" ) ;
        System.out.println("-----------------------------------------" ); ;
        System.out.println(" Any one matching                      10" ) ;
        System.out.println(" Two matching                         100" ) ;
        System.out.println(" Three matching, not in order       1,000" ) ;
        System.out.println(" Three matching in exact order  1,000,000" ) ;
        System.out.println(" No matches                             0" ) ;
        System.out.println("-----------------------------------------" ) ;
    }
    static void runComp( LotteryNumber L1, LotteryNumber L2 , int reps )
    {

        DigitComparator dc = new DigitComparator() ;
        LocalDateTime ldStop ;
        LocalDateTime ldStart = LocalDateTime.now() ;
        for ( int i = 0 ; i < reps ; ++i )
            dc.compare( L1,L2 ) ;
        ldStop = LocalDateTime.now() ;
        int seconds = ldStop.getSecond() - ldStart.getSecond() ;
        System.out.println( "Start: " + ldStart.getSecond() + "\tStop: " + ldStop.getSecond()) ;
        System.out.println( reps + " reps completed in " +
                seconds + " seconds. : " + ( (reps/(seconds+1))/1000) + " Kreps/s" ) ;

    }
    void unitTests()
    {
        int n1, n2, n3;
        n1 = getRandom();
        n2 = getRandom();
        n3 = getRandom();

        int u1, u2, u3 ;
        u1 = getUserNumber() ;
        u2 = getUserNumber() ;
        u3 = getUserNumber() ;
        System.out.println(u1 + " " + u2 + " " + u3 + " ");
        System.out.println(n1 + " " + n2 + " " + n3 + " ");
        LotteryNumber num1 = new LotteryNumber( n1, n2, n3 ) ;
        LotteryNumber num2 = new LotteryNumber( u1, u2, u3 ) ;
        dc.compare( num1, num2 )  ;

    }
}


class LotteryNumber
{
    private int numberOne ;
    private int numberTwo ;
    private int numberThree ;
    public LotteryNumber()
    {
        this( getRandomNumber(), getRandomNumber(), getRandomNumber()) ;
    }
    public LotteryNumber( int n1, int n2, int n3 )
    {
        numberOne = n1 ;
        numberTwo = n2 ;
        numberThree = n3 ;
    }
    int value() { return( numberOne * 100 + numberTwo * 10 + numberThree  ) ;  }

    private static int getRandomNumber() { return (int) (Math.random() * 9) + 1; }
    private static int getUserNumber( int digit )
    {
        switch( digit )
        {
            case 1: System.out.print("1ST ") ; break ;
            case 2: System.out.print("2ND ") ; break ;
            case 3: System.out.print("3RD ") ; break ;
        }
        return getUserNumber() ;
    }
    private static int getUserNumber()
    {
        Scanner input = new Scanner( System.in ) ;
        // if ( !input.hasNextInt() )
        System.out.print( "Number>" ) ;
        return input.nextInt() ;
    }
    public void UserPick()
    {
        numberOne = getUserNumber( 1 ) ;
        numberTwo = getUserNumber( 2 ) ;
        numberThree = getUserNumber( 3 ) ;
    }
    public void RandomPick()
    {
        numberOne = getRandomNumber() ;
        numberTwo = getRandomNumber() ;
        numberThree = getRandomNumber() ;
    }
    public int getN1() { return numberOne  ; }
    public int getN2() { return numberTwo  ; }
    public int getN3() { return numberThree  ; }
}

class LotteryDraw
{
    private final LotteryNumber DrawNum ;
    LotteryDraw()
    {
        DrawNum = new LotteryNumber() ;
    }
    public LotteryDraw( LotteryNumber ln )
    {
        DrawNum = ln ;
    }
    public LotteryNumber getDrawNum() { return DrawNum ; }
}
class LotteryTicket
{
    private final LotteryNumber TicketNum ;
    public LotteryTicket(  LotteryNumber n )
    {
        TicketNum = n ;
    }
    public LotteryTicket( int n1, int n2, int n3 )
    {
        TicketNum = new LotteryNumber( n1,n2,n3 ) ;
    }
    public LotteryTicket()
    {
        this( 0,0,0 ) ;
    }

    public LotteryNumber getTicketNumber() { return TicketNum ; }
    public void UserPick() { TicketNum.UserPick(); }
    public void RandomPick() { TicketNum.RandomPick() ; }
}

class LotteryException extends Exception
{
    String m_strMessage ;
    public LotteryException( String msg )
    {
        m_strMessage = msg ;
    }
    public String getLotteryErrorMessage( )
    {
        return m_strMessage ;
    }
}

