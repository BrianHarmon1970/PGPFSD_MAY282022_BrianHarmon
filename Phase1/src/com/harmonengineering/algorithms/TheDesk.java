import java.util.*;

public class TheDesk {

    static ArrayList<Double> expenses;
    static Scanner sc;

    public static void main(String[] args) {
        expenses = new ArrayList<Double>();
        expenses.add(1000.00);
        expenses.add(2300.00);
        expenses.add(45000.00);
        expenses.add(32000.00);
        expenses.add(110.00);

        sc = new Scanner(System.in);
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        while ( optionsSelection());
    }
    private static boolean optionsSelection() {
        boolean return_value = true ;
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        //int[] arr1 = {1, 2, 3, 4, 5, 6};
        int slen = arr.length;
        for (int i = 0; i < slen; i++) {
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        //ArrayList<Integer> arrlist = new ArrayList<Integer>();
        //expenses.addAll(arrlist);
        System.out.println("\nEnter your choice:\t");
        //System.out.print("Enter>");
        int options = validateNextInt(sc, "Enter>" , slen);
        //   for (int j = 1; j <= slen; j++) {
        //       if (options == j) {
        switch (options) {
            case 1:
                System.out.println("Your saved expenses are listed below: \n");
                System.out.println(expenses + "\n");
                //optionsSelection();
                break;
            case 2:
                System.out.println("Enter the value to add your Expense: \n");
                Double value = validateNextDouble( sc , "Enter>" ) ;
                expenses.add(value);
                System.out.println("Your value is updated\n");
                //expenses.addAll(arrlist);
                System.out.println(expenses + "\n");
                //optionsSelection();
                break;
            case 3:
                System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                int con_choice = validateNextInt( sc, "Enter>", 10000 ) ;
                if (con_choice == options) {
                    expenses.clear();
                    System.out.println(expenses + "\n");
                    System.out.println("All your expenses are erased!\n");
                } else {
                    System.out.println("Oops... try again!");
                }
                //optionsSelection();
                break;
            case 4:
                sortExpenses(expenses);
                //optionsSelection();
                break;
            case 5:
                searchExpenses(expenses);
                //optionsSelection();
                break;
            case 6:
                closeApp();
                return_value = false ;
                break;
            default:
                System.out.println("You have somehow made an invalid choice!");
                //optionsSelection();
                break;
        }
        return return_value ;
    }
    private static int validateNextInt(Scanner sc, String prompt, int maxInt)
    {
        int return_val = 0  ;
        boolean valid = false ;
        while( !valid )
        {
            try
            {
                System.out.print( prompt ) ;
                return_val = sc.nextInt() ;
                if ((return_val >= 0 ) && ( return_val <= maxInt ))
                    valid = true;
            } catch (InputMismatchException ignored) { sc.next() ; }
        }
        return return_val ;
    }
    private static Double validateNextDouble( Scanner sc, String prompt )
    {
        Double return_val = 0.0  ;
        boolean valid = false ;
        while( !valid )
        {
            try
            {
                System.out.print( prompt ) ;
                return_val = sc.nextDouble() ;
                valid = true ;
            } catch (InputMismatchException ignored){ sc.next() ; }
        }
        return return_val ;
    }
    private static void closeApp()
    {
        System.out.println("Closing your application... \nThank you!");
    }
    private static void searchExpenses(ArrayList<Double> arrayList)
    {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        //Complete the method
        //System.out.print( "Enter>" ) ;
        Double key = validateNextDouble( sc , "Enter>" ) ;
        boolean found = false ;
        for( int i = 0 ; i < leng ; ++i )
        {
            if (Objects.equals(arrayList.get(i), key))
            {
                System.out.println( " value found at index: " + i ) ;
                found = true ;
                break ;
            }
        }
        if ( !found )
            System.out.println( "value not found" ) ;
    }
    private static void sortExpenses(ArrayList<Double> arrayList) {
        int arrlength =  arrayList.size();
        //Complete the method. The expenses should be sorted in ascending order.
        arrayList.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if ( o1 < o2 )
                    return -1 ;
                if ( o1 > o2 )
                    return 1 ;
                return 0;
            }
        }) ;
        System.out.println("Your sorted expenses are listed below: \n");
        System.out.println(expenses+"\n");
    }
}
