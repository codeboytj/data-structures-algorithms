package cumt.tj.learn.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sky on 17-8-8.
 */
public class BubbleSortTest {

    BubbleSort<Integer> bubbleSort=new BubbleSort<Integer>();

    @Test
    public void sort(){

        Integer[] numbers;
        numbers=new Integer[]{3,0,0,1,4};
        bubbleSort.sort(numbers);
        assertArrayEquals(numbers,new Integer[]{0,0,1,3,4});

        numbers=new Integer[]{1,3,0,5,0};
        bubbleSort.sort(numbers);
        assertArrayEquals(numbers,new Integer[]{0,0,1,3,5});
        numbers=new Integer[]{3,0,0,14};
        bubbleSort.sort(numbers);
        assertArrayEquals(numbers,new Integer[]{0,0,3,14});

        numbers=new Integer[]{14};
        bubbleSort.sort(numbers);
        assertArrayEquals(numbers,new Integer[]{14});

        numbers=new Integer[]{};
        bubbleSort.sort(numbers);
        assertArrayEquals(numbers,new Integer[]{});

        numbers=null;
        bubbleSort.sort(numbers);
        assertArrayEquals(numbers,null);

    }

}
