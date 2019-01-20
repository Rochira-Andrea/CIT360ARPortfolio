package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

    public static void showMapImplementations(){

        Map<String, String> languHashes = new HashMap<>();

        System.out.println("\n*********** SOME BASIC OPERATIONS ***********\n");

        languHashes.put("HTML","Hypertext Markup Language");
        languHashes.put("CSS","Cascading Style Sheets");
        languHashes.put("XML", "Extensible Markup Language");
        languHashes.put("JSON","JavaScript Object Notation");
        languHashes.put("AJAX","Asynchronous JavaScript and XML");

        System.out.println("Here is a HashMap collection of languages and their meaning\n");
        for(String key : languHashes.keySet()){
            System.out.println(key + " stands for " + languHashes.get(key));
        }

        System.out.println("\nRemoving XML from the collection and sorting by using a TreeMap\n");
        languHashes.remove("XML");

        Map<String, String> langTree = new TreeMap<>();
        langTree.putAll(languHashes);

        for(String key : langTree.keySet()){
            System.out.println(key + " stands for " + langTree.get(key));
        }


        System.out.println("\n\n********** END OF MAP IMPLEMENTATION EXAMPLES **********\n");
    }
}
