package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class ListDictionary implements Dictionary {

    private String path;

    public ListDictionary(String path){
        this.path = path;
        ArrayList<WordSig> dictionary = new ArrayList<>();
        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {
                String word = in.nextLine();
                WordSig w = new WordSig(PredictivePrototype.wordToSignature(word),word);

                dictionary.add(w);

            }

        } catch(IOException e){
            System.err.println("Got an IOException: " + e.getMessage());
        }

        //Collections.sort(dictionary);
    }


    @Override
    public Set<String> signatureToWords(String signature) {
        // use binary search here
        return null;
    }
}
