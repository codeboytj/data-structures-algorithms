package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-3.
 */
public class GetUglyNumberTest {

    GetUglyNumber getUglyNumber=new GetUglyNumber();

    @Test
    public void getUglyNumber(){
//        assertEquals(getUglyNumber.getUglyNumber(1),1);
//        assertEquals(getUglyNumber.getUglyNumber(2),2);
//        assertEquals(getUglyNumber.getUglyNumber(3),3);
//        assertEquals(getUglyNumber.getUglyNumber(4),4);
//        assertEquals(getUglyNumber.getUglyNumber(5),5);
        assertEquals(getUglyNumber.getUglyNumber(6),6);
        assertEquals(getUglyNumber.getUglyNumber(7),8);
        assertEquals(getUglyNumber.getUglyNumber(8),9);
        assertEquals(getUglyNumber.getUglyNumber(9),10);
    }

}
