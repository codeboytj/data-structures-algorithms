package cumt.tj.learn.offer.alibaba;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-7-25.
 */
public class ArraySplitTest {

    @Test
    public void equalSplitAble(){

        List<Integer> intArray=Arrays.asList(2,2,2,2);
        assertTrue(ArraySplit.equalSplitAble(intArray));
        intArray=Arrays.asList(2,3);
        assertTrue(!ArraySplit.equalSplitAble(intArray));
        intArray=Arrays.asList(2,3,1,1);
        assertTrue(!ArraySplit.equalSplitAble(intArray));
        intArray=Arrays.asList(2, 3, 5, 1, 2, 2, 1, 1, 3);
        assertTrue(ArraySplit.equalSplitAble(intArray));
    }

}
