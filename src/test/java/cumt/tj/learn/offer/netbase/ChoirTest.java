package cumt.tj.learn.offer.netbase;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-9.
 */
public class ChoirTest {

    @Test
    public void findMax(){

        Choir choir;

        choir=new Choir(36,new int[]{7,-15,31,49,-44,35,44,-47,-23,15,-11,10,-21,10,-13,0,-20,-36,22,-13,-39,-39,-31,-13,-27,-43,-6,40,5,-47,35,-8,24,-31,-24,-1},3,31);
        assertEquals(choir.findMaxProduct(),108241);

        choir=new Choir(1,new int[]{7},1,50);
        assertEquals(choir.findMaxProduct(),7);

        choir=new Choir(1,new int[]{-7},1,50);
        assertEquals(choir.findMaxProduct(),-7);

        choir=new Choir(1,new int[]{0},1,50);
        assertEquals(choir.findMaxProduct(),0);

        choir=new Choir(2,new int[]{0,7},1,50);
        assertEquals(choir.findMaxProduct(),7);

        choir=new Choir(3,new int[]{7,4,7},2,2);
        assertEquals(choir.findMaxProduct(),49);
        choir=new Choir(3,new int[]{7,4,7},2,1);
        assertEquals(choir.findMaxProduct(),28);

        choir=new Choir(3,new int[]{-7,4,7},2,2);
        assertEquals(choir.findMaxProduct(),28);

        choir=new Choir(3,new int[]{7,-4,7},2,2);
        assertEquals(choir.findMaxProduct(),49);

        choir=new Choir(3,new int[]{7,4,-7},2,2);
        assertEquals(choir.findMaxProduct(),28);
    }

}
