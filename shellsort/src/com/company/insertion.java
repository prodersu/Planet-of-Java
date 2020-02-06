package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class insertion {
    static void sort(int[] arr, int n){

        for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
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
        sort(arr, len);
        long end = System.currentTimeMillis();
        long time = (end - start)/1000;
        float time1 = (end - start)%1000;
        System.out.println("Insertion sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds");

    }
}
