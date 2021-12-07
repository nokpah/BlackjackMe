import java.util.ArrayList;

public class Dealer extends Player {

    public String checkHand(int view){
        String cardHand = "";
        for(int i = 0; i < view; i++){
            if(view  == 1){
                cardHand = cardHand + getHand().get(i).toString();
            }else {
                cardHand = cardHand + getHand().get(i).toString() + ", ";

            }
        }

        return cardHand.trim();
    }

}
