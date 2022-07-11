package exercises.chapter04;
/*
11. Create a class named Person that holds the following fields: two String objects
    for the Person's first and last name and a LocalDate object for the Person's
    birthdate. Create a class named Couple that contains two Person objects. Creat a
    class named Wedding for a wedding planner that includes the date of the wedding
    the names of the Couple being married and a String for the location. Provide
    constructors for each class that accept parameters for each field, and provide get
    methods for each field. Then write a program that creates two Wedding objects
    and in turn passes each to a method that displays all the details.Save the files as
    Person.java, Couple.java, Wedding.java and TestWedding.java.
 */
public class Couple
{
    private final Person Man ;
    private final Person Woman ;

    public Couple( Person Man, Person Woman )
    {
        this.Man = Man ;
        this.Woman = Woman ;
    }

    public Person getMan() { return Man; }
    public Person getWoman() { return Woman; }
}
