package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-4.
 */
public class FindFirstCommonNodeTest {

    FindFirstCommonNode findFirstCommonNode=new FindFirstCommonNode();

    @Test
    public void simpleFind(){

        ListNode same=new ListNode(6);
        same.next=new ListNode(7);
        ListNode pHead1=new ListNode(1);
        pHead1.next=new ListNode(2);
        pHead1.next.next=new ListNode(3);
        pHead1.next.next.next=same;
        ListNode pHead2=new ListNode(4);
        pHead2.next=new ListNode(5);
        pHead2.next.next=same;
        assertEquals(findFirstCommonNode.simpleFind(pHead1,pHead2),same);

    }

}
