package ApplicationControllerPattern;

public class CountChars implements Action {

    @Override
    public void action(String word){

        System.out.println("\nYou have chosen to count the letters in the word: "+word);

        int count = word.length();

        System.out.println("\nThe number of characters is: "+count+"\n");
    }
}
