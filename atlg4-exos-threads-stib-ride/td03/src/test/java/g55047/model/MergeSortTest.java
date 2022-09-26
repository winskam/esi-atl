package g55047.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class MergeSortTest {

    public MergeSortTest() {}

    /**
     * Test of merge method, of class MergeSort.
     */
    @Test
    public void testMerge() {
    }

    /**
     * https://www.baeldung.com/java-merge-sort
     */
    @Test
    public void positiveTest() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        //MergeSort.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
    
}
