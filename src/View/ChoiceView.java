package View;

import MVC.MVCStart;
import Threads.Executy;

public class ChoiceView extends View {

    public ChoiceView() {
    }

    @Override
    protected String getMessage() {

        return "\nCoding Topics\n"
               + "-------------\n"
               + "1 - Collections\n"
               + "2 - Threads, Runnables, Executors & Atomic variables\n"
               + "3 - Model, View, Control\n"
               + "0 - Quit";
    }

    @Override
    protected String[] getInputs() {
        String[] inputs = new String[1];

        inputs[0] = getUserInput("\nEnter a number to select a Coding Topic:");

        return inputs;
    }

    @Override
    protected boolean doAction(String[] inputs) {

        switch ( inputs[0].trim().toUpperCase() ) {
            case "0":
                return false;
            case "1":
                viewCollection();
                break;
            case "2":
                Executy.entryPoint();
                break;
            case "3":
                MVCStart.planetDB();
                break;
            default:
                System.out.println("\nInvalid selection. Please, try again.");
        }
        return true;
    }

    private void viewCollection(){

        View view = new CollectionView();
        view.displayView();
    }
}
