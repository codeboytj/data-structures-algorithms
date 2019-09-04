package cumt.tj.learn.algorithms.divide;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-9-4.
 */
public class QuickMultTest {

    @Test
    public void quickMult(){

        QuickMult qm=new QuickMult();

        assertEquals(qm.qmul(3,4),3*4);
        assertEquals(qm.qmul(3,1898989),3*1898989);
        assertEquals(qm.qmul(3,-1898989),3*-1898989);
        assertEquals(qm.qmul(-345454,-1898989),(long)-345454*-1898989);
        assertEquals(qm.qmul(0,-1898989),0);
        assertEquals(qm.qmul(0,1898989),0);
        assertEquals(qm.qmul(0,0),0);

    }

}
