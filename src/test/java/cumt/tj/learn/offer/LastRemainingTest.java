package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-8.
 */
public class LastRemainingTest {

    LastRemaining lastRemaining=new LastRemaining();

    @Test
    public void lastRemaining(){
        assertEquals(lastRemaining.LastRemaining(3,2),2);
        assertEquals(lastRemaining.LastRemaining(3,1),2);
        assertEquals(lastRemaining.LastRemaining(1,0),-1);
    }

}
