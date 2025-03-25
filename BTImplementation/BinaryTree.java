package BTImplementation;
import java.util.Scanner;
public class BinaryTree {

    //    public BinaryTree(){
//    }
    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    //    public Node getRoot(){
//        return root;
//    }
    public void insert(int val, Scanner sc) {
        root = new Node(val);
        childInsertion(this.root, sc);
    }

    private void childInsertion(Node n, Scanner sc) {
        System.out.println("Do you want to add left child of " + n.val);
        boolean left=sc.nextBoolean();
        if (left) {
            System.out.println("Enter the left Node: " + n.val);
            int val = sc.nextInt();
            Node newNode = new Node(val);
            n.left = newNode;
            childInsertion(newNode, sc);
        }
        System.out.println("Do you want to add right child of " + n.val);
        boolean right=sc.nextBoolean();
        if (right ) {
            System.out.println("Enter the right Node: " + n.val);
            int val = sc.nextInt();
            Node newNode = new Node(val);
            n.right = newNode;
            childInsertion(newNode, sc);
        }
    }

    public void displayNodes() {
        displayNodes(this.root);
//        preetyDisplayNodes(this.root, 0);

    }

    private void displayNodes(Node temp) {
        if (temp == null) {
            return;
        }
        System.out.println(temp.val);
        displayNodes(temp.left);
        displayNodes(temp.right);
    }

    private void preetyDisplayNodes(Node temp, int level) {
        if (temp == null) {
            return;
        }
        preetyDisplayNodes(temp.right, level + 1);
        if(level!=0){
        for (int i = 0; i < level-1; i++) {
            System.out.println("|\t\t");
        }
        System.out.println("|------>"+temp.val);}
        else{
            System.out.println(temp.val);
        }
        preetyDisplayNodes(temp.left, level + 1);
    }
}