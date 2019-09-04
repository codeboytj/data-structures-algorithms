package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-4.
 */
public class InversePairsTest {

    InversePairs inversePairs=new InversePairs();

    @Test
    public void inversePairs(){

        int[] array;
//        array=new int[]{};
//        assertEquals(inversePairs.inversePairs(array),0);
//        array=new int[]{1};
//        assertEquals(inversePairs.inversePairs(array),0);
//        array=null;
//        assertEquals(inversePairs.inversePairs(array),0);
//        array=new int[]{7,5,6,4};
//        assertEquals(inversePairs.inversePairs(array),5);
//        array=new int[]{7,5};
//        assertEquals(inversePairs.inversePairs(array),1);
//        array=new int[]{5,7};
//        assertEquals(inversePairs.inversePairs(array),0);
//        array=new int[]{5,7,6};
//        assertEquals(inversePairs.inversePairs(array),1);
        array=new int[]{5,4,6};
        assertEquals(inversePairs.inversePairs(array), 1);
        array=new int[]{5,4,3};
        assertEquals(inversePairs.inversePairs(array),3);


    }

}
