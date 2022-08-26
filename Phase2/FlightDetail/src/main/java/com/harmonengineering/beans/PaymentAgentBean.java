package com.harmonengineering.beans;

public class PaymentAgentBean
{
    private Double  PayPalAccountValue ;
    private CardCredentials authorizedCard ;
    private boolean authorizedStatus ;

    public PaymentAgentBean()
    {
        CardCredentials cc = new CardCredentials();
        cc.setDigitString("1111222233334444");
        cc.setCvvString("000");
        this.setAuthorizedCard(cc);
        PayPalAccountValue = 10000.00d ;
    }

    public void setPayPalAccountValue( Double payPalAccountValue)
        { this.PayPalAccountValue = payPalAccountValue; }
    public void setAuthorizedCard(CardCredentials authorizedCard)
        { this.authorizedCard = authorizedCard; }
    public void setAuthorizedStatus(boolean authorizedStatus)
        {  this.authorizedStatus = authorizedStatus;  }

    public Double getPayPalAccountValue()  {  return PayPalAccountValue;  }
    public CardCredentials getAuthorizedCard() { return authorizedCard; }
    public boolean isAuthorizedStatus() { return authorizedStatus; }

    public void AuthorizePayPalPayment( Double amount )
    {
        if (PayPalAccountValue >= amount)
        {
            PayPalAccountValue -= amount;
            authorizedStatus = true;
        } else authorizedStatus = false ;
    }
    public void AuthorizeCardPayment( String cardNumber, String CVVCodeString)
    {
        AuthorizeCardPayment( new CardCredentials( cardNumber, CVVCodeString ));
    }
    public void AuthorizeCardPayment( CardCredentials cardCredentials )
    {
        if((cardCredentials.getDigitString().equals( authorizedCard.getDigitString())) &&
                (cardCredentials.getCvvString().equals( authorizedCard.getCvvString())) )
        {
            authorizedStatus = true ;
        } else authorizedStatus = false ;
    }
}
