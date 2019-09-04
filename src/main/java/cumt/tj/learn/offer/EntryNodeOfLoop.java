package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-16.
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * 思路：
 * 1. 用HashMap存储每个点出现次数，第一个出现2次的是环的入口
 * 2. 之前做过求链表的第k个节点：
 * @See  FindKthToTail
 *    如果知道链表的环中有n个结点，那么可以准备2个指针a,b
 *    b指针先移动n位，然后a,b一起移动，那么当a,b指向一个节点
 *    的时候，那么节点就是环的入口
 *    问题是如何求出环中有多少个节点
 *    采用一块一慢的指针移动方式，指针c每次移动1个位置，d每次移动2个位置
 *    那么cd第一次相交一定在环中，
 *    那么相交之后d不再移动，c继续移动，再次相交经过的步数就是环中节点数
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        //空链
        if(pHead==null) return null;

        //环中节点数量
        int num=findNodeNum(pHead);
        if(num==0) return null;

        //2个指针
        ListNode a=pHead,b=pHead;
        while (num--!=0){
            b=b.next;
        }

        while (a!=b){
            a=a.next;b=b.next;
        }

        return a;

    }

    public int findNodeNum(ListNode pHead){

        //空链
        if(pHead==null) return 0;

        ListNode c=pHead.next;
        //只有一个节点
        if(c==null) return 0;

        ListNode d=c.next;

        int num=1;
        //移动到第一次相交
        while (c!=d){
            c=c.next;
            d=d.next.next;
        }

        //计算环中结点数量
        while ((c=c.next) !=d){
            num++;
        }

        return num;

    }

}

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/