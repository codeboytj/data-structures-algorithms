package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sky on 17-8-9.
 */
public class DuplicateTest {

    @Test
    public void duplicate(){

        Duplicate duplicate=new Duplicate();
        int[] numbers={2,3,1,0,2,5,3};
        int[] duplicates={-1};

//        assertEquals(duplicate.duplicate(numbers,numbers.length,duplicates),true);
//        assertArrayEquals(duplicates,new int[]{2});

        numbers=new int[]{2,4,3,1,4};
        duplicates=new int[]{4};
        assertEquals(duplicate.duplicate(numbers,numbers.length,duplicates),true);
        assertArrayEquals(duplicates,new int[]{4});

    }

}
