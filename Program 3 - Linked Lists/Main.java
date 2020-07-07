// Raymond Guevara Lozano
// CECS 274-05
// Prog 3 - Linked Lists
// Due Date March 17th, 2020

import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        LList linkedList = new LList();
        String randStr;
        for (int i = 0; i < 100; i++){
            randStr = randWord();
            linkedList.add(randStr);
        }

        String[] llToArray = linkedList.toArray(linkedList);
        sort(llToArray);
        linkedList = linkedList.toLinkedList(llToArray);
        linkedList.display();
        System.out.println();

        String userChoice;
        Node deletedNode;
        Scanner userInput = new Scanner(System.in);
        do{
            System.out.println("(A)dd, (D)elete, (F)ind, (Q)uit List Size: " + linkedList.size());
            userChoice = userInput.nextLine().toLowerCase();
            Random randNum = new Random();

            if (userChoice.equals("a")){
                String s = randWord();
                linkedList.add(s);
                String[] array = linkedList.toArray(linkedList);
                sort(array);
                int location = 0;

                while (location < array.length){
                    if (array[location].equals(s)){
                        break;
                    }
                    location ++;
                }

                linkedList = linkedList.toLinkedList(array);
                linkedList.display();
                System.out.println("\n\n" + s + " was added at location " + location + "\n");
            }
            else if (userChoice.equals("d")){
                int index = randNum.nextInt(linkedList.size());
                deletedNode = linkedList.delete(index);
                linkedList.display();
                System.out.println();
                System.out.println("\n" + deletedNode.getValue() + " was removed from location " + index);
                System.out.println();
            }
            else if (userChoice.equals("f")){
                System.out.print("\nEnter a 4 letter word to find: ");
                userInput = new Scanner(System.in);
                userChoice = userInput.nextLine().toLowerCase();
                System.out.println();
                linkedList.display();
                System.out.println("\n");
                linkedList.find(userChoice);
                System.out.println();
            }
            
        }
        while (userChoice.equals("q") == false);
        userInput.close();
    }

    public static void sort(String [] stringArray){ // Method to sort words in alphabetical order
        String temp;
        for (int i = 0; i < stringArray.length; i++){
            for (int j = 1; j < stringArray.length; j++){
                if (stringArray[j-1].compareTo(stringArray[j]) > 0){
                    temp = stringArray[j-1];
                    stringArray[j-1] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }
    }

    public static String randWord(){ // Method to generate a "random" word
        Random rand = new Random();
        char[] letters = {'b','c','d','f','g','h','j','k','l','m','n','p',
                            'q','r','s','t','v','w','x','y','z'};

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char[] randWord = new char[4];
        String randStr;
        for (int i = 0; i < randWord.length; i++){
            if (i == 1){
                randWord[i] = vowels[rand.nextInt(vowels.length)];
            }
            else{
                randWord[i] = letters[rand.nextInt(letters.length)];
            } 
        }
        randStr = new String(randWord);
        return randStr;
    }
}