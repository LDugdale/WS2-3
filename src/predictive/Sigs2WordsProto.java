package predictive;

/**
 * Created by mnt_x on 31/01/2017.
 */
public class Sigs2WordsProto {

    public static void main(String[] args) {

        for(String s : args){
            System.out.println(PredictivePrototype.signatureToWords(s));
        }

    }
}
