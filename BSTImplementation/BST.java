package BSTImplementation;

public class BST {
    public BST(){
    }

    private class Node{
        int val;
        Node left;
        Node right;
        int height;


        public Node(int val){
this.val=val;
        }
    public int getVal(){
            return val;
    }}
    public int height(Node n){
        if(n==null)
            return -1;
        return n.height;
    }
    public boolean isEmpty(){
        if(this.root==null){
return true;
        }
        return false;
    }
    private Node root;

        public void populate(int [] arr){
            for(int i=0;i<arr.length;i++){
             this.root= insertNode(arr[i],this.root);
            }        }
    public void sortPopulate(int [] arr,int start,int end) {
            if(start>end){
    return;
        }
            int mid=start+(end-start)/2;
            this.root=insert(arr[mid],this.root);
            sortPopulate(arr,start,mid-1);
            sortPopulate(arr,mid+1,end);


        }
    public Node insert(int val,Node n){
            if(n==null){
                n=new Node(val);
                return n;
            }
            if(val>n.val){
                n.right=insert(val,n.right);
            }
            else{   n.left=insert(val,n.left);}
            return n;
    }
        public void insertNode(int val){
        this.root=insertNode(val,this.root);
        }
        private Node insertNode(int val,Node n) {
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
            n.height=Math.max(height(n.left),height(n.right))+1;
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
        public void preOrderTraversal(){
            preOrderTraversal(this.root,"Root Node:");
        }
        private void preOrderTraversal(Node n,String info){
            if(n==null){
                System.out.println(info+" null");
                return;
            }
            System.out.println(info+" "+n.val+"   height: "+n.height);
            preOrderTraversal(n.left,n.val+" left node:");
            preOrderTraversal(n.right, n.val+" right node:");
        }
    public void inOrderTraversal(){
        inOrderTraversal(this.root,"Root Node:");
    }
    private void inOrderTraversal(Node n,String info) {
            if(n==null){
                return;

            }
            inOrderTraversal(n.left,n.val+" left node:");
        System.out.println(info+" "+n.val);
        inOrderTraversal(n.right,n.val+" right node:");

    }
    public void postOrderTraversal(){
        postOrderTraversal(this.root,"Root Node:");
    }
    private void postOrderTraversal(Node n,String info) {
        if(n==null){
            return;
        }
        postOrderTraversal(n.left,n.val+" left node:");
        postOrderTraversal(n.right,n.val+" right node:");
        System.out.println(info+" "+n.val);

    }
    }



