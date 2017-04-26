package cumt.tj.learn.algorithms.sort;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-3-16.
 * 归并排序
 */
public class MergeSortTest {

    @Test
    public void mergeTest(){
        MergeSort mergeSort=new MergeSort();
        int[] a={6,202,100};
        mergeSort.merge(a,new int[6],0,2,2);
        assertTrue(Arrays.equals(new int[]{6,100,202},a));
    }

//    @Ignore
    @Test
    public void mergeSortTest(){
        MergeSort mergeSort=new MergeSort();
        int[] a={6,202,100,301,38,8,1};
        mergeSort.mergeSort(a);
        assertTrue(Arrays.equals(new int[]{1,6,8,38,100,202,301},a));
//        assertEquals(new int[]{1,6,8,38,100,202,301},a);
    }

//    @Test
//    public void mergeSortUnitTest(){
////        int[] a
//    }
}
