package ApplicationControllerPattern;

public class CountVowels implements Action {

    @Override
    public void action(String word){

        System.out.println("\nYou have chosen to count the vowels in the word: "+word);

        int counter = 0;

        // iterate through the string and count just the vowels
        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) == 'a' || word.toLowerCase().charAt(i) == 'e' || word.toLowerCase().charAt(i) == 'i'
                    || word.toLowerCase().charAt(i) == 'o' || word.toLowerCase().charAt(i) == 'u') {
                counter++;
            }
        }

        System.out.println("\nThe number of vowels is: "+counter);
    }
}
