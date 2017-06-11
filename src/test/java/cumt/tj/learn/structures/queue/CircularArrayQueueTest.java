package cumt.tj.learn.structures.queue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-6-11.
 */
public class CircularArrayQueueTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    CircularArrayQueue<String> queue=new CircularArrayQueue<String>(String.class,10);

    @Test
    public void enqueue(){



        String s1="第一位";
        String s2="第二位";
        String s3="第三位";
        String s4="第三位";
        String s5="第三位";
        String s6="第三位";
        String s7="第三位";
        String s8="第三位";
        String s9="第三位";
        String s0="第三位";

        queue.enqueue(s1);
        queue.enqueue(s2);
        queue.enqueue(s3);
        queue.enqueue(s4);
        queue.enqueue(s5);
        queue.enqueue(s6);
        queue.enqueue(s7);
        queue.enqueue(s8);
        queue.enqueue(s9);
        queue.enqueue(s0);

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("超出了队列大小");
        queue.enqueue(s1);


    }

    @Test
    public void dequeue(){

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("队列为空");
        queue.dequeue();

        String s1="第一位";
        String s2="第二位";
        String s3="第三位";

        queue.enqueue(s1);
        queue.enqueue(s2);
        queue.enqueue(s3);

        assertEquals(s1,queue.dequeue());
        assertEquals(s2,queue.dequeue());
        assertEquals(s3,queue.dequeue());
    }

    @Test
    public void circulaArray(){

        String s1="第一位";
        String s2="第二位";
        String s3="第三位";
        String s4="第三位";
        String s5="第三位";
        String s6="第三位";
        String s7="第三位";
        String s8="第三位";
        String s9="第三位";
        String s0="第三位";
        String s10="第三位";
        String s11="第三位";

        queue.enqueue(s1);
        queue.enqueue(s2);
        queue.enqueue(s3);
        queue.enqueue(s4);
        queue.enqueue(s5);
        queue.enqueue(s6);
        queue.enqueue(s7);
        queue.enqueue(s8);
        queue.enqueue(s9);
        queue.enqueue(s0);

        assertEquals(s1, queue.dequeue());

        queue.enqueue(s10);
        //现在队尾在0位置为s10，队头在1位置为s2
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("超出了队列大小");
        queue.enqueue(s11);
    }

}
