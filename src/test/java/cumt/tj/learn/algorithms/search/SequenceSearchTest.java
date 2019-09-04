package cumt.tj.learn.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-4-27.
 */
public class SequenceSearchTest {
    @Test
    public void simpleSearchTest(){
        int[] a={0,5,8,49,53,62,76,86,94};
        int b=53;
        SequenceSearch sequenceSearch=new SequenceSearch();
        assertEquals(sequenceSearch.simpleSearch(a,b),4);
    }
    @Test
    public void sentinelSearchTest(){
        int[] a={0,5,8,49,53,62,76,86,94};
        int b=53;
        SequenceSearch sequenceSearch=new SequenceSearch();
        assertEquals(sequenceSearch.sentinelSearch(a,b),4);
    }
    @Test
    public void reduceIncreasingSearchTest(){
        int[] a={0,5,8,49,53,62,76,86,94};
        int b=53;
        SequenceSearch sequenceSearch=new SequenceSearch();
        assertEquals(sequenceSearch.reduceIncreasingSearch(a,b),4);
    }
}
