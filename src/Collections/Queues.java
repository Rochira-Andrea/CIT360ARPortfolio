package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    public static void showQueueImplementations(){

        Queue<String> printQueue = new LinkedList<>();

        System.out.println("\n*********** SOME BASIC OPERATIONS ***********\n");

        printQueue.add("Job 1");
        printQueue.add("Job 2");
        printQueue.add("Job 3");
        printQueue.add("Job 4");
        printQueue.add("Job 5");

        // navigating through the queue
        System.out.println("Here is a queue of print jobs\n");
        for (String job : printQueue)
            System.out.println(job);

        // Let's iterate through the queue until the last job is printed
        System.out.println("\nShow me the print queue every time the first item is removed\n");

        for (int i = printQueue.size(); i >= 0; i--) {

            for (String job : printQueue)
                System.out.println(job);

            if (!printQueue.isEmpty()) {
                printQueue.remove();
            }

            System.out.println(" ");
        }


        System.out.println("\n********** END OF QUEUE IMPLEMENTATION EXAMPLES **********\n");
    }
}
