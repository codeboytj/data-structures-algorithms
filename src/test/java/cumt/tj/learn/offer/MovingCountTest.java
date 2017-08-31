package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sky on 17-8-29.
 */
public class MovingCountTest {

    @Test
    public void canArrivedTest(){

        MovingCount mc=new MovingCount();

        assertTrue(mc.canArrived(35,37,18));
        assertTrue(!mc.canArrived(35,38,18));

    }

}
