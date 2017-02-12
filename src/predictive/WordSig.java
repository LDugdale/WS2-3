package predictive;
import java.math.BigInteger;

/**
 * @author Laurie Dugdale
 */
public class WordSig implements Comparable<WordSig> {

    private String words; // String containing letters of the alphabet including and between a and z
    private String signature; // must be a string of integers including and between 2 and 9

    /**
     * Getter for words field variable
     *
     * @return words field variable.
     */
    public String getWords(){
        return words;
    }

    /**
     * Getter for signature field variable
     *
     * @return signature field variable.
     */
    public String getSignature(){

        return signature;
    }

    /**
     * Basic constructor to initialise the field variables.
     *
     * @param words represents the words to be stored in the List
     * @param signature represents the signature that corresponds to the word in the List
     */
    public WordSig(String words, String signature){

        this.words = words;
        this.signature = signature;
    }

    @Override
    /**
     * Overriding the compareTo method to order the list by the signature field variable.
     */
    public int compareTo(WordSig ws) {

        /*
         * This was my initial attempt at compare to, it organised the list by signature more accurately
         * but was much slower.
         *
         * BigInteger sig = new BigInteger(signature);
         * BigInteger otherSig = new BigInteger(ws.signature);
         *
         * if(sig.compareTo(otherSig) < 0){
         *    return -1;
         * } else if (sig.compareTo(otherSig) > 0){
         *    return 1;
         * } else {
         *    return 0;
         * }
         *
         */

        return this.getSignature().compareTo(ws.getSignature());
    }
}