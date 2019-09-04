package cumt.tj.learn.offer;

import java.util.List;
import java.util.Stack;

/**
 * Created by sky on 17-7-9.
 * 题目：输入一个链表，反转链表后，输出链表的所有元素。
 * 思路： 1.把链表逐个读入到栈中，然后再读出来可以达到反转的效果。
 *        但是一不小心就会造成死循环……
 *       如果出栈的时候，倒数第二个节点重新指向了，最后一个节点
 *       但是没有修改最后一个节点指向null的话，它是按照原来的那样指向倒数第二个节点的
 *       这样，再打印的时候就会造成死循环。。。
 *       另外需要注意的是链表为null的情况
 *       这种方法需要遍历2次
 *       2.如果不用栈怎么办？如果只想遍历1次怎么办？
 *       其实反转链表就是遍历一次，修改每个节点的指针
 *       但是这可能会出现断裂，因为当把第2个结点的next修改为第1个结点之后，无法到达第3个结点
 *       这是就需要一个指针来帮忙，先让它指向第3个结点，然后再修改第二个结点的指针
 *       这种方法也要注意链表为空的情况，还有链表只有一个结点的情况
 */
public class ReverseList {

    public ListNode reverse(ListNode head) {

//        return reverseWithStack(head);
        return reverseWithoutStack(head);

    }

    /**
     * 不使用栈反转
     * @param head
     * @return
     */
    private ListNode reverseWithoutStack(ListNode head){

        if(head==null){
            //链表为空
            return head;
        }else if(head.next==null){
            //只有一个节点
            return head;
        }

        ListNode newHead=head;
        ListNode prev=null;
        ListNode next;

        while (newHead.next!=null){
            //存储下一节点
            next=newHead.next;
            //更改指针
            newHead.next=prev;
            //移动指针
            prev=newHead;
            newHead=next;

        }
        newHead.next=prev;

        return newHead;

    }

    /**
     * 使用栈进行反转
     * @param head
     * @return
     */
    private ListNode reverseWithStack(ListNode head){

        if(head==null){
            //链表为空
            return null;
        }

        Stack<ListNode> stack=new Stack<ListNode>();
        stack.push(head);
        while (head.next!=null){
            head=head.next;
            stack.push(head);
        }

        ListNode newHead=stack.pop();
        ListNode tmp=newHead;
        while (!stack.empty()){
            tmp.next=stack.pop();
            tmp=tmp.next;
        }
        //将最后一个节点的指针指向Null
        tmp.next=null;

        return newHead;
    }

    public static void main(String[] args) {

        ListNode head=new ListNode(5);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(1);

        ReverseList reverseList=new ReverseList();
        ListNode newHead=reverseList.reverse(head);
        while (newHead!=null){
            System.out.print(newHead.val);
            newHead=newHead.next;
        }

        return;
    }

}

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}