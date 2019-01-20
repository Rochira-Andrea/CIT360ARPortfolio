package View;

import Collections.*;

public class CollectionView extends View {

    @Override
    protected String getMessage() {

        return "\nCollection Interfaces\n"
                + "-------------\n"
                + "1 - Set\n"
                + "2 - List\n"
                + "3 - Queue\n"
                + "4 - Deque\n"
                + "5 - Map\n"
                + "0 - Go back and choose another coding topic";
    }

    @Override
    protected String[] getInputs() {
        String[] inputs = new String[1];

        inputs[0] = getUserInput("\nEnter a number to display a corresponding collection implementation:");

        return inputs;
    }

    @Override
    protected boolean doAction(String[] inputs) {

        switch ( inputs[0].trim().toUpperCase() ) {
            case "0":
                return false;
            case "1":
                Sets.showSetImplementations();
                break;
            case "2":
                Lists.showListImplementations();
                break;
            case "3":
                Queues.showQueueImplementations();
                break;
            case "4":
                Deques.showDequeImplementations();
                break;
            case "5":
                Maps.showMapImplementations();
                break;
            default:
                System.out.println("\nInvalid selection. Please, try again.");
        }
        return true;
    }

}
