import java.util.Scanner;

public class Blackjack {



    public static void main(String[] args) {

        System.out.println("Welcome to the BSU Casino");



        Deck playDeck = new Deck();
        Player player1 = new Player();
        Dealer dealer = new Dealer();
        playDeck.shufDeck();


        //Player money
        //Possibly throw this in a class
        double playCoins = 200.00;

        //Get user input
        Scanner user = new Scanner(System.in);
        Scanner response = new Scanner(System.in);
        String answer = new String();




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
            boolean bust = false;

            //Deal Cards
            //player will draw his 2 cards
           playDeck.draw(2,player1);


            //Dealer will draw his 2 cards
            playDeck.draw(2,dealer);

            //This will print the players hands
            while(true){
                System.out.println("Your cards: ");
                System.out.println(player1.checkHand());
                System.out.println("Your hand total is: "+player1.cardsValue());

                //Show Dealer/House hand
                //Usually you only see 1 of the dealers cards
                System.out.println("The Dealer has: "+dealer.checkHand(1)+ " and [Hidden]");

            //Hit or Stay
            //Hit will give the player another card
            //Stay will end that players turn and go to the dealer
                System.out.println("Would you like to (1)Hit or (2)Stay?");
                    int playerResponse = user.nextInt();

                    //Hit
                    //This will draw a card from the deck that is being used
                    //The "-1" is to get the correct index
                    if(playerResponse == 1){
                        playDeck.draw(1,player1);
                        System.out.println("You draw a: "+player1.checkDraw());

                        //Bust
                        //If hand total exceed 21 ( handTotValue > 21)
                        if(player1.cardsValue() > 21){
                            System.out.println("Your hand is total "+player1.cardsValue()+" is greater than 21. You bust!");
                            playCoins -= playerBet;
                            roundEnd = true;
                            bust = true;
                            break;
                        }


                    }
                    //Stay
                    //It will just break the loop since no further action is required
                    if(playerResponse == 2){
                        break;
                    }


            }
            if(bust == true){
                System.out.println("Do you want to play again? (1) for Yes, (2) for No.");
                int playerResponse2 = response.nextInt();
                if (playerResponse2 == 1) {
                    roundEnd = true;

                }
                else{
                    break;
                }
            }


            //Show the dealers hand after hit/Stay
            System.out.println("Dealer Cards: "+dealer.checkHand());

            //Dealer hand total to see if they won
            //Take the players money and end the round
            if((dealer.cardsValue() > player1.cardsValue()) && roundEnd == false){
                System.out.println("Dealer hand: "+dealer.cardsValue()+" | Your Hand: " +player1.cardsValue());
                System.out.println("Dealer's hand is worth more. You lose!");
                playCoins -= playerBet;
                System.out.println("Do you want to play again? (1) for Yes, (2) for No.");
                int playerResponse2 = response.nextInt();
                if (playerResponse2 == 1) {
                    roundEnd = true;
                }
                else
                    break;
            }

            /**
             * This will determine when the dealer should draw cards
             * As intended in our report, if the dealer hand total is less than 17
             * have them keep drawing
             */
            while(dealer.cardsValue() < 17 && roundEnd == false){
                playDeck.draw(1,dealer);
                System.out.println("Dealer draws.");
                System.out.println("Dealer hand: "+dealer.checkHand());
            }

            //Dealer total
            System.out.println("Dealer hand: "+dealer.cardsValue());

            //If dealer bust
            //You have to add roundEnd for dealer because, it's his hand total that
            //determines if the player wins or loses
            if(dealer.cardsValue() > 21 && roundEnd == false){
                System.out.println("Dealers hand total is over 21. You Win!");
                playCoins += playerBet;
                System.out.println("Do you want to play again? (1) for Yes, (2) for No.");
                int playerResponse2 = response.nextInt();
                if (playerResponse2 == 1) {
                    roundEnd = true;
                }
                else
                    break;
            }

            //Push
            /**
             * So in blackjack a tie is known as a push
             * " the player and dealer have hands with the same total below 22."
             * I'll name this push for authenticity
             */
            if(player1.cardsValue() == dealer.cardsValue() && roundEnd == false){
                System.out.println("Both hands hold the same value. Push(Tie)");
                System.out.println("Do you want to play again? (1) for Yes, (2) for No.");
                int playerResponse2 = response.nextInt();
                if (playerResponse2 == 1) {
                    roundEnd = true;
                }
                else
                    break;
            }
            //Player wins
            if ((player1.cardsValue() > dealer.cardsValue()) && roundEnd == false){
                System.out.println("Your hand is worth more. You win!");
                playCoins += playerBet;
                System.out.println("Do you want to play again? (1) for Yes, (2) for No.");
                int playerResponse2 = response.nextInt();
                if (playerResponse2 == 1) {
                    roundEnd = true;
                }
                else
                    break;
            }
            else if (roundEnd == false){
                System.out.println("You lose");
                playCoins -= playerBet;
                System.out.println("Do you want to play again? (1) for Yes, (2) for No.");
                int playerResponse2 = response.nextInt();
                if (playerResponse2 == 1) {
                    roundEnd = true;
                }
                else
                    break;
            }

            //Returns cards back to the playing deck
            player1.emptyHnad();
            dealer.emptyHnad();
            System.out.println("");
            System.out.println("End of hand");
            System.out.println("");
        }

        if(playCoins == 0) {
            System.out.println("You've run out of coins");
        }

        System.out.println("Thank you for playing. Goodbye!");
    }




}

