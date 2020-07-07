// Raymond Guevara Lozano  
// CECS 274-05
// Prog 4 - Human Pyramid
// Due Date: 04/21/2020

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int truthValue = 1;
        Scanner userInput = new Scanner(System.in);
        do {
            ArrayList<Integer> nums = new ArrayList<Integer>();

            System.out.println("Welcome to the Human Pyramid.");
            System.out.print("How tall is your pyramid? (0 to exit) ");
            int userNum = userInput.nextInt();

            int coloumns = 1;
            for (int i = 1; i <= userNum; i++) {
                for (int j = 1; j <= coloumns; j++) {
                    int weight = (int) weightOnBack(i, j);
                    nums.add(weight - 150);
                }
                coloumns++;
            }

            int spaces = userNum * 3;
            int increment = 2;
            int count = 0;
            int triNum = 1;

            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            System.out.print("   ");
            spaces--;
            for (int temp : nums) {
                System.out.printf("(%4d)", temp);
                count++;
                if (count == triNum) {
                    System.out.println();
                    for (int i = 0; i < spaces; i++) {
                        System.out.print(" ");
                    }
                    spaces -= 3;
                    triNum += increment;
                    increment++;
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (userNum == 0){
                truthValue = 0;
            }
            
        } while (truthValue != 0);
        userInput.close();
    }

    public static double weightOnBack(int r, int c) {
        if (r == 1 && (c == 1)) {
            return 150;
        }
        if (r > 1 && (c == 1)) {
            return 150 + weightOnBack(r - 1, c) / 2;
        }
        if (r > 1 && c == r) {
            return 150 + weightOnBack(r - 1, c - 1) / 2;
        } else {
            return 150 + (weightOnBack(r - 1, c) / 2) + (weightOnBack(r - 1, c - 1) / 2);
        }
    }
}