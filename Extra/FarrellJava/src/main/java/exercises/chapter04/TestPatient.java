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
public class TestPatient
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient();
        Patient patient2 = new Patient( 5140, 42, new BloodData()) ;
        Patient patient3 = new Patient( 5150, 52, new BloodData()) ;
        patient3.getPatientBloodType().setBloodType( "AB" ) ;
        patient3.getPatientBloodType().setRhFactor( '-' ) ;

        displayPatient( patient1 , "<Patient 1>") ;
        displayPatient( patient2 , "<Patient 2>") ;
        displayPatient( patient3 ) ;
    }
    static void displayPatient(  Patient pt, String hdr )
    {
        System.out.println( hdr ) ;
        System.out.println( "ID:\t\t" + pt.getPatientID() );
        System.out.println( "Age:\t" + pt.getPatientAge() );
        System.out.print( "Blood Type:\t" ) ;
        //System.out.println( "" + pt.getPatientID() );
        TestBloodData.displayBloodData( pt.getPatientBloodType()) ;
        System.out.println() ;
    }
    static void displayPatient(  Patient pt  ) { displayPatient( pt, "" ); }
}