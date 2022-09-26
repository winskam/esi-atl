package g55047.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for the bubble sort.
 * 
 * @author Marika Winska 55047
 */
public class BubbleSortTest {

    public BubbleSortTest() {}

    /**
     * Test of optimizedBubbleSort method, of class BubbleSort.
     */
    @Test
    public void testOptimizedBubbleSort() {
    }

    /**
     * https://www.baeldung.com/java-bubble-sort
     */
    @Test
    public void givenIntegerArray_whenSortedWithOptimizedBubbleSort_thenGetSortedArray() {
        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.optimizedBubbleSort();
        assertArrayEquals(array, sortedArray);
    }
            
}
