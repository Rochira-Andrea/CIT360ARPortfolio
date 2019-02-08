package View;

import JSON.JSONmain;

public class JASONview extends View {

    @Override
    protected String getMessage() {

        return "\nJSON Parsing\n"
                + "-----------\n"
                + "1 - Serialization of a Java collection\n"
                + "2 - Deserialization of a collection of objects from a JSON source file\n"
                + "0 - Go back and choose another coding topic";
    }

    @Override
    protected String[] getInputs() {
        String[] inputs = new String[1];

        inputs[0] = getUserInput("\nSelect an action to perform:");

        return inputs;
    }

    @Override
    protected boolean doAction(String[] inputs) {
        switch ( inputs[0].trim().toUpperCase() ) {
            case "0":
                return false;
            case "1":
                JSONmain.JavaToJSON();
                break;
            case "2":
                JSONmain.JSONtoJava();
                break;
            default:
                System.out.println("\nInvalid selection. Please, try again.");
        }
        return true;
    }
}
