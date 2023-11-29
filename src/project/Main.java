package project;

import jdk.jshell.execution.LoaderDelegate;
import project.myparallelmergesort.ParallelMergesort;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

public class Main {

    private static Integer[] generateRandomIntArray(int elements) {
        Integer[] arr = new Integer[elements];
        for(int i = 0; i < elements; i++) {
            arr[i] = (int)(Math.random() * Integer.MAX_VALUE);
        }
        return arr;
    }

    private static boolean isSorted(Integer[] arr) {
        for(int i=0 ; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    private static void testMergeSort(int elements, int threads) {
        Integer[] arr = generateRandomIntArray(elements);

        LocalDateTime start = LocalDateTime.now();
        ParallelMergesort.sort(arr, threads);
        LocalDateTime end = LocalDateTime.now();

        if (isSorted(arr)) {
            System.out.printf("%d elements sorted for %d milliseconds with %d threads%n", elements,
                    start.until(end, ChronoUnit.MILLIS), threads);
        }
        else {
            System.out.printf("Test failed%n");
        }
    }
    public static void main(String args[]) {
        testMergeSort(1000000, 1);
        testMergeSort(1000000, 4);
        /*
        Output:
        1000000 elements sorted for 545 milliseconds with 1 threads
        1000000 elements sorted for 197 milliseconds with 4 threads
         */
    }
}
