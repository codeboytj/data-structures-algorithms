package cumt.tj.learn.algorithms.vector;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-5-8.
 */
public class MaxContiguousSubvectorSumTest {

    @Test
    public void simpleAlgorithms(){
        int[] a={31,-41,59,26,-53,58,97,-93,-23,84};
        MaxContiguousSubvectorSum maxContiguousSubvectorSum=new MaxContiguousSubvectorSum();
        assertEquals(187,maxContiguousSubvectorSum.simpleAlgorithms(a));
    }
}
