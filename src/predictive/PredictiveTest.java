package predictive;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Laurie Dugdale
 */
public class PredictiveTest {

    /**
     * Testing PredictivePrototype class
     */
    /**
     * signatureToWords Test
     */
    @Test
    public void signatureToWordsTest1(){

        PredictivePrototype pp = new PredictivePrototype();
        Set<String> actual  = pp.signatureToWords("4663");
        Set<String> expected  = new HashSet<>();
        expected.add("gome");
        expected.add("hood");
        expected.add("good");
        expected.add("hond");
        expected.add("inne");
        expected.add("gond");
        expected.add("hone");
        expected.add("hoof");
        expected.add("gone");
        expected.add("goof");
        expected.add("home");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest2(){

        PredictivePrototype pp = new PredictivePrototype();
        Set<String> actual  = pp.signatureToWords("8");
        Set<String> expected  = new HashSet<>();
        expected.add("t");
        expected.add("u");
        expected.add("v");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest3(){

        PredictivePrototype pp = new PredictivePrototype();
        Set<String> actual  = pp.signatureToWords("");
        Set<String> expected  = new HashSet<>();
        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest4(){

        PredictivePrototype pp = new PredictivePrototype();
        Set<String> actual  = pp.signatureToWords("2");
        Set<String> expected  = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest5(){

        PredictivePrototype pp = new PredictivePrototype();
        Set<String> actual  = pp.signatureToWords("1");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    /**
     * signatureToWords Test
     */
    @Test
    public void wordToSignatureTest1(){

        PredictivePrototype pp = new PredictivePrototype();
        String actual  = pp.wordToSignature("adgjmptw");
        String expected  = "23456789";

        assertEquals(expected, actual);
    }

    @Test
    public void wordToSignatureTest2(){

        PredictivePrototype pp = new PredictivePrototype();
        String actual  = pp.wordToSignature("");
        String expected  = "";

        assertEquals(expected, actual);
    }

    @Test
    public void wordToSignatureTest3(){

        PredictivePrototype pp = new PredictivePrototype();
        String actual  = pp.wordToSignature("PPAP");
        String expected  = "7727";

        assertEquals(expected, actual);
    }

    /**
     * Testing ListDictionary class
     */
    /**
     * signatureToWords Test
     */


}
