package g55047.model;

/**
 * Class that does a merge sort on an array.
 * 
 * @author Marika Winska 55047
 */
public class MergeSort {
    
    private long nbOperations = 0;
    private final int[] array;

    /**
     * Constructor of the class.
     * 
     * @param array to sort.
     */
    public MergeSort(int[] array) {
        this.array = array;
    }

    /**
     * Getter for the number of operations during the merge sort.
     * 
     * @return the number of operations.
     */
    public long getNbOperations() {
        return nbOperations;
    }
    
    /**
     * https://www.baeldung.com/java-merge-sort
     *
     * @param a array to sort.
     * @param n length of the array to sort.
     */
    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            nbOperations++;
            return;
        }
        
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        nbOperations += 3;

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
            nbOperations++;
        }
        
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            nbOperations++;
        }
        
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    /**
     * https://www.baeldung.com/java-merge-sort
     *
     * @param a array to sort.
     * @param l array to merge.
     * @param r array to merge.
     * @param left size of left array.
     * @param right size of right array.
     */
    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        nbOperations +=3;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
                nbOperations+=2;
            } else {
                a[k++] = r[j++];
                nbOperations+=2;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
            nbOperations++;
        }
        while (j < right) {
            a[k++] = r[j++];
            nbOperations++;
        }
    }
    
}
