package g55047.model;

/**
 * Class that does a bubble sort on an array.
 * 
 * @author Marika Winska 55047
 */
public class BubbleSort {

    private long nbOperations = 0;
    private final int[] array;

    /**
     * Constructor of the class.
     * 
     * @param array to sort.
     */
    public BubbleSort(int[] array) {
        this.array = array;
    }

    /**
     * Getter for the number of operations during the bubble sort.
     * 
     * @return the bumber of operations.
     */
    public long getNbOperations() {
        return nbOperations;
    }
    
    /**
     * https://www.baeldung.com/java-bubble-sort
     */
    public void optimizedBubbleSort() {
        int i = 0, n = array.length;
        boolean swapNeeded = true;
        nbOperations += 3;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            nbOperations++;
            for (int j = 1; j < n - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    swapNeeded = true;
                    nbOperations += 5;
                }
            }
            if (!swapNeeded) {
                nbOperations++;
                break;
            }
            i++;
            nbOperations++;
        }
    }
    
}
