
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .color-border
        {
            border-style: solid;
            border-color: black;
            border-width: 2px ;
            width: 50ch ;
            padding-left: 5pt;
        }
        input { width: 12ch;}
    </style>
    <title>User Payment</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
    <h1>$${bookingBean.totalPrice}</h1>
    <div class="color-border">
    <form name="paypal_form" method="get">
        <h2> Paypal</h2>
        <jsp:text>Account: $${paymentAgentBean.payPalAccountValue}</jsp:text><br>
        <label for="paypal_amount"> Amount:</label>
        <input id="paypal_amount" name="paypal_amount" value="100.00" type="number">
            <button type="submit" name="op" value="paypal_load"
                    formaction="doPaymentUpdate.jsp" >Load Account</button>
            <br>
            <button type="submit" name="op" value="paypal_auth"
                    formaction="doPaymentUpdate.jsp" >Pay with PayPal</button>
    </form></div>
    <div class="color-border">
    <form name="card_form" method="get">
        <h2>Card Payment</h2>
        <label for="card_numbers">numbers</label>
        <div id="card_numbers" name="card_numbers">
            <input id="cnum_one" name="cnum_one" type="text">-
            <input id="cnum_two" name="cnum_two" type="text">-
            <input id="cnum_three" name="cnum_three" type="text">-
            <input id="cnum_four" name="cnum_four" type="text">
        </div><br>
        <label for="cnum_cvv">CVV</label>
        <input id="cnum_cvv" name="cnum_cvv" type="text"><br>
        <jsp:text>
            Valid card:
            ${paymentAgentBean.authorizedCard.digitString}
            ${paymentAgentBean.authorizedCard.cvvString }
        </jsp:text><br>
        <button type="submit" formaction="doPaymentUpdate.jsp"
                name="op" value="auth_card">Pay with Card</button>
        <button type="submit" formaction="doPaymentUpdate.jsp"
                name="op" value="set_card">Set as Valid Card</button>

    </form>
    </div>
</body>
</html>
