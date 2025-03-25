package BTImplementation;

import java.util.Scanner;

public class Implementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinaryTree node=new BinaryTree();
        System.out.println("Enter the root Node:");
        int n=sc.nextInt();
        node.insert(n,sc);
        System.out.println();
        System.out.println("Binary Tree Elements from Left to Right:");
        node.displayNodes();
    }
}
