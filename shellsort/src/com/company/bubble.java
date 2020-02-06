package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bubble {
    static void sort(int[] arr, int len){
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i = 0; i<len-i-1; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = true;
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
        sort(arr, len);
        long end = System.currentTimeMillis();
        long time = (end - start)/1000;
        float time1 = (end - start)%1000;
        System.out.println("Bubble sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds");

    }
}
