package debug_exercises.chapter02;

import javax.swing.*;

public class fixDebugTwo4
{
   public static void main(String[] args)
   {
      String costString; // type string not String --fixed B>S>H> 7/7/2022
      double cost;
      final double TAX = 0.06; // final declard but missing data type --fixed B>S>H> 7/7/2022
      costString = JOptionPane.showInputDialog(null,
         "Enter price of item you are buying", "Purchases",
         JOptionPane.INFORMATION_MESSAGE); // missing import for javax.swing --fixed B>S>H> 7/7/2022
      cost = Double.parseDouble(costString); // parsedouble instead of parseDouble --fixed B>S>H> 7/7/2022
                                             // also mistyped coststring -> costString --fixed B>S>H> 7/7/2022

      // JOption pane missing first arg --fixed B>S>H> 7/7/2022
      JOptionPane.showMessageDialog(null, "With " + TAX * 100 +
         "% tax,  purchase  is $" + (cost + (cost * TAX))); // java interpret + op as string op --fixed B>S>H> 7/7/2022
   }
}

