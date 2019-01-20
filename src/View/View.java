package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public abstract class View {

    // Empty constructor
    public View(){
    }

    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    protected static PrintWriter console = new PrintWriter(System.out, true);

    protected abstract String getMessage();

    protected abstract String[] getInputs();

    protected abstract boolean doAction(String[] inputs);

    public void displayView(){

        boolean keepGoing = true;

        while (keepGoing) {

            String message = getMessage();
            if (message != null) {
                console.println(getMessage());
            }

            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    protected String getUserInput(String prompt, boolean allowEmpty){

        String input = "";

        boolean inputReceived = false;

        try {
            while(!inputReceived){

                console.println(prompt);
                input = keyboard.readLine();

                // Make sure we avoid a null-pointer error
                if (input == null){
                    input = "";
                }

                // Trim any trailing whitespace, including the carriage return
                input = input.trim();

                if (!input.equals("") || !allowEmpty){
                    inputReceived = true;
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return input;
    }

    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }

}
