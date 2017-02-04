package predictive;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 2 Storing and searching a dictionary(20%)
 *
 * @Author Laurie Dugdale
 */
public class ListDictionary implements Dictionary {

    private List<WordSig> listDictionary; // Stores all the contents of the dictionary file

    /**
     * Constructor for the ListDictionary class.
     *
     * This constructor accepts a String representing the path to the dictionary file. When the class is instantiated
     * all the valid words ( words only containing letters of the alphabet ) in the file are added to an ArrayList.
     *
     * @param path A string representing the path to the required dictionary file.
     */
    public ListDictionary(String path){

        // Initializing the ArrayList
        listDictionary = new ArrayList<>();
        String word;

        // read in the file -- scanner is inside "try with resources" as it explicitly closes
        try( Scanner in = new Scanner( new File(path) ) ){

            // while there is a next line
            while ( in.hasNextLine() ) {

                // check if current word is valid
                if(!isValidWord(word = in.nextLine())) {
                    continue;
                }
                word = word.toLowerCase();
                listDictionary.add(new WordSig(word, PredictivePrototype.wordToSignature(word)));
            }

        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }

        // sort the collection
        Collections.sort(listDictionary);
    }

    @Override
    /**
     * To string method
     * Created this to help with testing.
     *
     * @return a String containing containing a list of all the words and signatures.
     */
    public String toString() {

        StringBuffer SB = new StringBuffer();
        for (WordSig w : this.listDictionary) {
            SB.append(w.getWords() + " : " + w.getSignature() + "\n");
        }
        return SB.toString();
    }

    @Override
    /**
     * signatureToWords accepts a String containing numbers as a parameter representing a signature to be matched to
     * a word in the dictionary LinkedList ( e.g. if a number in the string is 2 it will be matched to "abc" ).
     * A set of all the Strings that are matched to the signature are returned.
     *
     * @param signature String of numbers representing the numbers on a keypad used for a t9 texting system
     * @return Set of Strings containing the matched words from the "words" file in the directory.
     */
    public Set<String> signatureToWords(String signature) {

        // check if signature contains only the accepted characters ( 2 <= c => 9 )
        if(!isValidSignature(signature)){

            throw new IllegalArgumentException("The range of characters in the signature must be 2 <= c => 9 ");
        }

        // creating the hashset to return
        Set<String> words = new HashSet<>();
        // finding the position of potential word(s) using binary search
        int pos = Collections.binarySearch(listDictionary, new WordSig(null, signature));
        // adding the initial result to the HashSet
         words.add(listDictionary.get(pos).getWords());

        // setting counter to the original position + 1 to check for extra elements with the same signature above
        int counter = pos + 1;
        while(counter < listDictionary.size() -1 && listDictionary.get(counter).getSignature().equals(signature)){

            words.add(listDictionary.get(counter).getWords());
            counter++;
        }

        // setting counter to the original position - 1 to check for extra elements with the same signature below
        counter = pos - 1;
        while (counter >= 0 && listDictionary.get(counter).getSignature().equals(signature)){

            words.add(listDictionary.get(counter).getWords());
            counter--;
        }

        return words;
    }

    /**
     * isValidWord checks if a given String contains only chars including and between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length.
     * @return boolean true if all chars are including and between a - z and A - Z
     */
    private static boolean isValidWord(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * isValidWord checks if a given String contains only chars including and between a - z and A - Z.
     * if another char is found method returns false else it returns true.
     *
     * @param word String of any length.
     * @return boolean true if all chars are including and between a - z and A - Z
     */
    private static boolean isValidSignature(String word){

        // loop through the chars in the String word
        for (char c : word.toCharArray()) {
            // if char is not between a-z and A-Z return false
            if(c >= '2' && c <= '9') {
                return true;
            }
        }

        return false;
    }
}
