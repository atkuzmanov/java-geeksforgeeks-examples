package com.example;

/*
reference: https://www.geeksforgeeks.org/arrays-in-java/
 */

import java.util.Collection;

public class ArrayExample1 {

    public static void main(String[] args) {

        // both are valid declarations
        // int intArray[];
        // or int[] intArray;

        byte byteArray[];
        short shortsArray[];
        boolean booleanArray[];
        long longArray[];
        float floatArray[];
        double doubleArray[];
        char charArray[];

        // an array of references to objects of
        // the class MyClass (a class created by
        // user)
        // MyClass myClassArray[];

        Object[]  ao;       // array of Object
        Collection[] ca;  // array of Collection
        // of unknown type


        int intArray[];    //declaring array
        intArray = new int[20];  // allocating memory to array
        int[] intArrayCombo = new int[20]; // combining both statements in one

        int[] intArray2 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        // Declaring array literal


        /* Multidimensional Arrays */


        int[][] intArray3 = new int[10][20]; //a 2D array or matrix
        int[][][] intArray4 = new int[10][20][10]; //a 3D array


        // declaring and initializing 2D array
        int arr[][] = { {2,7,9},{3,6,1},{7,4,2} };

        // printing 2D array
        for (int i=0; i< 3 ; i++)
        {
            for (int j=0; j < 3 ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }




    }
}
