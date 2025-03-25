package AVLTREES;

public class AVL {
    private class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;
    public int height() {
        return root.height;
    }

        private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    public boolean isEmpty() {
        if (this.root == null) {
            return true;
        }
        return false;
    }

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.root = insertNode(arr[i], this.root);
        }
    }


    public void insertNode(int val) {
        this.root = insertNode(val, this.root);
    }

    private Node insertNode(int val, Node n) {
        if (n == null) {
            n = new Node(val);
            return n;
        }
        if (val <= n.val) {
            n.left = insertNode(val, n.left);
        } else {
            n.right = insertNode(val, n.right);
        }
        n.height = Math.max(height(n.left), height(n.right)) + 1;

        return balance(n);
    }

    public Node balance(Node n) {
        // left unbalance:
        if (height(n.left) - height(n.right) > 1) {
            // left-left
            if (height(n.left.left) - height(n.left.right) > 0) {
                return rightRotate(n);
            }
            if (height(n.left.left) - height(n.left.right) < 0) {
                n.left = leftRotate(n.left);
                return rightRotate(n);
            }
        }
        // right unbalance:
        if (height(n.left) - height(n.right) < -1) {
            if (height(n.right.left) - height(n.right.right) < 0) {
                return leftRotate(n);
            }
            if (height(n.right.left) - height(n.right.right) > 0) {
                n.right = rightRotate(n.right);
                return leftRotate(n);

            }

        }
        return n;
    }

    public Node leftRotate(Node n) {
        Node temp = n;
        Node temp2 = n.right.left;
        n = n.right;
        n.left = temp;
        n.left.right = temp2;
        n.left.height = Math.max(height(n.left.left), height(n.left.right)) + 1;
        return n;
    }

    public Node rightRotate(Node n) {
        Node temp = n;
        Node temp2 = n.left.right;
        n = n.left;
        n.right = temp;
        n.right.left = temp2;
        n.right.height = Math.max(height(n.right.left), height(n.right.right)) + 1;
        return n;
    }

    public void preOrderTraversal() {
        if (isEmpty()) {
            System.out.println("No Element in Tree!!");
            return;
        }
        preOrderTraversal(this.root, "Root Node:");
    }

    private void preOrderTraversal(Node n, String info) {
        if (n == null) {
            System.out.println(info + " null");
            return;
        }
        System.out.println(info + " " + n.val + "   height: " + n.height);
        preOrderTraversal(n.left, n.val + " left node:");
        preOrderTraversal(n.right, n.val + " right node:");
    }
}