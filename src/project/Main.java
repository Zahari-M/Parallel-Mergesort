package project;

import project.myparallelmergesort.ParallelMergesort;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Integer[] arr = {124,3412,32,5223,23};
        ParallelMergesort.sort(arr, 1);
        System.out.println(Arrays.toString(arr));
    }
}
