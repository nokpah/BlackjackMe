import java.util.ArrayList;
import java.util.Random;

public class Deck{

private ArrayList<Card> cards;

    //constructor for the deck
    public Deck(){
        this.cards = new ArrayList<Card>();
        createDeck();
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
            randomCard = random.nextInt((this.cards.size()-1 ) + 1);
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
    public void draw(int toDraw, Player player)
    {
        for (int i = 0; i <  toDraw; i++)
        {
            player.addCard(cards.get(i));
            cards.remove(i);
        }
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


}
