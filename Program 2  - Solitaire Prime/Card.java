
public class Card {
    private char suit;
    private char rank;

    public Card(char suit, char rank){ //Constructor  
        this.suit = suit;
        this.rank = rank;
    }

    public void display(){
        if (this.rank == 'T'){ //Character for 10
            System.out.print("10");
            System.out.print(this.suit + ", ");
        }
        else {
            System.out.print(this.rank);
            System.out.print(this.suit + ", ");
        }
    }

    public int getValue(){
        if (this.suit == 'A'){
            return 1;
        }
        else if (this.rank == '2'){
            return 2;
        }
        else if (this.rank == '3'){
            return 3;
        }
        else if (this.rank == '4'){
            return 4;
        }
        else if (this.rank == '5'){
            return 5;
        }
        else if (this.rank == '6'){
            return 6;
        }
        else if (this.rank == '7'){
            return 7;
        }
        else if (this.rank == '8'){
            return 8;
        }
        else if (this.rank == '9'){
            return 9;
        }
        return 10; // any other character should have a value of 10. Whether T, J, Q, or K
    }
}