package Collections;

import java.util.*;

public class Sets {

    public static void showSetImplementations() {

        Set<String> cards = new HashSet<>();

        System.out.println("\n*********** SOME BASIC OPERATIONS ***********\n");

        // Adding elements to the set using add()
        cards.add("Ten");
        cards.add("Jack");
        cards.add("Queen");
        cards.add("King");
        cards.add("Ace");

        // Adding duplicate elements will be ignored
        cards.add("King");

        // Display the set items
        System.out.println("Here is our HashSet collection");
        System.out.println(cards + "\n");

        // Removing items from the set using remove()
        cards.remove("Ace");
        System.out.println("Collection after removing Joker:\n"+cards+"\n");

        // Looking for a specific item
        System.out.println("Collection contains a Joker card: " +
                cards.contains("Joker"));

        // Navigating through hash set items
        System.out.println("\nNavigating through the collection:");
        for (String card : cards)
            System.out.println(card);

        // same result but using Iterator class
        /*Iterator<String> i = cards.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        */

        System.out.println("\n*********** SOME BULK OPERATIONS ***********\n");

        // Sorting the HashSet by adding its items to a TreeSet
        Set<String> sortedCards = new TreeSet<>();
        sortedCards.addAll(cards);

        System.out.println("Here is a TreeSet collection (items are automatically sorted)");
        System.out.println(sortedCards);

        System.out.println("\nHere is another TreeSet collection");
        Set<String> randomCards = new TreeSet<>();
        randomCards.add("Queen");
        randomCards.add("Jack");
        randomCards.add("Nine");
        randomCards.add("Seven");
        System.out.println(randomCards);

        System.out.println("\nHere we have a destructive set-difference");
        // removing from sortedCards the items in common with randomCards
        sortedCards.removeAll(randomCards);
        for (String card : sortedCards)
            System.out.println(card);


        System.out.println("\n\n********** END OF SET IMPLEMENTATION EXAMPLES **********\n");


    }
}
