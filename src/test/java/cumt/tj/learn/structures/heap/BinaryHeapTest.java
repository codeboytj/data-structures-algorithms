package cumt.tj.learn.structures.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-6-19.
 */
public class BinaryHeapTest {

    Heap heap=new BinaryHeap<String>();

    @Test
    public void insert(){
        heap.insert("我哈哈0");
        heap.insert("我哈哈1");
        heap.insert("我哈哈2");
        heap.insert("我哈哈3");
        heap.insert("我哈哈4");
        heap.insert("我哈哈5");
    }

    @Test
    public void deleteMin(){
        String s0="我哈哈0";
        String s1="我哈哈1";
        String s2="我哈哈2";
        String s3="我哈哈3";
        String s4="我哈哈4";
        String s5="我哈哈5";
        heap.insert(s0);
        heap.insert(s1);
        heap.insert(s2);
        heap.insert(s3);
        heap.insert(s4);
        heap.insert(s5);
        assertEquals(heap.deleteMin(),s0);
        assertEquals(heap.deleteMin(),s1);
        assertEquals(heap.deleteMin(),s2);
        assertEquals(heap.deleteMin(),s3);
        assertEquals(heap.deleteMin(),s4);
        assertEquals(heap.deleteMin(),s5);
    }

    @Test
    public void sort(){
        Heap<String> theHeap=new BinaryHeap<String>(new String[]{"","234","123","566","12"});
        for (String s:theHeap.sort()) {
            System.out.print(s);
        }

    }
}
