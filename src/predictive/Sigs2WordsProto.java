package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663
 *  real    0m1.227s
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245
 *  real    0m3.568s
 * ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real    0m7.087s
 * ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real    0m11.954s
 * ------------------------------------------------------------------------
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
