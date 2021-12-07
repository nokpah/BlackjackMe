import java.util.ArrayList;

public class Player {
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public ArrayList<Card> getHand(){
        return hand;
    }


    public Player()
    {

    }

    public Player(String name,double money)
    {
        this.name = name;
        this.money = money;
    }

    public Player(String name,double money, ArrayList<Card> cards)
    {
        this.name = name;
        this.money = money;
        hand = cards;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String enter)
    {
        name = enter;
    }

    public double getMoney()
    {
        return money;
    }

    protected void setMoney(double enter)
    {
        this.money = enter;
    }

    public String checkHand()
    {
        String cardHand = "";
        for(int i = 0; i < hand.size(); i++){
            cardHand = cardHand + hand.get(i).toString() + ", ";
        }

        return cardHand.trim();
    }

    //Why is this needed?
    public boolean checkHand(Value cardVal)

    {
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getValue() == cardVal)
            {
                return true;
            }
        }
        return false;
    }

   public boolean checkHand(Card card)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).toString().equals(card.toString()))
            {
                return true;
            }
        }
        return false;
    }

    public void emptyHnad(){

        hand = new ArrayList<Card>();
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }

    public String checkDraw(){

        String cardHand = "";
        cardHand = cardHand + hand.get(hand.size()-1).toString();


        return cardHand.trim();
    }

    //Give the total of the cards
    //Total will determine whether the player wins or loses
    public int cardsValue(){

        int totValue = 0;
        int aces = 0;

        for(Card aCard : this.hand){
            switch(aCard.getValue()){

                case TWO: totValue += 2; break;
                case THREE: totValue += 3; break;
                case FOUR: totValue += 4; break;
                case FIVE: totValue += 5; break;
                case SIX: totValue += 6; break;
                case SEVEN: totValue += 7; break;
                case EIGHT: totValue += 8; break;
                case NINE: totValue += 9; break;
                case TEN: totValue += 10; break;
                case JACK: totValue += 10; break;
                case QUEEN: totValue += 10; break;
                case KING: totValue += 10; break;
                case ACE: totValue += 1; break;
            }
        }

        //So this is to give value to aces depending on how many are in the players hand
        for(int i = 0; i < aces; i++){

            if(totValue > 10){
                totValue += 1;
            }

            else{
                totValue += 11;
            }
        }

        return totValue;
    }



}