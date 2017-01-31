package predictive;

/**
 * Created by mnt_x on 31/01/2017.
 */
public class Words2SigProto {

    public static void main(String[] args) {
        for(String s : args){
            PredictivePrototype.wordToSignature(s);
        }
    }
}
