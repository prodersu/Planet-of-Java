package shellsort.src.com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private int len;
    private Merge merge = null;
    static void to_txt(int[] arr, int len) {
        try {
            
            Formatter f = new Formatter(Integer.toString(len)+".txt");
            for (int i = 0; i < len; i++) {
                f.format("%s", Integer.toString(arr[i]) + " ");
                if (i % 100 == 0 && i > 0) f.format("%s", "\r\n");
            }
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Main() throws FileNotFoundException {        
        System.out.println("Input the size: ");
        int[] arr = new int[360005];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        len = n;
        Random r = new Random();
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(1000);
        to_txt(arr, n);
        System.out.println(arr[0] + "-------" + arr[n - 1]);
        System.out.println("The text file with numbers of array was created successfully");
        System.out.println("Choose the sort: ");
        System.out.println("1. Bubble");
        System.out.println("2. Merge");
        System.out.println("3. Heap");
        System.out.println("4. Radix");
        System.out.println("5. Shell");
        System.out.println("6. Insertion");
        System.out.println("7. Cocktail \n");
        int ch = sc.nextInt();
        while(true){
            if(ch==1){
                getMerge();
            }
            else {
                System.out.println("Do the right choise, please\n");
            }
        }
    }
    public void printTime(String sort, long time, float time1){
        System.out.println(sort + " sort performed this task for: ");
        System.out.println("time: " + time +  " seconds " + time1 + " milliseconds\n");
    }
    public int getLen(){
        return len;
    }
    public Merge getMerge(){
        return merge;
    }
}



