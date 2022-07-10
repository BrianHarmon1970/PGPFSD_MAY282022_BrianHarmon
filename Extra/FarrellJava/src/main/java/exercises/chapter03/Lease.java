package exercises.chapter03;
/*
13. a.  Create a class named Lease with fields that hold an apartment tenant's name,
        apartment number, monthly rent amount, and term of the lease in months.
        Include a constructor that initializes the name to "XXX", the apartment
        number to 0, the rent to 1000, and the term to 12. Also include methods to
        get and set each of the fields. Include a nonstatic method named addPetFee()
        that adds $10 to the monthly rent value and calls a static method named
        explainPetPolicy() that explains the pet fee. Save the class as Lease.java.

    b.  Create a class named TestLease who's main() method declares four Lease
        objects. Call a getData() method three times. Within the method, prompt a
        user for values for each field for a Lease, and return aLease object to the main()
        method where it is assigned to one of main()'s Lease objects. Do not prompt the
        user for values for the fourth Lease object, but let it continue to hold the default
        values. Then in main(), pass one of the Lease objects to a shoeValues() method
        that displays the data. Then call the addPetFee() method using the passed Lease
        object and confirm that the fee explanation statement is displayed. Next, call the
        showValues method for the Lease object again and confirm that th pet fee has
        been added to the rent. Finally, call the showValues() method with each of the
        other three objects, confirm that two hold the values you supplied as input and
        one holds the constructor default values. Save the application as TestLease.java.
 */
public class Lease
{
        static final double PET_FEE = 10.00 ;
        private String  tenantName ;
        private int     apartmentNumber ;
        private double  monthlyRentAmount ;
        private int     leaseTerm ;

        public Lease()
        {
                tenantName = "XXXX" ;
                apartmentNumber = 0 ;
                monthlyRentAmount = 1000.00 ;
                leaseTerm = 12 ;
        }
        public void addPetFee()
        {
                monthlyRentAmount += PET_FEE ;
                explainPetPolicy();
        }
        public static void explainPetPolicy()
        {
                System.out.println( "$"+PET_FEE+ " pet fee added to monthly rental amount" ) ;
        }
        public void setTenantName(String tenantName) { this.tenantName = tenantName; }
        public void setApartmentNumber(int apartmentNumber) { this.apartmentNumber = apartmentNumber; }
        public void setMonthlyRentAmount(double monthlyRentAmount) { this.monthlyRentAmount = monthlyRentAmount; }
        public void setLeaseTerm(int leaseTerm) { this.leaseTerm = leaseTerm; }

        public String getTenantName() { return tenantName; }
        public int getApartmentNumber() { return apartmentNumber; }
        public double getMonthlyRentAmount() { return monthlyRentAmount; }
        public int getLeaseTerm() { return leaseTerm; }
}
