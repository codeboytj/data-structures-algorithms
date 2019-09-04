package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-5.
 */
public class FindNumsAppearOnceTest {

    FindNumsAppearOnce findNumsAppearOnce=new FindNumsAppearOnce();

    @Test
    public void findNumsAppearOnce(){

       int[] array;int[] num1=new int[1];int[] num2=new int[1];

       array=new int[]{2,4,3,6,3,2,5,5};
       findNumsAppearOnce.FindNumsAppearOnce(array,num1,num2);

       System.out.println(num1[0]+""+num2[0]);

    }

    @Test
    public void findFirstBitIs1(){

        assertEquals(findNumsAppearOnce.findFirstBitIs1(6),2);
        assertEquals(findNumsAppearOnce.findFirstBitIs1(10),2);
        assertEquals(findNumsAppearOnce.findFirstBitIs1(18),2);
        assertEquals(findNumsAppearOnce.findFirstBitIs1(3),1);
        assertEquals(findNumsAppearOnce.findFirstBitIs1(7),1);

    }

}
