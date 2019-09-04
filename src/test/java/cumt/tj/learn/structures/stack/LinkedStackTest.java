package cumt.tj.learn.structures.stack;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-5-14.
 * 栈的链表实现，《Java编程思想》第15.2.2节
 */
public class LinkedStackTest {
    @Test
    public void isEmpty(){
        LinkedStack<Character> operatorStack=new LinkedStack<Character>();
        assertTrue(operatorStack.isEmpty());
    }
}
