package predictive;

/**
 * @author Laurie Dugdale
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663
 *  real    0m1.585s
 *  ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245
 *  real    0m1.650s
 * ----------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real    0m2.047s
 * ------------------------------------------------------------------------
 *  Map Dictionary time for command -
 *  time java predictive.Sigs2WordsMap 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real    0m2.631s
 * ------------------------------------------------------------------------
 *
 *
 */
public class Sigs2WordsMap {

    public static void main(String[] args) {

        Dictionary d = new MapDictionary("words");

        for(String s : args){
            System.out.println(d.signatureToWords(s));
        }
    }
}
