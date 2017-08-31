package cumt.tj.learn.offer;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by sky on 17-8-28.
 */
public class MaxInWindowsTest {

    @Test
    public void initTest(){

        int[] num=new int[]{2,3,4,2,6,2,5,1};

        MaxInWindows miw=new MaxInWindows();
        LinkedList<Integer> deque=miw.initDeque(num,3);

        num=new int[]{4,3,2,2,6,2,5,1};
        deque=miw.initDeque(num,3);

        return;
    }

    @Test
    public void maxInWindows(){

        int[] num=new int[]{2,3,4,2,6,2,5,1};

        MaxInWindows miw=new MaxInWindows();

        System.out.println(miw.maxInWindows(num,3));

        num=new int[]{10,14,12,11};
        System.out.println(miw.maxInWindows(num,1));

    }

}
