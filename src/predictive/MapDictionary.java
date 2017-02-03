package predictive;
import javafx.scene.control.Tab;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class MapDictionary implements Dictionary {

    private String path;
    private Map <String, Set<String>> mapDictionary;

    /**
     *
     * @param path
     */
    public MapDictionary(String path){

        this.path = path;
        mapDictionary = new TreeMap<>();

        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {

                String word = in.nextLine();
                mapDictionary.computeIfAbsent(PredictivePrototype.wordToSignature(word),k -> new HashSet<String>()).add(word);
            }

        } catch(IOException e){

            System.err.println("Got an IOException: " + e.getMessage());
        }
    }



    @Override
    /**
     *
     */
    public Set<String> signatureToWords(String signature) {

        Set<String> results = new HashSet<>();
        mapDictionary.forEach((s, v) -> results.addAll(v));

        for (Map.Entry<String, Set<String>> key : mapDictionary.entrySet()) {
            if(key.getKey().equals(signature)){
                results.addAll(key.getValue());
            }
        }
        return results;
    }


    /**
     *
     */
    public String toString() {
        return mapDictionary.toString();
    }
}
