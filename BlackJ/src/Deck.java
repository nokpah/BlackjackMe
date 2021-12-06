import java.util.ArrayList;
import java.util.Random;

public class Deck{

private ArrayList<Card> cards;

    //constructor for the deck
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    //adding cards to the deck
    public void createDeck(){

        //Make cards for each suit
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){

                //Adds new cards
                this.cards.add(new Card(cardSuit,cardValue));

            }
        }
    }

    public String toString(){

        String cardOut = " ";

        //Make a string with all the card values
        for(Card aCard : this.cards){
            cardOut += "\n" + aCard.toString();
        }

        return cardOut;
    }

    //Shuffles the cards around using temp deck
    //Loop to remove cards from 1 deck to another
    public void shufDeck(){
        ArrayList<Card>tempDeck = new ArrayList<Card>();

        Random random = new Random();
        int randomCard = 0;
        int orgSize = this.cards.size();

        for (int i = 0; i < orgSize; i++){
            randomCard = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
            tempDeck.add(this.cards.get(randomCard)); //This will put cards in a temporary deck
            this.cards.remove(randomCard); //This will remove the cards from the deck they came from
        }

        this.cards = tempDeck;
    }

    //Removes a card
    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    //adds cards
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    //returns the size of the deck
    public int deckSize(){
        return this.cards.size();
    }

    //Takes card from a deck
    //The 0 is to get the first thing in the deck
    public void draw(Deck drawFrom){
         this.cards.add(drawFrom.getCard(0));
         drawFrom.removeCard(0);
    }

    //rebuild deck
    public void returnDeck(Deck moveTo){
        int thisdeckSize = this.cards.size();

        //Return all players cards to the deck
        for(int i = 0; i < thisdeckSize; i++){
            moveTo.addCard(this.getCard(i));
        }

        //This will continue to remove card 0
        for(int i = 0; i < thisdeckSize; i++){
           this.removeCard(0);
        }

    }

    //Give the total of the cards
    //Total will determine whether the player wins or loses
    public int cardsValue(){

        int totValue = 0;
        int aces = 0;

        for(Card aCard : this.cards){
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
