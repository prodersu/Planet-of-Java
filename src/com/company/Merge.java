package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public static void main(String args[]) throws FileNotFoundException {
        int [] arr = new int[360005];
        int i = 0;
        File f = new File("array.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            arr[i++] = Integer.parseInt(sc.next());
        }
        sc.close();
        int len = i;
        long start = System.currentTimeMillis();
        sort(arr, 0, len-1);
        long end = System.currentTimeMillis();
        long time = (end - start)/1000;
        float time1 = (end - start)%1000;
        System.out.println("Merge sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds");

    }
}
