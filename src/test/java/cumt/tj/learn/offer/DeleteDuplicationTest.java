package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-16.
 */
public class DeleteDuplicationTest {

    @Test
    public void delete(){

        DeleteDuplication dd=new DeleteDuplication();
        ListNode first=new ListNode(1);
        ListNode firstD=new ListNode(1);
        ListNode firstDD=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode secondD=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode forth=new ListNode(4);
        third.next=forth;
        secondD.next=third;
        second.next=secondD;
        firstDD.next=second;
        firstD.next=firstDD;
        first.next=firstD;
        assertEquals(dd.deleteDuplication(first).val,3);

    }

    @Test
    public void deleteD(){


        ListNode firstDD=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode secondD=new ListNode(2);
        second.next=secondD;
        firstDD.next=second;

        DeleteDuplication dd=new DeleteDuplication();
        dd.deleteDuplication(firstDD,second,secondD);
        assertEquals(firstDD.next,null);

        firstDD=new ListNode(1);
        second=new ListNode(2);
        secondD=new ListNode(2);
        ListNode third=new ListNode(3);
        second.next=secondD;
        firstDD.next=second;
        secondD.next=third;
        dd.deleteDuplication(firstDD,second,secondD);
        assertEquals(firstDD.next.val,3);

    }

}
