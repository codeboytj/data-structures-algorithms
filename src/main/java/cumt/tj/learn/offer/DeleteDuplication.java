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
 *        这样，要查看是否重复，比较的是b与c，a存储的是b的前一个节点
 *              如果b.val=c.val，那么删除c，c=c.next,b.next=c
 *                  这时，如果c!=b，那么删除b
 *              如果c==b，那么继续删除c
 *              如果b.val!=c.val，三个节点一起下移
 *        这样是比较麻烦的，那么利用链表递增的特点，a将指向第一个大于b的节点，然后在继续循环
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {

        //空链
        if(pHead==null) return null;

        //由于第一个元素可能是重复元素，所以定义一个指向头节点的节点
        ListNode toHead=new ListNode(-1);
        toHead.next=pHead;

        ListNode a=toHead;
        ListNode b;
        ListNode c;

        while (true){

            b=a.next;
            if(b==null) break;

            c=b.next;
            //只有一个节点或到尽头的情况
            if(c==null) break;

            //判断b和c是否重复
            if (b.val==c.val){
                //将a指针的next指向比b大的第一个元素
                deleteDuplication(a,b,c);
            }else{
                a=a.next;
            }

        }

        return toHead.next;

    }

    /**
     * 删除当前重复的元素，返回重复元素的下一个节点
     * 将a指针的next指向比b大的第一个元素
     * @param b 非空节点
     * @param c 非空节点
     * @return
     */
    public void deleteDuplication(ListNode a,ListNode b,ListNode c){

        ListNode d=c.next;

        while (d!=null){
            if(d.val>c.val){
                break;
            }else{
                d=d.next;
            }
        }

        a.next=d;

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