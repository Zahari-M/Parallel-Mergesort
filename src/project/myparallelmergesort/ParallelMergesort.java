package project.myparallelmergesort;

import java.lang.reflect.Array;

public class ParallelMergesort {
    public static <T extends Comparable<T>> void sort(T[] A, int threads) {
        if(threads <= 0 || A == null || A.length <= 0) {
            throw new IllegalArgumentException();
        }
        T[] helper = (T[])Array.newInstance(A[0].getClass(), A.length);
        (new RunnableSorter<>(A, helper, 0, A.length - 1, threads)).run();
    }
}
