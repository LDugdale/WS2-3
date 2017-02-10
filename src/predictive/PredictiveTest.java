package predictive;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Laurie Dugdale
 */
public class PredictiveTest {

    private PredictivePrototype pp;
    private ListDictionary ld;
    private MapDictionary md;
    private TreeDictionary td;

    @Before
    public void setUp() {
        pp = new PredictivePrototype();
        ld = new ListDictionary("words");
        md = new MapDictionary("words");
        td = new TreeDictionary("words");
    }

    /**
     * Testing PredictivePrototype class
     */
    /**
     * signatureToWords Test
     */
    @Test
    public void signatureToWordsTest1(){

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
        expected.add("ioof");
        expected.add("ione");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest2(){

        Set<String> actual  = pp.signatureToWords("8");
        Set<String> expected  = new HashSet<>();
        expected.add("t");
        expected.add("u");
        expected.add("v");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest3(){

        Set<String> actual  = pp.signatureToWords("");
        Set<String> expected  = new HashSet<>();
        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest4(){

        Set<String> actual  = pp.signatureToWords("2");
        Set<String> expected  = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest5(){

        Set<String> actual  = pp.signatureToWords("1");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest6(){

        Set<String> actual  = pp.signatureToWords("99999999999999999999");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTest7(){

        Set<String> actual  = pp.signatureToWords("!£$%^&*()_+-=]}{[~#@':;?/>.<,|¬`|\\abcdefghijklmnopqrstuvwxqzABCDEFGHIJKLMOPQRSTUVWXYZ");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    /**
     * WordsToSignature Test
     */
    @Test
    public void wordToSignatureTest1(){

        String actual  = pp.wordToSignature("adgjmptw");
        String expected  = "23456789";

        assertEquals(expected, actual);
    }

    @Test
    public void wordToSignatureTest2(){

        String actual  = pp.wordToSignature("");
        String expected  = "";

        assertEquals(expected, actual);
    }

    @Test
    public void wordToSignatureTest3(){

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
    @Test
    public void signatureToWordsTestld1(){

        Set<String> actual  = ld.signatureToWords("4663");
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
        expected.add("ioof");
        expected.add("ione");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestld2(){

        Set<String> actual  = ld.signatureToWords("8");
        Set<String> expected  = new HashSet<>();
        expected.add("t");
        expected.add("u");
        expected.add("v");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestld3(){

        Set<String> actual  = ld.signatureToWords("");
        Set<String> expected  = new HashSet<>();
        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestld4(){

        Set<String> actual  = ld.signatureToWords("2");
        Set<String> expected  = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestld5(){

        Set<String> actual  = ld.signatureToWords("1");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestld6(){

        Set<String> actual  = ld.signatureToWords("99999999999999999999");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestld7(){

        Set<String> actual  = ld.signatureToWords("!£$%^&*()_+-=]}{[~#@':;?/>.<,|¬`|\\abcdefghijklmnopqrstuvwxqzABCDEFGHIJKLMOPQRSTUVWXYZ");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    /**
     * Testing MapDictionary class
     */
    /**
     * signatureToWords Test
     */
    @Test
    public void signatureToWordsTestmd1(){

        Set<String> actual  = md.signatureToWords("4663");
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
        expected.add("ioof");
        expected.add("ione");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestmd2(){

        Set<String> actual  = md.signatureToWords("8");
        Set<String> expected  = new HashSet<>();
        expected.add("t");
        expected.add("u");
        expected.add("v");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestmd3(){

        Set<String> actual  = md.signatureToWords("");
        Set<String> expected  = new HashSet<>();
        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestmd4(){

        Set<String> actual  = md.signatureToWords("2");
        Set<String> expected  = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestmd5(){

        Set<String> actual  = md.signatureToWords("1");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestmd6(){

        Set<String> actual  = md.signatureToWords("99999999999999999999");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTestmd7(){

        Set<String> actual  = md.signatureToWords("!£$%^&*()_+-=]}{[~#@':;?/>.<,|¬`|\\abcdefghijklmnopqrstuvwxqzABCDEFGHIJKLMOPQRSTUVWXYZ");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    /**
     * Testing MapDictionary class
     */
    /**
     * signatureToWords Test
     */
    @Test
    public void signatureToWordsTesttd1(){

        Set<String> actual  = td.signatureToWords("4663");
        Set<String> expected  = new HashSet<>();
        expected.add("inoe");
        expected.add("inod");
        expected.add("hood");
        expected.add("inme");
        expected.add("ioof");
        expected.add("ione");
        expected.add("imme");
        expected.add("good");
        expected.add("inne");
        expected.add("hond");
        expected.add("inof");
        expected.add("hooe");
        expected.add("hone");
        expected.add("gond");
        expected.add("hoof");
        expected.add("gooe");
        expected.add("gnof");
        expected.add("home");
        expected.add("gone");
        expected.add("goof");
        expected.add("honf");
        expected.add("gome");
        expected.add("gonf");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTesttd2(){

        Set<String> actual  = td.signatureToWords("8");
        Set<String> expected  = new HashSet<>();
        expected.add("t");
        expected.add("u");
        expected.add("v");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTesttd3(){

        Set<String> actual  = td.signatureToWords("");
        Set<String> expected  = new HashSet<>();
        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTesttd4(){

        Set<String> actual  = td.signatureToWords("2");
        Set<String> expected  = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTesttd5(){

        Set<String> actual  = td.signatureToWords("1");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTesttd6(){

        Set<String> actual  = td.signatureToWords("99999999999999999999");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }

    @Test
    public void signatureToWordsTesttd7(){

        Set<String> actual  = td.signatureToWords("!£$%^&*()_+-=]}{[~#@':;?/>.<,|¬`|\\abcdefghijklmnopqrstuvwxqzABCDEFGHIJKLMOPQRSTUVWXYZ");
        Set<String> expected  = new HashSet<>();

        assertEquals(expected, actual );
    }


}
