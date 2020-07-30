package com.example.example3;

/*
reference: https://www.geeksforgeeks.org/deletion-binary-tree/
reference: https://www.geeksforgeeks.org/insertion-binary-tree/
 */


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDelete {

    /* A binary tree node has key, pointer to
    left child and a pointer to right child */
    static class Node {
        int key;
        Node left, right;

        // constructor
        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }


    static Node root;
    static Node temp = root;


    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }


    static void deleteDeepest(Node root, Node dNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Do level order traversal until last node
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.right != null) {
//                 if(temp.right == dNode) {
                if (temp.right.key == dNode.key) {
                    temp.right = null;
                    // delete(dNode); // ??? //dNode = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
//                if(temp.left == dNode) {
                if (temp.left.key == dNode.key) {
                    temp.left = null;
                    // delete(dNode); // dNode = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }


    static void deletion(Node root, int key) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;
        Node keyNode = null;

        // Do level order traversal to find deepest
        // node(temp) and node to be deleted (key_node)
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.key == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        System.out.println("\ntemp key:" + temp.key);

        int x = temp.key;
        deleteDeepest(root, temp);
        if (keyNode != null) {
            keyNode.key = x;
        }
    }

    public static void main(String[] args) {

        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before deletion: ");
        inorder(root);

        int key = 9;
        deletion(root, key);

        System.out.print("\nInorder traversal after deletion: ");
        inorder(root);

    }
}
