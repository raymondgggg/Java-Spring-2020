// Raymond Guevara Lozano
// CECS 274-05
// Prog 3 - Linked Lists
// Due Date March 17th, 2020

public class Node{
    private String value; //Fields of the Node class
    private Node next;

    public Node(String string){ // Node constuctor 
        this.value = string;
        this.next = null;
    }

    public void display(){ // Show the data in node as well as reference to next node
        System.out.println("Data: " + this.value);
        System.out.println("Next node: " + this.next);
    }

    public void setNext(Node node){ // Method to set next Node
        this.next = node;
    } 

    public String getValue(){ // getter for the data in the node
        return this.value;
    }

    public Node getNext(){ // getter for the next node reference
        return this.next;
    }
}