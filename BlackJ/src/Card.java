public class Card {


    private Suit suit;
    private Value value;


    /**
     * "this." refers to this instance of the card
     * @param suit
     * @param value
     */
    //constructor
    public Card(Suit suit, Value value){

        this.suit = suit;
        this.value = value;
    }

    //Print out suit and values of the cards
    public String toString(){

        return this.suit.toString() + "-" + this.value.toString();
    }

    //Used to check values of the card
    public Value getValue() {
        return this.value;
    }
}
