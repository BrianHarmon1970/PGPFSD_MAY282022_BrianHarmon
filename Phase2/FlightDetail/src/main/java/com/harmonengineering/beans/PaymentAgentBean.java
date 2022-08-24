package com.harmonengineering.beans;

class CardCredentials
{
    private String digitString ;
    private String cvvString ;

    public CardCredentials() {}
    public CardCredentials( String digitString, String cvvString  )
    {
        this.digitString = digitString ;
        this.cvvString = cvvString ;
    }
    public String getDigitString() { return digitString; }
    public String getCvvString() { return cvvString;  }

    public void setDigitString(String digitString) { this.digitString = digitString; }
    public void setCvvString(String cvvString) { this.cvvString = cvvString;  }

}
public class PaymentAgentBean
{
    private double  PayPalAccountValue ;
    private CardCredentials authorizedCard ;
    private boolean authorizedStatus ;

    public PaymentAgentBean() {}

    public void setPayPalAccountValue(double payPalAccountValue)
        { PayPalAccountValue = payPalAccountValue;    }
    public void setAuthorizedCard(CardCredentials authorizedCard)
        { this.authorizedCard = authorizedCard; }
    public void setAuthorizedStatus(boolean authorizedStatus)
        {  this.authorizedStatus = authorizedStatus;  }

    public double getPayPalAccountValue()  {  return PayPalAccountValue;  }
    public CardCredentials getAuthorizedCard() { return authorizedCard; }
    public boolean isAuthorizedStatus() { return authorizedStatus; }

    public void AuthorizePayPalPayment( double amount )
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
