package predictive;

import java.util.Comparator;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class WordSig implements Comparable<WordSig> {

    private String words;
    private String signature;

    /**
     *
     * @return
     */
    public String getWords() {
        return words;
    }

    /**
     *
     * @return
     */
    public String getSignature() {
        return signature;
    }

    /**
     *
     * @param words
     * @param signature
     */
    public WordSig(String words, String signature){
        this.words = words;
        this.signature = signature;
    }

    @Override
    /**
     *
     */
    public int compareTo(WordSig o) {

        if(Long.parseLong(signature) < Long.parseLong(o.signature)){
            return -1;
        } else if (Long.parseLong(signature) >Long.parseLong( o.signature)){
            return 1;
        } else {
            return 0;
        }

    }
}
