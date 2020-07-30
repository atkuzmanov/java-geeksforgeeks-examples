package com.example.example4;

/*
reference: https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 */


/*
Method 2 ( O(n) time complexity )
The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}. The first node will definitely be in range, so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}. If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree. To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 */


// Java program to construct BST from given preorder traversal

// A binary tree node
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Index {

    int index = 0;
}

class BinaryTree {

    Index index = new Index();

    // A recursive function to construct BST from pre[]. preIndex is used
    // to keep track of index in pre[].
    Node constructTreeUtil(int pre[], Index preIndex, int key,
                           int min, int max, int size) {

        // Base case
        if (preIndex.index >= size) {
            return null;
        }

        Node root = null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {

            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            preIndex.index = preIndex.index + 1;

            if (preIndex.index < size) {

                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index],
                        min, key, size);

                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index],
                        key, max, size);
            }
        }

        return root;
    }

    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    Node constructTree(int pre[], int size) {
        int preIndex = 0;
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}

// This code has been contributed by Mayank Jaiswal


