package com.harmonengineering.exceptions;

class MyExampleException extends Exception{
    String str1;
    MyExampleException(String str2) {
        str1=str2;
    }
    public String toString(){
        return ("MyExampleException Occurred: "+str1) ;
    }
}
class Example1{
    public static void main(String args[]){
        try{
            System.out.println("Starting of try block");
            // I'm throwing the custom exception using throw
            throw new MyExampleException("This is My error Message");
        }
        catch(MyExampleException exp){
            System.out.println("Catch Block") ;
            System.out.println(exp) ;
        }
    }
}
