package predictive;

import java.util.Comparator;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class WordSig implements Comparable<WordSig> {

    private String words;
    private String signature;

    public String getWords() {
        return words;
    }

    public int getSignature() {
        return Integer.parseInt(signature);
    }

    public WordSig(String words, String signature){
        this.words = words;
        this.signature = signature;
    }

    @Override
    public int compareTo(WordSig ws) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this.getSignature() == ws.getSignature()){
            return EQUAL;
        } else if (this.getSignature() < ws.getSignature()){
            return BEFORE;
        } else {
            return AFTER;
        }
    }
}
