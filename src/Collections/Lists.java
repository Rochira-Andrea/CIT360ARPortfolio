package Collections;

import java.util.*;

public class Lists {

    public static void showListImplementations() {

        List<Double> celsiusTemp = new ArrayList<>();

        System.out.println("\n*********** SOME BASIC OPERATIONS ***********\n");

        // Adding some Double values to the collection (auto-boxing)
        celsiusTemp.add(36.50);
        celsiusTemp.add(100.00);
        celsiusTemp.add(0.00);
        celsiusTemp.add(-273.15);
        celsiusTemp.add(81.17);
        celsiusTemp.add(15.09);

        System.out.println("Here is a list of " + celsiusTemp.size() + " Celsius degree temperatures\n");
        // navigating through the list with an advanced for loop
        for (Double d : celsiusTemp)
            System.out.println(d+"\u00B0 Celsius");

        // removing one item and shuffling the rest
        System.out.println("\nRemove the third entry and display again all items with their index\n");
        celsiusTemp.remove(2);
        for (Double d : celsiusTemp)
            System.out.println(d+"\u00B0 Celsius has index of " + celsiusTemp.indexOf(d));

        System.out.println("\n*********** SOME RANGE OPERATIONS ***********\n");

        System.out.println("Display from the second to the fourth entry\n");
        List<Double> range = celsiusTemp.subList(1,4);
        for (Double d : range)
            System.out.println(d+"\u00B0 Celsius");

        System.out.println("\n\n********** END OF LIST IMPLEMENTATION EXAMPLES **********\n");
    }

}
