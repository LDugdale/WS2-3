package predictive;

/**
 * @author Laurie Dugdale
 * ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 1245 12345 9 8657 65 4646 46662368 885226 8852266
 *  real    0m7.087s
 *
 *
 */
public class Sigs2WordsProto {

    public static void main(String[] args) {

        for(String s : args){
            System.out.println(PredictivePrototype.signatureToWords(s));
        }

    }
}
