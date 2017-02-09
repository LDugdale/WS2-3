package predictive;

/**
 * @author Laurie Dugdale
 *
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663
 *  real    0m2.993s
 *  ----------------------------------------------------------------------
 *  Prototype Dictionary time for command -
 *  time java predictive.Sigs2WordsProto 4663 876 89 4 245
 *  real    0m3.131s
 * ----------------------------------------------------------------------
 *  Tree Dictionary time for command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266
 *  real    0m3.017s
 * ------------------------------------------------------------------------
 *  Tree Dictionary time for command -
 *  time java predictive.Sigs2WordsTree 4663 876 89 4 245 2345 9 8657 65 4646 46662368 885226 8852266 76325 543543 97 654 2 3 5 6 7 8 546 9227 923
 *  real    0m3.141s
 * ------------------------------------------------------------------------
 *
 */
public class Sigs2WordsTree {

    public static void main(String[] args) {

        Dictionary d = new TreeDictionary("words");

        for(String s : args){
            System.out.println(d.signatureToWords(s));
        }
    }
}
