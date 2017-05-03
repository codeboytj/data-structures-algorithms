package cumt.tj.learn.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-4-28.
 */
public class ArrayRotateTest {
    @Test
    public void acrobaticsRotate(){
        String s="abcdefghi";
        ArrayRotate arrayRotate=new ArrayRotate();
        String result=arrayRotate.acrobaticsRotate(s,3);
        assertEquals(result,"defghiabc");
    }
}
