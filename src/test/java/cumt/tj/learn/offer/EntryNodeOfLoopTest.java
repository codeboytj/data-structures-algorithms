package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-16.
 */
public class EntryNodeOfLoopTest {

    @Test
    public void findNodeNum(){

        EntryNodeOfLoop en=new EntryNodeOfLoop();

        ListNode root=new ListNode(1);
        assertEquals(en.findNodeNum(root),0);

        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode forth=new ListNode(4);
        ListNode fifth=new ListNode(5);
        ListNode sixth=new ListNode(6);
        root.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
        assertEquals(en.findNodeNum(root),4);
        assertEquals(en.EntryNodeOfLoop(root),third);


    }

}
