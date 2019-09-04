package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-9.
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 思路：由于需要合并后满足单调不减，所以其实是将list2中的元素逐个插入到list1中的合适位置的过程
 *      持有2个指针，分别指向list1与list2
 *      两个链表开始遍历，如果list2的节点B小于list1的节点A，那么应该将B插入到A之前
 *      如果list2先遍历结束，那就真的结束了
 *      如果List1先遍历结束，那么list2中剩余的东东，直接插入到list1的末尾就行了
 */
public class MergeLinkedList {

    public ListNode merge(ListNode list1,ListNode list2) {

        if(list1==null||list2==null){
            //有一个链表为null
            return (list1==null)?list2:list1;
        }


        ListNode prev=null;
        ListNode theOne=list1;

        ListNode theOneIn2=list2;

        while (true){
            if(theOne==null){
                //list1到达末尾指针
                if(list2!=null){
                    //而list2还没有遍历结束
                    prev.next=list2;
                    //结束循环
                    break;
                }
            }else {
                if(theOne.val>theOneIn2.val){
                    //将B插入到A之中
                    list2=list2.next;
                    theOneIn2.next=theOne;

                    if(prev!=null){
                        prev.next=theOneIn2;
                    }else {
                        list1=theOneIn2;
                    }

                    //移动list2的指针
                    theOneIn2=list2;
                }else {
                    //移动list1的指针
                    prev=theOne;
                    theOne=theOne.next;
                }
            }
        }

        return list1;

    }

    public static void main(String[] args) {

        MergeLinkedList mergeLinkedList=new MergeLinkedList();
        System.out.println(mergeLinkedList.merge(null,null));

        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(6);
        head.next.next.next.next=new ListNode(8);

        ListNode head2=mergeLinkedList.merge(null,head);
        System.out.print(head2.val);
        while (head2.next!=null){
            head2=head2.next;
            System.out.print(head2.val);
        }

        head2=mergeLinkedList.merge(head,null);
        System.out.print(head2.val);
        while (head2.next!=null){
            head2=head2.next;
            System.out.print(head2.val);
        }

        ListNode head1=new ListNode(1);
        head1.next=new ListNode(2);
        head1.next.next=new ListNode(4);
        head1.next.next.next=new ListNode(6);
        head1.next.next.next.next=new ListNode(8);


        head2=mergeLinkedList.merge(head1,head);
        System.out.print(head2.val);
        while (head2.next!=null){
            head2=head2.next;
            System.out.print(head2.val);
        }
        return;

    }

}

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
