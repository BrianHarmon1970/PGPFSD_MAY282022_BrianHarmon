<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/24/2022
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payement Update</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<h1>Payment Update</h1>
    paypal load: <%= ( request.getParameter("op").equals("paypal_load"))? "true" : "false"  %><br>
    paypal auth_paypal: <%= ( request.getParameter("op").equals("paypal_auth"))? "true" : "false"  %><br>
    paypal auth_card: <%= ( request.getParameter("op").equals("auth_card"))? "true" : "false"  %><br>
    <%
        Double purchase_price = bookingBean.getTotalPrice() ;
        String operation_code = request.getParameter("op") ;
        String result = "restart" ;
        switch ( operation_code )
        {
            case "paypal_load":
                Double v = 0.0 ;
                if ( request.getParameter( "paypal_amount" ) != null &&
                        !request.getParameter( "paypal_amount" ).isEmpty() )
                {
                    v = ( Double.parseDouble( request.getParameter("paypal_amount").toString())) ;
                    paymentAgentBean.setPayPalAccountValue( v );
                    out.println("Paypal account updated: " +
                            paymentAgentBean.getPayPalAccountValue() ) ;
                }
                if ( request.getAttribute("papal_amount") != null ||
                    request.getAttribute("paypal_amount1") != null )
                    out.println( "Atributes present.") ;
                out.println( "Account value: " + paymentAgentBean.getPayPalAccountValue()) ;
                break ;
            case "paypal_auth":

                paymentAgentBean.AuthorizePayPalPayment( purchase_price ) ;
                if( paymentAgentBean.isAuthorizedStatus())
                {
                    out.println( purchase_price + ": Authorized"  ) ;
                    result = "authorized" ;
                } else {
                    out.println(purchase_price + ": Denied");
                    result = "denied" ;
                }
                break ;
            case "auth_card":
            case "set_card":
                String cOne, cTwo, cThree, cFour, cvv ;
                cOne = request.getParameter("cnum_one") ;
                cTwo = request.getParameter("cnum_two") ;
                cThree = request.getParameter("cnum_three" ) ;
                cFour = request.getParameter("cnum_four" ) ;
                cvv = request.getParameter( "cnum_cvv") ;
                out.println( cOne + cTwo + cThree + cFour + " " + cvv  ) ;
                if( (cOne != null && !cOne.isBlank()) &&
                        (cTwo != null && !cTwo.isBlank()) &&
                        (cThree != null && !cThree.isBlank()) &&
                        (cFour != null && !cFour.isBlank()) &&
                        (cvv != null && !cvv.isBlank()) ) {
                    String cnum = new String();
                    cnum = cOne + cTwo + cThree + cFour;
                    out.println("cnum: " + cnum);
                    out.println("cvv: " + cvv);
                    if (operation_code.equals("set_card")) {
                        CardCredentials cc = new CardCredentials();
                        cc.setDigitString(cnum);
                        cc.setCvvString(cvv);
                        paymentAgentBean.setAuthorizedCard(cc);
                    }

                    out.println(paymentAgentBean.getAuthorizedCard().getDigitString() +
                            " " + paymentAgentBean.getAuthorizedCard().getCvvString());

                    if (operation_code.equals("auth_card")) {
                        paymentAgentBean.AuthorizeCardPayment(cnum, cvv);
                        if (paymentAgentBean.isAuthorizedStatus()) {
                            out.println(purchase_price + ": Authorized");
                            result = "authorized" ;
                        } else {
                            out.println(purchase_price + ": Denied");
                            result = "denied";
                        }
                    }
                }
                break ;
        }
        if ( result.equals("authorized" ))
            pageContext.forward("PaymentAuthorized.jsp") ;
        if( result.equals("denied"))
            pageContext.forward("AuthorizationDenied.jsp") ;
        else pageContext.forward("UserPaymentAuthorization.jsp"); ;
    %>
</body>
</html>
