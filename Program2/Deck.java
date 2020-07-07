
import java.util.Random;
public class Deck {
    private Card [] storageDeck;
    private int top;

    public Deck() { //Deck constructor for 52 cards stored in array of type Card. 
        char [] suits = {'H', 'D', 'S', 'C'};
        char [] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        storageDeck = new Card[52];
        top = 0;

        int count = 0;
        Card C1;
        for (int s = 0; s < suits.length; s++){
            for (int r = 0; r < ranks.length; r++){
                C1 = new Card(suits[s], ranks[r]);
                storageDeck[count++] = C1;
            }
        }
    }

    public void display(){ //method to display the deck in 13 x 4 grid
        int column = 1;
        for (int i = 0; i < storageDeck.length; i++){
            storageDeck[i].display();
            if (column % 13 == 0) {
                System.out.println();
            }
            column++;
        }
    }

    public void shuffle(){ //Shuffle the deck by moving the elements of storage array "randomly"
        Random randNum = new Random();
        for (int i = 0; i < storageDeck.length; i++){
            int firstCard = randNum.nextInt(52);
            int secondCard = randNum.nextInt(52);
            Card hold = storageDeck[firstCard];
            storageDeck[firstCard] = storageDeck[secondCard];
            storageDeck[secondCard] = hold;
        }
    }

    public Card deal(){ // removes card from deck one by one 
        return storageDeck[top++];
    }

    public int cardsleft(){
        return 52 - top;
    }
}