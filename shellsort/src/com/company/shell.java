package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class shell {
    static void shell_sort(int[] arr, int len) {
        {
            // Start with a big gap, then reduce the gap
            for (int gap = len / 2; gap > 0; gap /= 2) {
                // Do a gapped insertion sort for this gap size.
                // The first gap elements a[0..gap-1] are already in gapped order
                // keep adding one more element until the entire array is
                // gap sorted
                for (int i = gap; i < len; i += 1) {
                    // add a[i] to the elements that have been gap sorted
                    // save a[i] in temp and make a hole at position i
                    int temp = arr[i];

                    // shift earlier gap-sorted elements up until the correct
                    // location for a[i] is found
                    int j;
                    for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                        arr[j] = arr[j - gap];

                    //  put temp (the original a[i]) in its correct location
                    arr[j] = temp;
                }
            }
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
        shell_sort(arr, len);
        long end = System.currentTimeMillis();
        long time = (end - start)/1000;
        float time1 = (end - start)%1000;
        System.out.println("Shell sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds");

    }

}
