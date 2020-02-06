package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cocktail_sort {
    static void cocktail(int[] arr, int len){
        int start = 0, end = len-1;
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i = start; i<end; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
            swap = false;
            --end;
            for(int i = end-1;i>=start; --i){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = true;
                }
            }
            ++start;
        }
    }
    public static void main(String args[]) throws FileNotFoundException {
        int [] array = new int[360005];
        int i = 0;
        File f = new File("array.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            array[i++] = Integer.parseInt(sc.next());
        }
        sc.close();
        int len = i;
        long start = System.currentTimeMillis();
        cocktail(array, len);
        long end = System.currentTimeMillis();
        long time = (end - start)/1000;
        float time1 = (end - start)%1000;
        System.out.println("Cocktail sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds");

    }
}
