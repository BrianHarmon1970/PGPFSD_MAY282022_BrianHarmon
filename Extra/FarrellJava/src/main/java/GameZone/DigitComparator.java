package GameZone;

import static java.lang.Integer.min;

public class DigitComparator
{
    int ax, a1, a2, a3 ;
    int dx, d1, d2, d3 ;
    int fx, f1, f2, f3 ;
    int nx, n1, n2, n3 ;
    int NX, N1, N2, N3 ;
    int DX, D1, D2, D3 ;
    int FX, F1, F2, F3 ;
    int cx, c1, c2, c3 ;

    boolean debug ;

    LotteryNumber numberOne  ;
    LotteryNumber numberTwo  ;

    public int debug_compare( LotteryNumber lhs, LotteryNumber rhs )
    { return compare(  lhs, rhs, true ) ; }

    public int compare( LotteryNumber lhs, LotteryNumber rhs )
    { return compare( lhs, rhs, false ) ; }
    public int compare( LotteryNumber lhs, LotteryNumber rhs, boolean debug )
    {
        this.debug = debug  ;
        numberOne = lhs ;
        numberTwo = rhs ;

        LotteryNumber nTemp ;
        if ( numberTwo.value() < numberOne.value() )
        { nTemp = numberTwo ; numberTwo = numberOne ; numberOne = nTemp ; }

        summarizeMatches( ) ;
        computeSums() ;
        if (debug) printRegs() ;
        return Test() ;
    }
    int Test() {
        int ret_value = 0;
        ret_value =  (((fx+FX)+ 1 )/2 ) ;
        int fResult =  (( f1 > 0 ? 1 : 0 ) +
                ( f2 > 0 ? 1 : 0 ) +
                ( f3 > 0 ? 1 : 0 )) ;
        int FResult =  (( F1 > 0 ? 1 : 0 ) +
                ( F2 > 0 ? 1 : 0 ) +
                ( F3 > 0 ? 1 : 0 )) ;
        ret_value = min( FResult, fResult ) ;

        if (debug) System.out.println( "Test() = " +  ret_value ) ;
        return  ret_value ;
    }
    void computeSums()
    {
        int ln1 , ln2, ln3 ;
        int lN1, lN2, lN3 ;
        lN1 = numberOne.getN1() ;
        lN2 = numberOne.getN2() ;
        lN3 = numberOne.getN3() ;
        ln1 = numberTwo.getN1() ;
        ln2 = numberTwo.getN2() ;
        ln3 = numberTwo.getN3() ;

        NX = N1 + N2 + N3 ;
        nx = n1 + n2 + n3 ;

        a1 = ( N1 + n1 ) ;
        a2 = ( N2 + n2 ) ;
        a3 = ( N3 + n3 ) ;
        ax = a1 + a2 + a3 ;


        c1 = ( lN1 - ln1 ) ;
        c2 = ( lN2 - ln2 ) ;
        c3 = ( lN3 - ln3 ) ;
        cx = c1+c2+c3  ;

        d1 = ( N1 - n1 ) ;
        d2 = ( N2 - n2 ) ;
        d3 = ( N3 - n3 ) ;
        dx = d1 + d2 + d3 ;

        D1 = ( n1 - N1 ) ;
        D2 = ( n2 - N2 ) ;
        D3 = ( n3 - N3 ) ;
        DX = D1 + D2 + D3 ;

        f1 = ((( a1 + d1 )+1)/2) ;//+ c1 ) ;
        f2 = ((( a2 + d2 )+1)/2) ;//+ c2 ) ;
        f3 = ((( a3 + d3 )+1)/2)  ;//+ c3 ) ;
        fx = f1 + f2 + f3 ;

        F1 = ((( a1 + D1 )+1)/2) ;//+ c1 ) ;
        F2 = ((( a2 + D2 )+1)/2) ;//+ c2 ) ;
        F3 = ((( a3 + D3 )+1)/2) ;//+ c3 ) ;
        FX = F1 + F2 + F3 ;

       // f1 = ((( a1  ))/2) ;//+ c1 ) ;
       // f2 = ((( a2  ))/2) ;//+ c2 ) ;
       // f3 = ((( a3  ))/2)  ;//+ c3 ) ;
       // fx = f1 + f2 + f3 ;

        // f1 = (((( n1 + D1 )+( N1 + d1 )) + 1)/2); ;//+ c1 ) ;
        //f2 = (((( n2 + D2 )+( N2 + d2 )) + 1)/2) ;//+ c2 ) ;
        //f3 = (((( n3 + D3 )+( N3 + d3 )) + 1)/2) ; ;//+ c3 ) ;
        //fx = f1 + f2 + f3 ;

        //f1 = ( (a1) )  ; ;//+ c1 ) ;
        //f2 = ( (a2) )  ;//+ c2 ) ;
        //f3 = ( (a3) )  ; ;//+ c3 ) ;
        //fx = f1 + f2 + f3 ;
    }
    void summarizeMatches(  )
    {
        LotteryNumber BigRef;  LotteryNumber LilRef;
        int TestA = numberOne.value() ;
        int TestB = numberTwo.value() ;
        if (debug) System.out.println(" A00: " + TestA + "\n B00: " + TestB );

        if (TestA > TestB) {
            BigRef = numberOne ;
            LilRef = numberTwo ;
        } else {
            BigRef = numberTwo ;
            LilRef = numberOne ;
        }

        BigRef = numberOne ;
        LilRef = numberTwo ;
        N1 = N2 = N3 = 0 ;
        n1 = n2 = n3 = 0 ;
        //////// FIRST INVERSION SET
        // Left Sequential     Right getN1()
        if (BigRef.getN3() == LilRef.getN1()) { n1++; N3++; }
        if (BigRef.getN3() == LilRef.getN2()) { n2++; N3++; }
        if (BigRef.getN3() == LilRef.getN3()) { n3++; N3++; }

        // Left Secquential    Right getN2()
        if (BigRef.getN2() == LilRef.getN1()) { n1++; N2++; }
        if (BigRef.getN2() == LilRef.getN2()) { n2++; N2++; }
        if (BigRef.getN2() == LilRef.getN3()) { n3++; N2++; }

        //  Left Sequential     Right getN3()
        if (BigRef.getN1() == LilRef.getN1()) { n1++; N1++; }
        if (BigRef.getN1() == LilRef.getN2()) { n2++; N1++; }
        if (BigRef.getN1() == LilRef.getN3()) { n3++; N1++; }

        /*
        // SECOND INVERSION SET
        // Big getN1()        Little Sequential
        if (BigRef.getN1() == LilRef.getN1())
            //{ n1++; N1++; }
        if (BigRef.getN1() == LilRef.getN2())
           // { n2++; N1++; }
        if (BigRef.getN1() == LilRef.getN3())
           // { n3++; N1++; }

        // Big getN1()        Little Sequential
        if (BigRef.getN2() == LilRef.getN1())
           // { n1++; N2++; }
        if (BigRef.getN2() == LilRef.getN2())
           // { n2++; N2++; }
        if (BigRef.getN2() == LilRef.getN3())
           // { n3++; N2++; }

        // Big numeberThree     Little Sequential
        if (BigRef.getN3() == LilRef.getN1())
            //{ n1++; N3++; }
        { n1 = 1 ; N1=1; }
        if (BigRef.getN3() == LilRef.getN2())
           // { n2++; N3++; }
        { n2 = 2 ; N2=2; }
        if (BigRef.getN3() == LilRef.getN3())
            //{ n3++; N3++; } n3 = 3;  }
            { n3 = 3 ; N3=3; }
        */
    }

