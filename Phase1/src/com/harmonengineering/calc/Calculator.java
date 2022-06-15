package com.harmonengineering.calc;

import java.awt.*;
import java.util.*;
import java.util.regex.*;

public class Calculator
{
    static final String doublePattern = "([0-9]+)((.[0-9]+)?)" ;
    static final String operatorPattern = "([\\+\\-\\*\\/\\(\\)=])" ;
    static final String specialCharPattern = "([\\(\\)\\=xXqQ])" ;
    static final String ignorePattern = "([a-z][A-Z]\\s\\~\\!\\#\\@\\$\\%\\^\\&_)" ;
    public static void main( String[] args )
    {
        System.out.println( "\n<<<==== This is the Calculator app ====>>>" ) ;
        System.out.println( "usage is postfix, EX: 123+123+=" ) ;
        System.out.println( "valid operations: (/,*,+,-)  = for total - x to exit." ) ;
        Scanner c = new Scanner( System.in ) ;
        //c.useDelimiter("("+operatorPattern+"|[\\s|\\G]+"+")");
        c.useDelimiter("(\\s|\\G)+") ;
        System.out.print( "\u001B[34m") ;
        ArrayList<operationTuple> opList = new ArrayList<>() ;

        Double value = 0.0 ;
        Double accumulator = 0.0 ;
        Double total = 0.0 ;
        String op  = "" ;

        boolean bRunning = true ;
        while( bRunning == true )
        {
            String scanString ;
            StringTokenizer tokenString ;

            System.out.print("["+accumulator+"]["+total+"]["+value+"] Enter>");
            scanString = c.nextLine() ;
            //System.out.println( "scanned string: " + scanString ) ;
            Scanner sc = new Scanner( scanString ) ;

            tokenString = new StringTokenizer( scanString  ,
                    "[\t\n\f\r] "+operatorPattern, true  ) ;

            while( tokenString.hasMoreTokens() )
            {
                String tokenstr = tokenString.nextToken() ;
                //System.out.println( "tokenString: '"+tokenstr+"'" ) ;
                Scanner scanner = new Scanner( tokenstr ) ;
                //scanner.useDelimiter( "("+operatorPattern+"|\\G)") ;
                if ( scanner.hasNext( specialCharPattern ))
                {
                    operationTuple operation ;
                    String token = scanner.next( specialCharPattern ) ;
                    Iterator i = opList.iterator() ;
                    while( i.hasNext())
                    {
                        operation = (operationTuple) i.next();
                        System.out.println( operation.getOperator() +" "+ operation.getOperand()) ;
                    }
                    switch( token.charAt(0) )
                    {
                        case '=':
                            total = accumulator ; value = 0.0 ; accumulator = 0.0 ;
                            System.out.println( "= " + total ) ;
                            opList.clear() ;
                            break ;
                        case 'X': System.out.print( "\u001b[2J" ) ; break ;
                        case 'x': bRunning = false ;
                    }
                }
                if (scanner.hasNext(operatorPattern))
                {
                    op = scanner.next(operatorPattern);
                    //if ( op.charAt(0) != '=' )
                    //    System.out.println(/*"operator: " +*/ op + " " + value ) ;
                    //System.out.println("value: " + value ) ;
                    //System.out.println( "op.charAT(0): "+ op.charAt( 0 )) ;

                    switch ( op.charAt(0) )
                    {
                        case '+': accumulator += value ; break ;
                        case '-': accumulator -= value ; break ;
                        case '*': accumulator *= value ; break ;
                        case '/': accumulator /= value ; break ;
                    }
                    opList.add(new operationTuple(op,value)) ;

                } else if (scanner.hasNext(doublePattern))
                {
                    String strNumber = scanner.next(doublePattern);
                    //System.out.println( "strNumber = '"+strNumber+"'" ) ;
                    Double DD = Double.parseDouble(strNumber);
                    //System.out.println(" DD(pattern) = " + DD);
                    value = DD ;
                } else if (scanner.hasNext()) {
                    scanner.next() ;
                    //System.out.println("Next() -> " + scanner.next());
                }
            }
        }
    }
}