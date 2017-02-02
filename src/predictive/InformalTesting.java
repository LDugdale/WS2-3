package predictive;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class InformalTesting {
    public static void main(String[] args) {

        ListDictionary ld1 = new ListDictionary("testWords");

        System.out.println(ld1);

        System.out.println(ld1.signatureToWords("4663"));

    }
}
