package cumt.tj.learn.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-3-19.
 */
public class QuickSortTest {
    @Test
    public void simpleQuickSortTest(){
        int[] a={1,21,1,11,32,51,46,87,15,3,2};
        QuickSort quickSort=new QuickSort();
        quickSort.simpleQuickSort(a);
        System.out.print(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1,1,2,3,11,15,21,32,46,51,87},a));
    }
    @Test
    public void quickSortTest(){
        int[] a={1,21,1,11,32,51,46,87,15,3,2};
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(a);
        System.out.print(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1,1,2,3,11,15,21,32,46,51,87},a));
    }
    @Test
    public void randQuickSortTest(){
        int[] a={1,21,1,11,32,51,46,87,15,3,2};
        QuickSort quickSort=new QuickSort();
        quickSort.randQuickSort(a);
        System.out.print(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1,1,2,3,11,15,21,32,46,51,87},a));
    }
    @Test
    public void InsertAndQuickSortTest(){
        int[] a={1,21,1,11,32,51,46,87,15,3,2};
        QuickSort quickSort=new QuickSort();
        quickSort.insertAndQuickSort(a);
        System.out.print(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1,1,2,3,11,15,21,32,46,51,87},a));
    }
}
