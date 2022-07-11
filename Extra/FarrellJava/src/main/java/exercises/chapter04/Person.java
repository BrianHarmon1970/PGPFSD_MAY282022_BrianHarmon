package exercises.chapter04;

import java.time.LocalDate;

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
public class Person {
    private final String FirstName;
    private final String LastName;
    private final LocalDate DateOfBirth;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = birthDate;
    }

    public String getFirstName() { return FirstName; }
    public String getLastName() { return LastName; }
    public LocalDate getDateOfBirth() { return DateOfBirth; }
}
