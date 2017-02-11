package predictive;

/**
 * @Author Laurie Dugdale
 */
public class Words2SigProto {

    public static void main(String[] args) {

        for(String s : args){
            System.out.println(PredictivePrototype.wordToSignature(s));
        }

    }
}
