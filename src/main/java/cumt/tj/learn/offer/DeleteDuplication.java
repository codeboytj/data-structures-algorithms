package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-16.
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路
 * 1. 利用hashMap存储每个val的出现次数
 *    第二次遍历的时候，对于出现了2次及以上次数的节点，进行删除操作
 *    这种需要一个map的o(n)空间
 * 2. 然而这个列表是排过序的……就简单了
 *    利用3个指针a指向链表头,b指向a的下一个，c指向b的下一个
 *    这样，要查看是否重复，比较的是b与c，a存储的是b的前一个节点
 *    如果b.val=c.val，那么删除c，c=c.next,b.next=c
 *          这时，如果c!=b，那么删除b
 *          如果c==b，那么继续删除c
 *    如果b.val!=c.val，三个节点一起下移
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {

        //空链
        if(pHead==null) return null;

        ListNode a=pHead,b=a.next;
        //只有一个节点
        if(b==null) return pHead;
        //首先要找到2个不同的节点作为a,b
        while (a.val==b.val) {
            a=deleteDuplication(a,b);
            if(a==null) break;
            b=a.next;
        }
        pHead=a;

        //c指针出场
        ListNode c;
        if(b!=null) {
            c = b.next;
            while (true){
                //c为Null的时候终止
                if(c==null) break;

                if(b.val==c.val) {

                    //删除当前重复元素
                    b=deleteDuplication(b,c);
                    if(b!=null) c=b.next;
                    a.next=b;

                }

                if(c!=null) c=c.next;
                if(b!=null) b=b.next;
                if(a!=null) a=a.next;
            }
        }
        return pHead;

    }

    /**
     * 删除当前重复的元素，返回重复元素的下一个节点
     * @param b
     * @param c
     * @return
     */
    public ListNode deleteDuplication(ListNode b,ListNode c){

        while (c!=null && b.val==c.val){
            c=c.next;
            b.next=c;
        }
        b=b.next;

        return b;

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