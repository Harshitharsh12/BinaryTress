package BSTImplementation;

public class Implementation {
    public static void main(String[] args) {
        BST obj=new BST();
        BST obj2=new BST();
//        System.out.println(obj.root);
        int[] arr={8,7,6,5,4,100,200,300,400,500,600,700,800};
        int[] arr2={100,200,300,400,500,600,700,800};
        obj.populate(arr);
        obj2.sortPopulate(arr2,0,arr2.length-1);
//        obj.insertNode(100);
//        obj.insertNode(200);
//        obj.preOrderTraversal();
//        obj2.preOrderTraversal();
//        obj2.inOrderTraversal();
        obj2.postOrderTraversal();
    }
}
