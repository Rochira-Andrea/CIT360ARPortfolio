package View;

import URLConnection.URLmain;

public class URLview extends View {

    @Override
    protected String getMessage() {

        return "\nURL and Http Connections\n"
                + "-----------\n"
                + "1 - Display the markup and the content of the web page \"http://example.org\"\n"
                + "2 - Get status information of the web page \"http://example.org\"\n"
                + "3 - Look up if the content \"http://example.org/subpage.html\" is available\n"
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
                URLmain.simpleURL();
                break;
            case "2":
                URLmain.URLhttp();
                break;
            case "3":
                URLmain.URLhttpNotFound();
                break;
            default:
                System.out.println("\nInvalid selection. Please, try again.");
        }
        return true;
    }
}
