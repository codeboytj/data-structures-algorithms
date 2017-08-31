package cumt.tj.learn.offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-8-27.
 */
public class MedianInStreamTest {

    @Test
    public void insertAndGet(){

        MedianInStream mis=new MedianInStream();

        mis.Insert(5);
        assertTrue(mis.GetMedian()==5.0);

        mis.Insert(2);
        assertTrue(mis.GetMedian()==3.5);

        mis.Insert(3);
        assertTrue(mis.GetMedian()==3.0);

        mis.Insert(4);
        assertTrue(mis.GetMedian()==3.50);

        mis.Insert(1);
        assertTrue(mis.GetMedian()==3.00);

        mis.Insert(6);
        assertTrue(mis.GetMedian()==3.50);

        mis.Insert(7);
        assertTrue(mis.GetMedian()==4.00);

        mis.Insert(0);
        assertTrue(mis.GetMedian()==3.50);

        mis.Insert(8);
        assertTrue(mis.GetMedian()==4.00);

    }

}
