package Collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Deques {

    public static void showDequeImplementations(){

        Deque<Character> letters = new ArrayDeque<>();

        System.out.println("\n*********** SOME BASIC OPERATIONS ***********\n");

        // filling the collection
        letters.add('A');
        letters.add('B');
        letters.add('C');
        letters.add('D');
        letters.add('E');
        letters.add('F');
        letters.add('G');
        letters.add('H');

        System.out.println("Here is a collection of "+letters.size()+" characters\n");
        for(Character c : letters)
            System.out.println(c);

        // removing first and last items, then show the collection in inverted order
        System.out.println("\nInvert the items' order after removing the first and last entry\n");
        letters.removeFirst();
        letters.removeLast();
        for (Iterator ity = letters.descendingIterator(); ity.hasNext(); )
            System.out.println(ity.next());


        System.out.println("\n\n********** END OF DEQUE IMPLEMENTATION EXAMPLES **********\n");

    }
}
