package cumt.tj.learn.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-3-18.
 * 插入排序
 */
public class InsertionSortTest {

    @Test
    public void insertionSort(){
        int[] a={12,3,45,45,56,7,13};
        InsertionSort insertionSort=new InsertionSort();
        insertionSort.insertionSort(a);
        assertTrue(Arrays.equals(new int[]{3,7,12,13,45,45,56},a));
    }
}
