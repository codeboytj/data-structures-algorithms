package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sky on 17-8-8.
 */
public class IsContinuousTest {

    IsContinuous isContinuous=new IsContinuous();

    @Test
    public void isContinuous(){

        int[] numbers;
        numbers=new int[]{3,0,0,1,5};
        assertEquals(isContinuous.isContinuous(numbers),true);
        numbers=new int[]{1,3,0,5,0};
        assertEquals(isContinuous.isContinuous(numbers),true);

        numbers=new int[]{3,0,0,1,4};
        assertEquals(isContinuous.isContinuous(numbers),true);

        numbers=new int[]{3,0,0,1,5};
        assertEquals(isContinuous.isContinuous(numbers),true);

        numbers=new int[]{3,0,0,1,6};
        assertEquals(isContinuous.isContinuous(numbers),false);

        numbers=new int[]{3,0,0,1,7};
        assertEquals(isContinuous.isContinuous(numbers),false);
    }


    @Test
    public void bubbleSort(){

        int[] numbers;
        numbers=new int[]{1,3,0,5,0};
        isContinuous.bubbleSort(numbers);
        assertArrayEquals(numbers,new int[]{0,0,1,3,5});

        numbers=new int[]{3,0,0,1,4};
        isContinuous.bubbleSort(numbers);
        assertArrayEquals(numbers,new int[]{0,0,1,3,4});

        numbers=new int[]{3,0,0,14};
        isContinuous.bubbleSort(numbers);
        assertArrayEquals(numbers,new int[]{0,0,3,14});

        numbers=new int[]{14};
        isContinuous.bubbleSort(numbers);
        assertArrayEquals(numbers,new int[]{14});

        numbers=new int[]{};
        isContinuous.bubbleSort(numbers);
        assertArrayEquals(numbers,new int[]{});

        numbers=null;
        isContinuous.bubbleSort(numbers);
        assertArrayEquals(numbers,null);

    }


}
