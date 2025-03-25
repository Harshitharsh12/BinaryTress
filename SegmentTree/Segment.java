package SegmentTree;

import AVLTREES.AVL2;

public class Segment {
    private class Node{
        int totalSum;
int i;
int j;
        Node left;
        Node right;
        public Node(int [] arr,int i,int j){
            this.i=i;
            this.j=j;
            int sum=0;
            while(i<=j){
                sum+=arr[i];
                        i++;
            }
            this.totalSum=sum;
        }
    }
    private Node root;
    public void insert(int[] arr){
        this.root=insert(arr,0,arr.length-1,this.root);
    }
    private Node insert(int [] arr,int i,int j,Node n){
        if(i==j) {
          return  new Node(arr,i,j);
        }
       if(n==null){
           n=new Node(arr,i,j);
       }
      n.left=insert(arr,i,(i+j)/2,n.left);
      n.right=insert(arr,((i+j)/2)+1,j,n.right);
    return n;
    }
//    public int sum(int l,int u){
//        return sum(this.root,l,u,size);
//
//    }
//    private int sum(Node n,int l,int u,int size){
//      if(l==n.i&&u==n.j){
//          return n.totalSum;
//      }
//      int a=size/2;
//if()
//
//    }


        public void display(){
        display(this.root,"Root Node:");
    }
    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.totalSum);
        System.out.println("start index:" + node.i);
        System.out.println("last index:" + node.j);
        display(node.left, "Left child of " + node.totalSum + " : ");
        display(node.right, "Right child of " + node.totalSum + " : ");
    }






}
