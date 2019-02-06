package ApplicationControllerPattern;

public class CountConsonants implements Action {

    @Override
    public void action(String word){

        System.out.println("\nYou have chosen to count the consonants in the word: "+word);

        int countVowels = 0;

        // count the vowels
        for (int j = 0; j < word.length(); j++) {
            if (word.toLowerCase().charAt(j) == 'a' || word.toLowerCase().charAt(j) == 'e' || word.toLowerCase().charAt(j) == 'i'
                    || word.toLowerCase().charAt(j) == 'o' || word.toLowerCase().charAt(j) == 'u') {
                countVowels++;
            }
        }

        int countConsonants = word.length() - countVowels;
        System.out.println("\nThe number of consonants is: "+countConsonants);
    }

}