    void printRegs() {
        System.out.println("NX -> " + N1 + " " + N2 + " " + N3 + " - " + NX);
        System.out.println("nx -> " + n1 + " " + n2 + " " + n3 + " - " + nx);

        System.out.println("ax -> " + a1 + " " + a2 + " " + a3 + " - " + ax);
       // System.out.println("cx -> " + c1 + " " + c2 + " " + c3 + " - " + cx);
        System.out.println("dx -> " + d1 + " " + d2 + " " + d3 + " - " + dx);
        System.out.println("DX -> " + D1 + " " + D2 + " " + D3 + " - " + DX);
        System.out.println("fx -> " + f1 + " " + f2 + " " + f3 + " - " + fx);
        System.out.println("FX -> " + F1 + " " + F2 + " " + F3 + " - " + FX);
        System.out.println("-----------------------------------------------" ) ;
    }
    void nxdigitPrint()
    {
        System.out.println( "NX ->" + N1 + " " + N2 + " " + N3 ) ;
        System.out.println( "nx ->" + n1 + " " + n2 + " " + n3 ) ;
    }

    void outputPrint()
    {
        printRegs();
        //nxdigitPrint();
    }


    int NX1Scruncher() {
        int NX = (( N1 > 0 ? 1 : 0 ) +
                ( N2 > 0 ? 1 : 0 ) +
                ( N3 > 0 ? 1 : 0 )) ;
        return NX ;
    }
    int NX2Scruncher() {
        int NX = (( N1 == 1 ? 1 : 0 ) +
                ( N2 == 1 ? 1 : 0 ) +
                ( N3 == 1 ? 1 : 0 )) ;
        return NX ;
    }
    int nx1Cruncher()
    {
        int nx =  (( n1 > 0 ? 1 : 0 ) +
                ( n2 > 0 ? 1 : 0 ) +
                ( n3 > 0 ? 1 : 0 )) ;
        return nx ;
    }
    int nx2Crunncher()
    {
        int nx =  (( n1 == 1 ? 1 : 0 ) +
                ( n2 == 1 ? 1 : 0 ) +
                ( n3 == 1 ? 1 : 0 )) ;
        return nx ;
    }
    int axdigitScruncn =
            (( a1 > 0 ? 1 : 0 ) +
                    ( a2 > 0 ? 1 : 0 ) +
                    ( a3 > 0 ? 1 : 0 )) ;

    int NSUM = 0 ;
    int NSUM() {
        return (N1 + n1) + (N1 + n2) + (N1 + n3) +
                (N2 + n1) + (N2 + n2) + (N2 + n3) +
                (N3 + n1) + (N3 + n2) + (N3 + n3);
        // +           ( N1 + N2 ) + ( N1 + N3 ) + ( N3 + N2 ) +
        //           ( n1 + n2 ) + ( n1 + n3 ) + ( n2 + n3 )
    }
    void NSUM_Print()
    {
        if (debug) {
            printRegs();
            System.out.print("NSUM: " + NSUM + "\t((NSUM+4)/9): " + ((NSUM + 4) / 9)
                    + "\t((NSUM+5)/10): " + ((NSUM + 5) / 10)
                    + "\t((NSUM+7.5 )/15.0)/2.0): " + (NSUM + 8) / 16);
        }
    }
    void dxCrumbs()
    {
        //int d1 ; = Math.abs( N1 - n1 ) ;
        //int d2 ; = Math.abs( N2 - n2 ) ;
        //int d3 ; = Math.abs( N3 - n3 ) ;

        //int dx = (( d1 > 0 ? 1 : 0 ) +
        //            ( d2 > 0 ? 1 : 0 ) +
        //             ( d3 > 0 ? 1 : 0 )) ;

    }
}
