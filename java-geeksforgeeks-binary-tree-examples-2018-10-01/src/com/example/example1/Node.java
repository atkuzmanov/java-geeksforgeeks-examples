package com.example.example1;


/*
reference: https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
 */


/* Class containing left and right child of current
   node and key value*/
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}


