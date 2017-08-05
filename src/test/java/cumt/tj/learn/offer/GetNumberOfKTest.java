package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-5.
 */
public class GetNumberOfKTest {

    GetNumberOfK getNumberOfK=new GetNumberOfK();

    @Test
    public void getNumberOfK(){

        int[] array;
        array=new int[]{1,2,3,4,5};
        assertEquals(getNumberOfK.getNumberOfK(array,3),1);
        assertEquals(getNumberOfK.getNumberOfK(array,1),1);
        assertEquals(getNumberOfK.getNumberOfK(array,5),1);

        array=null;
        assertEquals(getNumberOfK.getNumberOfK(array,3),0);

        array=new int[]{};
        assertEquals(getNumberOfK.getNumberOfK(array,3),0);

        array=new int[]{1,1,1,4,5,5,5,5,6,7};
        assertEquals(getNumberOfK.getNumberOfK(array,3),0);
        assertEquals(getNumberOfK.getNumberOfK(array,5),4);
        assertEquals(getNumberOfK.getNumberOfK(array,4),1);
        assertEquals(getNumberOfK.getNumberOfK(array,6),1);
        assertEquals(getNumberOfK.getNumberOfK(array,7),1);
    }

    @Test
    public void binarySearch(){

        int[] array;
        array=new int[]{1,2,3,4,5};
        assertEquals(getNumberOfK.binarySearch(array,3),2);
        assertEquals(getNumberOfK.binarySearch(array,1),0);
        assertEquals(getNumberOfK.binarySearch(array,5),4);
        array=new int[]{};
        assertEquals(getNumberOfK.binarySearch(array,3),-1);
        array=new int[]{1};
        assertEquals(getNumberOfK.binarySearch(array,1),0);
        array=null;
        assertEquals(getNumberOfK.binarySearch(array,3),-1);

    }

}
