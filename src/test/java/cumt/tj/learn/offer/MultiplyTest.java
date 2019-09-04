package cumt.tj.learn.offer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sky on 17-8-9.
 */
public class MultiplyTest {

    @Test
    public void multiply(){

        Multiply multiply=new Multiply();
        assertArrayEquals(multiply.multiply(new int[]{}),new int[]{});
        assertArrayEquals(multiply.multiply(null),null);
        assertArrayEquals(multiply.multiply(new int[]{1,2,3,4,5}),new int[]{120,60,40,30,24});

    }

}
