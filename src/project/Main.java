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
    private static void testMergeSort(int elements, int threads) {
        Integer[] arr = generateRandomIntArray(elements);
        LocalDateTime start = LocalDateTime.now();
        ParallelMergesort.sort(arr, threads);
        LocalDateTime end = LocalDateTime.now();
        System.out.printf("%d elements sorted for %d milliseconds with %d threads%n", elements,
                start.until(end, ChronoUnit.MILLIS), threads);
    }
    public static void main(String args[]) {
        //System.out.println(Arrays.toString(generateRandomIntArray(5)));
        testMergeSort(1000000, 1);
        testMergeSort(1000000, 4);
    }
}
