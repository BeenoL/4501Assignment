package gameControl;

public class checkFinish {

    public static boolean checkFinish(int matchedPair){
        if(matchedPair == 4){
            return true;
        }else{
            return false;
        }
    }
}
