package ApplicationControllerPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class APCmain {

    // for reading inputs and print to console
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter cons = new PrintWriter(System.out, true);

    public static void runAPC() {

        try {
            cons.println("\nEnter a word of your choice: ");
            String word = input.readLine();

            cons.println("\nSelect an action to perform from the list below: "
                        + "\n1 - count characters in the word"
                        + "\n2 - count vowels in the word"
                        + "\n3 - count consonants in the word");
            String action = input.readLine();

            // pass inputs to controller
            Controller controller = new Controller();
            controller.delegate(word,action);

            System.out.println("\nGoing back to the main selection menu...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
