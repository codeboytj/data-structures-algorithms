package cumt.tj.learn.offer.alibaba;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-7-25.
 */
public class MinStepTest {

    @Test
    public void minStep(){
        assertEquals(1,MinStep.minStep(new int[]{3,4}));
        assertEquals(2,MinStep.minStep(new int[]{3,4,2,1,3,1}));
        assertEquals(3,MinStep.minStep(new int[]{3,1,2,1,3,1}));
        assertEquals(3,MinStep.minStep(new int[]{3,1,2,1,2,1}));
        assertEquals(2,MinStep.minStep(new int[]{2,1,1,1}));
        assertEquals(4,MinStep.minStep(new int[]{2,1,1,1,1,1}));
    }

}
