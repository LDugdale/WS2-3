package predictive;

/**
 * @Author Laurie Dugdale
 */
public class Sigs2WordsTree {

    public static void main(String[] args) {

        Dictionary d = new TreeDictionary("words");

        for(String s : args){
            System.out.println(d.signatureToWords(s));
        }
    }
}
