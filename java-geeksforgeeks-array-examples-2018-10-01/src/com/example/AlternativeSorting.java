package com.example;


/*
reference: https://www.geeksforgeeks.org/arrays-in-java/
 */

// Java program to print an array in alternate
// sorted manner
import java.io.*;
import java.util.Arrays;

class AlternativeSorting
{
    // Function to print alternate sorted values
    static void alternateSort(int arr[], int n)
    {
        Arrays.sort(arr);

        System.out.println("sorted arr: ");
        for(int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println("\n\n");

        // Printing the last element of array
        // first and then first element and then
        // second last element and then second
        // element and so on.
        int i = 0, j = n-1;
        while (i < j) {
            System.out.print(arr[j--] + " ");
            System.out.print(arr[i++] + " ");
        }

        // If the total element in array is odd
        // then print the last middle element.
        if (n % 2 != 0)
            System.out.print(arr[i]);
    }

    /* Driver program to test above functions */
    public static void main (String[] args)
    {
        int arr[] = {1, 12, 4, 6, 7, 10, 42};
        int n = arr.length;
        alternateSort(arr, n);
    }
}
/*This code is contributed by Prakriti Gupta*/


