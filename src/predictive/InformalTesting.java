package predictive;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mnt_x on 01/02/2017.
 */
public class InformalTesting {

    public static void main(String[] args) {

//        ListDictionary ld1 = new ListDictionary("testWords");
//        // System.out.println(ld1);
//        System.out.println(ld1.signatureToWords("65876"));

//        MapDictionary md1 = new MapDictionary("words");
//        System.out.println(md1.signatureToWords("8276743376876377"));

        TreeDictionary td = new TreeDictionary("words");
//        System.out.println(td.getWords());
//        System.out.println(td.getNode('h').getWords());
        System.out.println(td.signatureToWords("8276743376876377"));
        System.out.println(td.signatureToWords("827674337687637"));
        System.out.println(td.signatureToWords("82767433768763"));
        System.out.println(td.signatureToWords("8276743376876"));
        System.out.println(td.signatureToWords("827674337687"));
        System.out.println(td.signatureToWords("82767433768"));
        System.out.println(td.signatureToWords("8276743376"));
        System.out.println(td.signatureToWords("827674337"));
        System.out.println(td.signatureToWords("82767433"));
        System.out.println(td.signatureToWords("8276743"));
        System.out.println(td.signatureToWords("827674"));
        System.out.println(td.signatureToWords("82767"));
        System.out.println(td.signatureToWords("8276"));
        System.out.println(td.signatureToWords("827"));
        System.out.println(td.signatureToWords("82"));
        System.out.println(td.signatureToWords("8"));












    }
}
