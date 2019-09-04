package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-8.
 */
public class SumTest {

    Sum sum=new Sum();

    @Test
    public void sum(){
        assertEquals(sum.sum(100),5050);
        assertEquals(sum.sum(1),1);
        assertEquals(sum.sum(2),3);
    }

}
