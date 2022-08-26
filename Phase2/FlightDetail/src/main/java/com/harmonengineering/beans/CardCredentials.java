package com.harmonengineering.beans;
public class CardCredentials
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
