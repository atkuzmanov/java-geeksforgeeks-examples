package com.example;

/*
reference: https://www.geeksforgeeks.org/arrays-in-java/
 */

public class ArrayCloning {
    public static void main(String[] args) {
        System.out.println("\nDeep cloning: ");
        deepCloning();

        System.out.println("\n\nShallow cloning: ");
        shallowCloning();
    }

    /*
        When you clone a single dimensional array, such as Object[], a “deep copy” is performed with
        the new array containing copies of the original array’s elements as opposed to references.
     */
    static void deepCloning() {
        int intArray[] = {1,2,3};

        int cloneArray[] = intArray.clone();

        // will print false as deep copy is created
        // for one-dimensional array
        System.out.println(intArray == cloneArray);

        for (int i = 0; i < cloneArray.length; i++) {
            System.out.print(cloneArray[i]+" ");
        }
    }


    /*
     A clone of a multidimensional array (like Object[][]) is a “shallow copy” however, which is to say that it
     creates only a single new array with each element array a reference to an original element array
     but subarrays are shared.
     */
    static void shallowCloning() {
        int intArray[][] = {{1,2,3},{4,5}};

        int cloneArray[][] = intArray.clone();

        // will print false
        System.out.println(intArray == cloneArray);

        // will print true as shallow copy is created
        // i.e. sub-arrays are shared
        System.out.println(intArray[0] == cloneArray[0]);
        System.out.println(intArray[1] == cloneArray[1]);

        for (int i = 0; i < cloneArray.length; i++) {
            for(int j = 0; j <cloneArray[i].length; j++) {
                System.out.print(cloneArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
