package exercises.chapter04;
/*

4.  a.  Create a class named BloodData that include fields that hold a blood type
        (the four blood types are O, A, B and AB)( and an Rh factor (the factors are
        + and -). Create a default constructor that sets the fields to O and +, and
        an overloaded constructor that requires values for both fields. Include get
        and set methods for each field. Save this file Aas BloodData.java. Create an
        application named TestBloodData that demonstrates each method works correctly.
        Save the application as TestBloodData.java.

    b.  Create a class named Patient that includes an ID number, age and
        BloodData. Provide a default constructor that sets the ID number to 0, the age
        to 0, and the BBloodData values to O and +. Create an overloaded constructor
        that provides values for each field. Also provide get methods for each field.
        Save the file as Patient.java. Create an application that demonstrates that
        each method works correctly, and save it as TestPatient.java.

 */
public class BloodData
{

    private String BloodType ;
    private char rhFactor ;

    public BloodData( )
    {
        BloodType = "O" ;
        rhFactor = '+' ;
    }
    public void setBloodType( String bloodType) { BloodType = bloodType; }
    public void setRhFactor(char rhFactor) { this.rhFactor = rhFactor; }

    public String getBloodType() { return BloodType; }
    public char getRhFactor() { return rhFactor; }
}
