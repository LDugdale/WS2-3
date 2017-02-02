package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class ListDictionary implements Dictionary {

    private String path;
    private ArrayList<WordSig> dictionary;

    /**
     *
     * @param path
     */
    public ListDictionary(String path){

        this.path = path;
        dictionary = new ArrayList<WordSig>();

        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {
                String word = in.nextLine();
                WordSig w = new WordSig(word, PredictivePrototype.wordToSignature(word));
                dictionary.add(w);
            }

        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }

        Collections.sort(dictionary);
    }

    @Override
    /**
     *
     */
    public String toString() {
        StringBuffer SB = new StringBuffer();
        for (WordSig w : this.dictionary) {
            SB.append("word: " + w.getWords() + "      sig: " + w.getSignature() + "\n");
        }
        return SB.toString();
    }

    @Override
    /**
     *
     */
    public Set<String> signatureToWords(String signature) {

        // creating the hashset to return
        Set<String> words = new HashSet<>();
        // finding the position of potential word(s) using binary search
        int pos = Collections.binarySearch(dictionary, new WordSig(null, signature));
        // adding the initial result to the HashSet
        words.add(dictionary.get(pos).getWords());

        // setting counter to the original position + 1 to check for extra elements with the same signature above
        int counter = pos + 1;
        while(dictionary.get(counter).getSignature().equals(signature)){

            words.add(dictionary.get(counter).getWords());
            counter++;
        }

        // setting counter to the original position - 1 to check for extra elements with the same signature below
        counter = pos - 1;
        while (dictionary.get(counter).getSignature().equals(signature)){

            words.add(dictionary.get(counter).getWords());
            counter--;
        }

        return words;
    }

//    static <WordSig> int binarySearch(List<WordSig> list, String T){
//        Collections.binarySearch(list, T);
//    }


}
