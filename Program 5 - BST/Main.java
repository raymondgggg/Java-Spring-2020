import java.util.Scanner;
import java.util.Random;
public class Main{
    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        int truthValue = 1;
        BST newBST = new BST();
        do{
            System.out.println("Binary Search Tree Menu Options:\n1) Create empty BST\n2) Add a number to the BST\n3) Add 20 random numbers in your BST\n4) Display the BST in sorted order\n5) Show Stats\n6) Exit");
            int userNum = newScanner.nextInt();
            System.out.println();
            if (userNum == 1){
                System.out.println("New BST Created");
                System.out.println();
            }
            else if (userNum == 2){
                System.out.print("Enter a number(0-1000): ");
                userNum = newScanner.nextInt();
                newBST.add(userNum);
                System.out.println();
            }
            else if (userNum == 3){
                Random randNum = new Random();
                for (int i = 0; i < 20; i++){
                    int num = randNum.nextInt(1001);
                    newBST.add(num);
                }
                System.out.println("20 Random numbers added.");
                System.out.println();
            }
            else if (userNum == 4){
                newBST.display();
                System.out.println();
            }
            else if (userNum == 5){
                System.out.println("1) Root: " + newBST.rootValue());
                System.out.println("2) Height: " + newBST.height());
                System.out.println("3) Number of items in the tree: " + newBST.size());
                System.out.println("4) Minimum Value: " + newBST.minValue(newBST.getRoot()));
                System.out.println("5) Maximum Value: " + newBST.maxValue(newBST.getRoot()));
                System.out.println("6) Average: " + newBST.avg());
                System.out.println();
            }  
            else if (userNum == 6){
                truthValue = 0;
            }
        }
        while(truthValue != 0);
        newScanner.close();
    }
}