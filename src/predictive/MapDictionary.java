package predictive;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;
import sun.security.pkcs11.wrapper.Functions;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class MapDictionary implements Dictionary {

    private String path;
    private Map <String, String> mapDictionary;

    /**
     *
     * @param path
     */
    public MapDictionary(String path){

        this.path = path;
        mapDictionary = new Hashtable<>();

        try( Scanner in = new Scanner( new File(path) ) ){

            while ( in.hasNextLine() ) {
                String word = in.nextLine();
                mapDictionary.put(PredictivePrototype.wordToSignature(word), word);
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
        return mapDictionary.forEach(m -> mapDictionary.get(m));
        ;
    }
}
