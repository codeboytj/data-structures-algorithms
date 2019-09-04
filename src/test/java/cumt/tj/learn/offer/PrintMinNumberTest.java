package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-8-3.
 */
public class PrintMinNumberTest {

    PrintMinNumber printMinNumber=new PrintMinNumber();

    @Test
    public void compare(){

        assertTrue(printMinNumber.compare(1234,4)<0);
        assertTrue(printMinNumber.compare(323,32)>0);

    }

    @Test
    public void getNumberOnPosition(){

        assertEquals(printMinNumber.getNumberOnPosition(1234,4),1);
        assertEquals(printMinNumber.getNumberOnPosition(1234,3),2);

    }

    @Test
    public void quickSort(){

        int[] array=new int[]{4,3,7,2,9,1};
        printMinNumber.quickSort(array,0,array.length-1,array.length-1);
        for (int i:array) {
            System.out.println(i);
        }
        return;

    }

    @Test
    public void printMinNumber(){

        int[] array={3,32,321};
        assertEquals(printMinNumber.PrintMinNumber(array),"321323");
        array=new int[]{3334,3,3333332};
        assertEquals(printMinNumber.PrintMinNumber(array),"333333233334");

    }

}
