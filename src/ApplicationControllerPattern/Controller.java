package ApplicationControllerPattern;

import java.util.HashMap;

public class Controller {

    public Controller() {
    }

    private HashMap<String,Action> actionMap = new HashMap<>();

    public void delegate(String word, String action){

        switch (action) {
            case "1":
                actionMap.put(action, new CountChars());
                break;
            case "2":
                actionMap.put(action, new CountVowels());
                break;
            case "3":
                actionMap.put(action,new CountConsonants());
                break;
        }

        actionMap.get(action).action(word);

    }
}
