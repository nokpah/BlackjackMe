import java.util.Scanner;

public class Blackjack  {

    //Interface gui = new Interface();


    public static void main(String[] args) {

        System.out.println("Welcome to the BSU Casino");

        Deck playDeck = new Deck();
        playDeck.createDeck();
        playDeck.shufDeck();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        //Player money
        //Possibly throw this in a class
        double playCoins = 100.00;

        //Get user input
        Scanner user = new Scanner(System.in);


        //  new Thread(new Blackjack()).start();

        /**
         * This is to loop cycle for the game
         */
        while (playCoins > 0) {
            //Keep Playing

            //Bet
            System.out.println("Your total coins is: " + playCoins + ", How much are you betting?");
            double playerBet = user.nextDouble();
            //If the player trys to bet more than they have
            if (playerBet > playCoins) {
                System.out.println("You cannot bet more than available funds");
                break;
            }

            boolean roundEnd = false;

            //Deal Cards
            //player will draw his 2 cards
            playerDeck.draw(playDeck);
            playerDeck.draw(playDeck);

            //Dealer will draw his 2 cards
            dealerDeck.draw(dealerDeck);
            dealerDeck.draw(dealerDeck);

            //This will print the players hands
            while(true){
                System.out.println("Your two cards: ");
                System.out.println(playDeck.toString());
                System.out.println("Your hand total is: "+playerDeck.cardsValue());

                //Show Dealer/House hand
                //Usually you only see 1 of the dealers cards
                System.out.println("The Dealer has: "+dealerDeck.getCard(0).toString() + " and [Hidden]");

            //Hit or Stay
            //Hit will give the player another card
            //Stay will end that players turn and go to the dealer
                System.out.println("Would you like to (1)Hit or (2)Stay?");
                    int playerResponse = user.nextInt();

                    //Hit
                    //This will draw a card from the deck that is being used
                    //The "-1" is to get the correct index
                    if(playerResponse == 1){
                        playerDeck.draw(playDeck);
                        System.out.println("You draw a: "+playerDeck.getCard(playDeck.deckSize()-1).toString());

                        //Bust
                        //If hand total exceed 21 ( handTotValue > 21)
                        if(playerDeck.cardsValue() > 21){
                            System.out.println("Your hand is total "+playerDeck.cardsValue()+" is greater than 21. You bust!");
                            playCoins -= playerBet;
                            roundEnd = true;
                            break;
                        }

                    }
                    //Stay
                    //It will just break the loop since no further action is required
                    if(playerResponse == 2){
                        break;
                    }


            }
            //Show the dealers hand after hit/Stay
            System.out.println("Dealer Cards: "+dealerDeck.toString());
            //Dealer hand total to see if they won
            //Take the players money and end the round
            if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && roundEnd == false){
                System.out.println("Dealer hand: "+dealerDeck.cardsValue()+" | Your Hand: " +playerDeck.cardsValue());
                System.out.println("Dealer's hand is worth more. You lose!");
                playCoins -= playerBet;
                roundEnd = true;
            }

            /**
             * This will determine when the dealer should draw cards
             * As intended in our report, if the dealer hand total is less than 17
             * have them keep drawing
             */
            while(dealerDeck.cardsValue() < 17 && roundEnd == false){
                dealerDeck.draw(playDeck);
                System.out.println("Dealer draws: "+dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }

            //Dealer total
            System.out.println("Dealer hand: "+dealerDeck.cardsValue());
            //If dealer bust
            //You have to add roundEnd for dealer because, it's his hand total that
            //determines if the player wins or loses
            if(dealerDeck.cardsValue() > 21 && roundEnd == false){
                System.out.println("Dealers hand total is over 21. You Win!");
                playCoins += playerBet;
                roundEnd = true;
            }

            //Push
            /**
             * So in blackjack a tie is known as a push
             * " the player and dealer have hands with the same total below 22."
             * I'll name this push for authenticity
             */
            if(playDeck.cardsValue() == dealerDeck.cardsValue() && roundEnd == false){
                System.out.println("Both hands hold the same value. Push(Tie)");
                roundEnd = true;
            }
            //Player wins
            if ((playDeck.deckSize() > dealerDeck.cardsValue()) && roundEnd == false){
                System.out.println("Your hand is worth more. You win!");
                playCoins += playerBet;
                roundEnd = true;
            }
            else if (roundEnd == false){
                System.out.println("You lose");
                playCoins -= playerBet;
                roundEnd = true;
            }

            //Returns cards back to the playing deck
            playDeck.returnDeck(playDeck);
            dealerDeck.returnDeck(playDeck);
            System.out.println("End of hand");

        }

        System.out.println("You've run out of coins");


    }


}
