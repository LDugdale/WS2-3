package predictive;

/**
 * Created by mnt_x on 04/02/2017.
 */
public class Sigs2WordsMap {

    public static void main(String[] args) {

        Dictionary d = new MapDictionary("words");

        for(String s : args){
            System.out.println(d.signatureToWords(s));
        }
    }
}
