package debug_exercises.chapter02;

public class fixDebugTwo1
{
    public static void main(String[] args)
    {
        int oneInt = 315; // invalid data type decl - integer --fixed B>S>H> 7/7/2022
        double oneDouble = 12.4;
        char oneChar = 'A';// invalid data type decl - character --fixed B>S>H> 7/7/2022
        System.out.print("The int is ");
        System.out.println(oneInt); // oneint -> oneInt typo --fixed B>S>H> 7/7/2022
        System.out.print("The double is ");
        System.out.println(oneDouble); // onDouble - oneDouble type --fixed B>S>H> 7/7/2022
        System.out.print("The char is ");
        System.out.println(oneChar);
    }
}
