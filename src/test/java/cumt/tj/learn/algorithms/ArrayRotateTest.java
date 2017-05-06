package cumt.tj.learn.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-4-28.
 */
public class ArrayRotateTest {
    @Test
    public void acrobaticsRotate(){
        String s="abcdefgh";
        ArrayRotate arrayRotate=new ArrayRotate();
        String result=arrayRotate.acrobaticsRotate(s,3);
        assertEquals(result,"defghabc");
    }

    @Test
    public void blockRotate(){
        String s="abcdefgh";
        ArrayRotate arrayRotate=new ArrayRotate();
        String result=arrayRotate.blockRotate(s,4);
        assertEquals(result,"efghabcd");
    }
}
