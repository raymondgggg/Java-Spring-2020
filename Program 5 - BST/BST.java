import java.lang.Math;
public class BST {
    public class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int x){
            this.value = x;
            this.left = null;
            this.right = null;
        }

        public int getValue(){
            return this.value;
        }

        public void setRight(Node n){
            this.right = n;
        }

        public void setLeft(Node n){
            this.left = n;
        }

        public Node getRight(){
            return this.right;
        }

        public Node getLeft(){
            return this.left;
        }
    } // end Node class

    private Node root;

    public BST(){ //constructor
        this.root = null;
    }

    public Node getRoot(){
        return this.root;
    }

    public int rootValue(){
        return this.root.value;
    }

    public int minValue(Node n){
        while(n.left != null){
            n = n.left;
        }
        return n.value;
    }

    public int maxValue(Node n){
        while(n.right != null){
            n = n.right;
        }
        return n.value;
    }

    private void display(Node n){ //recursive display 
        if (n == null){
            return;
        }
        else{
            display(n.left);
            System.out.print(n.getValue() + ". ");
            display(n.right);
        }
    }

    public void display(){ // display the values in-order traversal 
        if (this.root == null)  
            System.out.println("Empty Tree");
        else  
            display(this.root);
    }

    private void add(Node n, int x){ //Recursive add method
        if (x == n.getValue()){
            System.out.println("Duplicate value, " + x + " will not be added");
        }
        else{
            if (x < n.getValue()){
                if (n.left == null){
                    n.left = new Node(x);
                }
                else{
                    add(n.left, x);
                }
            }
            else{
                if (n.right == null){
                    n.right = new Node(x);
                }
                else{
                    add(n.right, x);
                }
            }
        }
    }

    public void add(int x){ // add int to BST
        if (this.root == null)  
            root = new Node(x);
        else  
            add(this.root,x);
    }

    public int size(){
        if (this.root == null) 
             return 0;
        else 
            return 1 + size(this.root.left) + size(this.root.right);
    }

    private int size(Node p){
        if (p == null)  
            return 0;
        else 
            return 1 + size(p.left) + size(p.right);
    }


    private int sum(Node p){
        if (p == null)
            return 0;
        else
            return p.getValue() + sum(p.left) + sum(p.right);
    }

    public int sum(){
        if (this.root == null)
            return 0;
        else 
            return this.root.getValue() + sum(this.root.left) + sum(this.root.right);
    }

    public int height(){
        return height(this.root);
    }
    
    private int height(Node n){
        if (n == null)
            return 0;
        else
            return 1 + Math.max(height(n.left), height(n.right));
    }

    public int avg(){
        return sum() / size();
    }
}