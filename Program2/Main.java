

// Raymond Guevara Lozano  hflsd
// CECS 274-05
// Prog 2 - Solitaire Prime
// Due Date 03/03/2020

import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static int menu(){
        System.out.println("Welcome to Solitaire Prime!\n1) New Deck\n2) Display Deck\n3) Shuffle Deck\n4) Play Solitaire Prime\n5) Exit\n6) Simulate 1000 games");
        Scanner userInput = new Scanner(System.in);
        int userNum = userInput.nextInt();
        return userNum;
    }

    public static boolean isPrime(int x){ //Function to determine if number is prime
        if (x == 1){
            return false;
        }
        for (int i = 2; i < Math.sqrt(x); i++){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean playSolitairePrime(Deck deck){
        deck.shuffle();
        int valueSum = 0;
        Card c;
        for (int i = 0; i < 52; i++){
            c = deck.deal();
            valueSum += c.getValue();
            if(isPrime(valueSum)){
                valueSum = 0;
            }
        }
        if (valueSum == 0){
            return true;
        }
        else{
            return false;
        } 
    }
    public static void main(String[] args) {
        int userInput;
        Deck d1 = null;
        do{
            userInput = menu();
            if (userInput == 1){
                d1 = new Deck();
                System.out.println("New deck Created");
                System.out.println();
            }
            else if (userInput == 2){
                d1.display();
                System.out.println();
            }
            else if (userInput == 3){
                d1.shuffle();
                System.out.println("Deck has been shuffled");
                System.out.println();
            }
            else if (userInput == 4){
                Deck deck = new Deck();
                deck.shuffle();
                
                int valueSum = 0;
                int pileCount = 0;
                Card c;
                for (int i = 0; i < 52; i++){
                    c = deck.deal();
                    c.display();
        
                    valueSum += c.getValue();
                    if(isPrime(valueSum)){
                        System.out.println("Prime: " + valueSum);
                        valueSum = 0;
                        pileCount ++;
                    }
        
                    if (i == 51 && valueSum == 0){
                        System.out.println("\nWinner in " + pileCount + " piles!");
                    }
                    else if (i == 51 && valueSum != 0){
                        System.out.println("Loser");
                    }
                }
                System.out.println();
            }
            else if (userInput == 6){
                int win = 0;
                int lose = 0;
                for (int i = 0; i < 1000; i++){
                    Deck d2 = new Deck();
                    d2.shuffle();
                    boolean gameVerdict = playSolitairePrime(d2);
                    if (gameVerdict == true){
                        win ++;
                    }
                    else{
                        lose++;
                    }
                }
                System.out.println("In 1000 games, you won: " + win + " and lost: " + lose);
                System.out.println();
            }
        }
        while (userInput != 5);
    }
}