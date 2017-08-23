package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-23.
 */
public class GetNextTreeNodeTest {

    @Test
    public void getNext(){

        GetNextTreeNode gt=new GetNextTreeNode();

        TreeLinkNode first=new TreeLinkNode(8);
        TreeLinkNode second=new TreeLinkNode(6);
        TreeLinkNode third=new TreeLinkNode(10);
        TreeLinkNode forth=new TreeLinkNode(5);
        TreeLinkNode fifth=new TreeLinkNode(7);
        TreeLinkNode sixth=new TreeLinkNode(9);
        TreeLinkNode seven=new TreeLinkNode(11);

        first.left=second;first.right=third;
        second.next=first;second.left=forth;second.right=fifth;
        third.next=first;third.left=sixth;third.right=seven;
        forth.next=second;
        fifth.next=second;
        sixth.next=third;
        seven.next=third;

//        assertEquals(gt.GetNext(forth),second);
        assertEquals(gt.GetNext(fifth),first);

    }

}
