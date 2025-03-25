package TreeQuestions;
import BSTImplementation.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Tree {

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
    public void populate(int [] arr){
        for(int i=0;i<arr.length;i++){
            this.root= insertNode(arr[i],this.root);
        }}
        private Node insertNode(int val, Node n) {
        if (n == null) {
            n = new Node(val);
            return n;
        }
        if (val <= n.val) {
            n.left = insertNode(val, n.left);
        }
        else {
            n.right = insertNode(val, n.right);
        }
//        n.height=Math.max(height(n.left),height(n.right))+1;
        // or
//            if(n.left!=null&&n.right!=null){
//                n.height=Math.max(n.left.height,n.right.height)+1;
//            }
//            else if(n.left==null){
//                n.height=n.right.height+1;
//
//            }
//            else{
//                n.height=n.left.height+1;
//            }
        return n;   }
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
    public List<List<Integer>> pathSum(int targetSum) {
        return pathSum(this.root,targetSum);
    }
        public List<List<Integer>>list=new ArrayList<>();
    private List<List<Integer>> pathSum(Node root, int targetSum) {
        if(root==null){
            return list;
        }
        else{ ArrayList<Integer> l=new ArrayList<>();
            l.add(root.val);
            totalPath(root,l,targetSum);

        }
        return list;
    }
    public void totalPath(Node node,ArrayList<Integer>l,int targetSum){
        if(node.left==null&&node.right==null){
            int sum=totalSum(l);
            if(sum==targetSum)
                list.add(new ArrayList<>(l));
            return;
        }

        if(node.left!=null){
            l.add(node.left.val);
            totalPath(node.left,l,targetSum);
            l.remove(l.size()-1);
        }
        if(node.right!=null){
            l.add(node.right.val);
            totalPath(node.right,l,targetSum);
            l.remove(l.size()-1);
        }

    }
    public int totalSum(ArrayList<Integer>l){
        int sum=0;
        int size=l.size();
        int i=0;
        while(i<size){
            sum+=l.get(i);
            i++;
        }
        return sum;
    }

}
