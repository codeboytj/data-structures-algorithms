package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-10-7.
 */
public class LCSTest {

    @Test
    public void find(){
        LCS lcs=new LCS();
        assertEquals(lcs.findLCS("1A2C3D4B56",10,"B1D23CA45B6A",12),6);
    }

}
