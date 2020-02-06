package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quick {
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
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
        System.out.println("Quick sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds");

    }
}
