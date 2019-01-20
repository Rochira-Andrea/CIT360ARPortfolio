package Collections;

import java.util.HashSet;
import java.util.Iterator;

public class Set {

    public static void showSetImplementations() {

        java.util.Set<String> cards = new HashSet<>();

        System.out.println("********** BASIC OPERATIONS *********\n");

        // Adding elements into HashSet using add()
        cards.add("Jack");
        cards.add("Queen");
        cards.add("King");
        cards.add("Joker");

        // Adding duplicate elements will be ignored
        cards.add("King");

        // Display the hash set items
        System.out.println("Here is our HashSet collection");
        System.out.println(cards + "\n");

        // Removing items from HashSet using remove()
        cards.remove("Joker");
        System.out.println("Collection after removing Joker:\n"+cards+"\n");

        //
        System.out.println("Collection contains an Ace card: " +
                cards.contains("Ace"));

        // Navigating through hash set items
        System.out.println("\nNavigating through the collection:");
        Iterator<String> i = cards.iterator();
        while (i.hasNext())
            System.out.println(i.next());

    }
}
