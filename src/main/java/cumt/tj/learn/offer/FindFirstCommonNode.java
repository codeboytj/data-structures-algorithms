package cumt.tj.learn.offer;

import java.util.HashMap;

/**
 * Created by sky on 17-8-4.
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 思路：
 * 1. 利用hashMap存储Node法：
 * 遍历list1
 * 利用一个hash表，存储已经出现的node
 * 遍历list2
 * 查找hash表中是否有node，有则返回
 * 2. 利用单链表特点，利用栈辅助法：
 * 对于单链表，只要有一个节点相同，那么后面的结点肯定都相同了
 * 所以需要从后往前找，第一个不相同的结点的下一个节点就是第一个公共结点
 * 而对于单链表来说，没有指向前一个结点的指针，所以不能从后向前找
 * 所以第一次遍历利用2个栈分别存2个列表的结点
 * 第二次从2个栈顶分别取结点进行比较，就是各自的尾结点，直到不相同的时候，调用.next就是结果
 * 这样会用到2个栈，空间为O(n+m)，时间也是O(n+m)
 * 3. 不需要辅助栈法
 * 第一次遍历，计算2个链表的长度，得到长度差interval
 * 对于相对较长的链表，先遍历interval
 * 然后2个链表一起遍历，一个相同的就是结果
 *
 */
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        return simpleFind(pHead1,pHead2);

    }


    public ListNode simpleFind(ListNode pHead1,ListNode pHead2){

// * 第一次遍历，计算2个链表的长度，得到长度差interval
        int length1=0;
        int length2=0;
        ListNode current1=pHead1;
        ListNode current2=pHead2;
        while (current1!=null){
            length1++;
            current1=current1.next;
        }
        while (current2!=null){
            length2++;
            current2=current2.next;
        }

//                * 对于相对较长的链表，先遍历interval
        int interval=length2-length1;
        if(interval<0){
            //第一个更长
            for (int i=interval;i<0;i++){
                pHead1=pHead1.next;
            }
        }else if(interval>0){
            //第二个更长
            for(int i=0;i<interval;i++){
                pHead2=pHead2.next;
            }
        }

//                * 然后2个链表一起遍历，第一个相同的就是结果
        while (pHead1!=pHead2){

            pHead1=pHead1.next;
            pHead2=pHead2.next;

        }

        return pHead1;

    }

    public ListNode findByHashMap(ListNode pHead1,ListNode pHead2){

        HashMap<ListNode,Boolean> nodeMap=new HashMap<ListNode, Boolean>();

        while (pHead1!=null){

            nodeMap.put(pHead1,true);
            pHead1=pHead1.next;

        }

        while ((pHead2!=null)){

            if(nodeMap.get(pHead2)!=null) return pHead2;
            pHead2=pHead2.next;

        }

        return null;

    }

}
