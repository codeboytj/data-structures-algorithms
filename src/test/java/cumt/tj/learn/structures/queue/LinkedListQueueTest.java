package cumt.tj.learn.structures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sky on 17-6-12.
 */
public class LinkedListQueueTest {
    LinkedListQueue<String> theQueue=new LinkedListQueue<String>();

    @Test
    public void startStatus(){
        //一开始的状态
        //队头与队尾应该是一个元素
        assertEquals(theQueue.front,theQueue.rear);

        //插入一个元素之后，队头应该是这个元素，而队尾的指针指向下一个位置

        String s1="s1";
        theQueue.enqueue(s1);
        assertNotEquals(theQueue.front,theQueue.rear);
        String s2="s2";
        theQueue.enqueue(s2);
        assertEquals(s1,theQueue.dequeue());
        assertEquals(s2,theQueue.dequeue());

        //所有元素取完之后再取的时候
        //这是队头与队尾又在一起了
        assertEquals(theQueue.front,theQueue.rear);
        assertNotNull(theQueue.front);
        assertNotNull(theQueue.rear);
        assertEquals(null,theQueue.dequeue());
        assertEquals(null,theQueue.dequeue());
    }

    @Test
    public void enqueue(){


        String s1="s1";
        theQueue.enqueue(s1);

        assertEquals(s1,theQueue.dequeue());
        assertEquals(null,theQueue.dequeue());
    }
}
