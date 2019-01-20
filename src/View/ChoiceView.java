package View;

public class ChoiceView extends View {

    public ChoiceView() {
    }

    @Override
    protected String getMessage() {

        return "\nCoding Topics\n"
               + "-------------\n"
               + "1 - Collections\n"
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
