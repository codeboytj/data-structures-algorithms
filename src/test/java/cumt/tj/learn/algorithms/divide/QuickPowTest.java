package cumt.tj.learn.algorithms.divide;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-9-4.
 */
public class QuickPowTest {

    @Test
    public void quickPow(){

        QuickPow qp=new QuickPow();

        assertEquals(qp.quickPow(2,3),(long)Math.pow(2,3));
        assertEquals(qp.quickPow(4,29),(long)Math.pow(4,29));
        assertEquals(qp.quickPow(-4,5),(long)Math.pow(-4,5));

    }

}
