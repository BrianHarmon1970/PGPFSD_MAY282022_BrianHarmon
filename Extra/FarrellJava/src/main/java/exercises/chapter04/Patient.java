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
        to 0, and the BloodData values to O and +. Create an overloaded constructor
        that provides values for each field. Also provide get methods for each field.
        Save the file as Patient.java. Create an application that demonstrates that
        each method works correctly, and save it as TestPatient.java.
*/
public class Patient
{
    private int         PatientID ;
    private int         PatientAge ;
    private BloodData   PatientBloodType ;

    public Patient()
    {
        PatientID = 0 ;
        PatientAge = 0 ;
        PatientBloodType = new BloodData( ) ;
        PatientBloodType.setBloodType( "O" );
        PatientBloodType.setRhFactor( '+' ) ;
    }
    public Patient( int patient_id , int patient_age, BloodData patient_bloodtype )
    {
        PatientID = patient_id ;
        PatientAge = patient_age ;
        PatientBloodType = patient_bloodtype ;
    }
    public void setPatientID(int patientID) { PatientID = patientID; }
    public void setPatientAge(int patientAge) { PatientAge = patientAge; }
    public void setPatientBloodType(BloodData patientBloodType) { PatientBloodType = patientBloodType; }

    public int getPatientID() { return PatientID; }
    public int getPatientAge() { return PatientAge; }
    public BloodData getPatientBloodType() { return PatientBloodType; }
}
