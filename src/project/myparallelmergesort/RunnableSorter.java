package project.myparallelmergesort;

/**
 * Sorts interval [initL,initR] in array A using the specified amount of threads
 * Represents a single thread of execution
 */
class RunnableSorter <T> implements Runnable{

    private T[] A,B;
    private int initL, initR;
    private int remainingThreads;

    /**
     * [l,r] is the interval in array A to be sorted using the specified amount of threads
     * @param A array to be sorted
     * @param B helper array
     * @param threads number of remaining threads
     * to descend from the current thread including itself
     */
    public RunnableSorter(T[] A, T[] B, int l, int r, int threads) {
        this.A = A;
        this.B = B;
        this.initL = l;
        this.initR = r;
        this.remainingThreads = threads;
    }
    public void run() {
        try {
            sort(initL, initR);
        }
        catch(InterruptedException e) {
            throw new RuntimeException("Unexpected interruption", e);
        }
    }

    /**
     * Sorts interval [l,r] inclusive in array A
     */
    private void sort(int l, int r) throws InterruptedException {
        if(l >= r) {
            return;
        }

        int mid = (l+r)/2;   // l <= mid < r

        if(remainingThreads > 1) {
            int halfThreads = remainingThreads/2;
            Thread t = new Thread(new RunnableSorter<T>(A,B,l,mid,halfThreads));
            t.start();

            remainingThreads -= halfThreads;
            sort(mid+1, r);

            t.join();

            merge(l,r,mid);
        }
        else {
            sort(l, mid);
            sort(mid+1, r);
            merge(l,r,mid);
        }
    }

    private void merge(int l, int r, int mid) {

    }
}
