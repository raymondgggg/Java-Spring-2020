// Raymond Guevara Lozano
// CECS 274-05
// Prog 3 - Linked Lists
// Due Date March 17th, 2020

public class LList{
    private Node head; //Field of Linked List Class 
    
    public LList(){ // Constructor for the linked List
        this.head = null;
    }

    public Node getHead(){ // Method to return the value of the head for the linked list
        return this.head; 
    }
    
    public void add(String string){ // method to add data to linked list 
        Node newString = new Node(string); 
        Node temp = this.head;
        this.head = newString;
        newString.setNext(temp);
    }

    public void find(String string){ // method to find a string in the linked list
        Node n = this.head;
        int location = 0;
        while (n != null){
            if (n.getValue().equals(string)){
                System.out.println(string + " found at location " + location);
                return;
            }
            location ++;
            n = n.getNext();
        }
        System.out.println(string + " not found");
    }

    public Node delete(int randIndex){ //method to delete string in linked list. 
        Node deletedNode;
        if (randIndex == 0){ //head is at index 0
            deletedNode = this.head;
            this.head = this.head.getNext();
        } 
        else{
            Node n = this.head; // n represents position n 
            Node n1 = null; // n1 represents position n + 1
            
            for (int i = 0; i < randIndex-1; i++){
                n = n.getNext();
            }
            n1 = n.getNext();
            n.setNext(n1.getNext()); 
            deletedNode = n1; 
        }
        return deletedNode;
    }

    public void display(){ // Method to display linked list in 12 columns and how ever many rows
        int column = 0;
        Node n = this.head;
        while (n != null){
            if (column % 12 == 0){
                System.out.println();
            }
            System.out.printf("%-6s",n.getValue());
            n = n.getNext();
            column ++;
        }
    }

    public int size(){ // Mothod that returns how many elements of type String are in the Linked List
        Node n = this.head;
        int size = 0;
        while (n != null){
            n = n.getNext();
            size ++;
        }
        return size;
    }

    public String[] toArray(LList linkedList){ // Method to convert linked list to array so it can be sorted
        Node n = linkedList.getHead();
        String[] stringArray = new String[linkedList.size()];
        int arrayIndex = 0;
        while (n != null){
            stringArray[arrayIndex] = n.getValue();
            n = n.getNext();
            arrayIndex ++;
        }
        return stringArray;
    }

    public LList toLinkedList(String[] arrayStrings){ //method to convert sorted array back to a linked list
        LList linkedList = new LList();
        for (int i = (arrayStrings.length-1); i >= 0; i--){
            linkedList.add(arrayStrings[i]);
        }
        return linkedList;
    }
}