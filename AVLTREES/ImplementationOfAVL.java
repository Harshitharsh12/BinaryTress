package AVLTREES;

public class ImplementationOfAVL {
    public static void main(String[] args) {
        AVL obj = new AVL();
//        AVL2 obj2 = new AVL2();
//        obj2.populate(new int[]{2, 33, 32, 35, 79});
//        obj2.display();
//        System.out.println();
//        System.out.println();
//        obj.populate(new int[]{2, 33, 32, 35, 79});
//        obj.populate(new int[]{30, 5, 35, 40, 32, 45});
//        obj.preOrderTraversal();
        for(int i=0;i<=1000;i++){
            obj.insertNode(i);
        }
        obj.preOrderTraversal();
        System.out.println(obj.height());
    }
}
