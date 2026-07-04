package jul03;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class BinarySearchTree {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void inorder(Node root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void levelOrder(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           Node curr = q.poll();
           System.out.print(curr.data+" ");
           if(curr.left != null){
            q.add(curr.left);
           }
           if(curr.right != null){
            q.add(curr.right);
           }
           

        }
    }
    public static void main(String[] args) {
        int[] data = {5 , 0 , 1 , 4 , 40 , 32 ,  39 , 41};
        Node root = new Node(data[0]);
        for (int i = 1; i < data.length; i++){
            insert(root, data[i]);
        }
        inorder(root);
        System.out.print("\n");
        levelOrder(root);
    }
}
