package predictive;
import java.util.Set;
/**
 * Dictionary interface
 *
 * @author Laurie Dugdale
 */
public interface Dictionary {

    public Set<String> signatureToWords(String signature);

}
