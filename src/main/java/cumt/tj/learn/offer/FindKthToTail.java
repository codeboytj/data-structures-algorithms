package cumt.tj.learn.offer;

import java.util.List;

/**
 * Created by sky on 17-7-9.
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 * not：这个链表是单链表，且不是Java类库中的LinkedList，没有size()方法，不知道到底有多少元素。
 * 思路：1. 遍历2次，第一次找出链表中的元素个数n，第二次从开头遍历直到索引(n-k)
 *      2.如果要求只能遍历1次怎么办？
 *      由于要找的元素到最后一个元素的距离间隔了k-1个元素
 *      所以可以设置两个指针进行遍历，当第一个指针遍历到第k个元素的时候，第二个指针开始指向第一个元素
 *      然后两个指针一起移动，这样当第一个指针指向末尾的时候，第二个指针刚好指向我们要找的元素
 *     3. 但是这道题还有一个问题是：代码的鲁棒性，对于这样的情况：
 *     如果K=0，那么倒数第0个是什么鬼？
 *     如果k>n，那么倒数第k个也越界了。
 *     如果输入的head什么都没有，是什么鬼?
 */
public class FindKthToTail {

    public ListNode findKth(ListNode head,int k) {

        if(k<=0||head==null){
            //head为null的情况
            return null;
        }

        //设立2个指针
        ListNode pointerOne=head;
        ListNode pointerTwo=head;

        //第一个指针开始遍历到第k个节点
        ListNode tmp;
        for (int i=1;i<k;i++){
            tmp=pointerOne.next;
            if(tmp!=null){
                pointerOne=tmp;
            }else {
                //k大于节点个数的情况
                return null;
            }
        }

        //让2个指针同时移动
        while (pointerOne.next!=null){
            pointerOne=pointerOne.next;
            pointerTwo=pointerTwo.next;
        }

        return pointerTwo;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(1);

        FindKthToTail findKthToTail=new FindKthToTail();
        ListNode one=findKthToTail.findKth(head,1);
        System.out.print(one.val);
        ListNode two=findKthToTail.findKth(head,2);
        System.out.print(two.val);
        ListNode three=findKthToTail.findKth(head,3);
        System.out.print(three.val);
        ListNode four=findKthToTail.findKth(head,4);
        System.out.print(four.val);
        ListNode five=findKthToTail.findKth(head,5);
        System.out.print(five.val);

        ListNode nullNode=findKthToTail.findKth(head,0);
        System.out.print(nullNode==null);
        nullNode=findKthToTail.findKth(null,5);
        System.out.print(nullNode==null);

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
