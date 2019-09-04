package cumt.tj.learn.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-4-27.
 */
public class BinarySearchTest {
    @Test
    public void sortTest(){
        int[] a={0,5,8,49,53,62,76,86,94};
        int b=53;
        //int b=94;
        //int b=111;
        BinarySearch binarySearch=new BinarySearch();
        int result=binarySearch.sort(a,b);
//        assertEquals(result,-1);
        assertEquals(result,4);
    }
}
