package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-1.
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：问题分为三步解决
 * 1. 将原始链表的每个节点N复制一份儿N'，并将N'插入到N与N+1之间。
 * 2. 这样，新节点N'的随机引用random指向的S'为原节点N指向的S的下一节点
 * 3. 将偶数位置的结点抽出来连到一起就是结果
 */
public class LinkedListClone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead){

        if(pHead==null) return null;

//        1. 将原始链表的每个节点N复制一份儿N'，并将N'插入到N与N+1之间。
        sequenceClone(pHead);

//        2. 这样，新节点N'的随机引用random指向的S'为原节点N指向的S的下一节点
        randomClone(pHead);

//        3. 将偶数位置的结点抽出来连到一起就是结果
        return extractList(pHead);

    }

    private RandomListNode extractList(RandomListNode pHead){

        RandomListNode current=pHead;
        RandomListNode newHead=current.next;
        RandomListNode currentCopy;
        RandomListNode next;
        RandomListNode nextCopy;

        while (current!=null){

            currentCopy=current.next;

            next=currentCopy.next;
            nextCopy=(next!=null)?next.next:null;

            currentCopy.next=nextCopy;

            //重新赋值
//            current=(nextCopy==null)?null:nextCopy.next;
            current=next;

        }

        return newHead;

    }

    private void randomClone(RandomListNode pHead){

        //当前节点N与其复制后的节点N'
        RandomListNode current=pHead;
        RandomListNode currentCopy;
        RandomListNode random;
        RandomListNode randomCopy;

        while (current!=null){

            currentCopy=current.next;
            randomCopy=null;

            //当前节点的随机引用
            random=current.random;
            if(random!=null) randomCopy=random.next;

            currentCopy.random=randomCopy;

            //重新赋值
            current=currentCopy.next;

        }


    }

    private void sequenceClone(RandomListNode pHead){

        //当前节点与下一节点
        RandomListNode current=pHead;
        RandomListNode next;

        while (current!=null){

            next=current.next;

            //将当前节点复制一份儿，并将它插入到current与next之间
            current.next=new RandomListNode(current.label);
            current.next.next=next;

            //重新赋值
            current=next;

        }

    }

    public static void main(String[] args) {

        LinkedListClone linkedListClone=new LinkedListClone();

        RandomListNode pHead=linkedListClone.new RandomListNode(1);
        RandomListNode second=linkedListClone.new RandomListNode(2);
        RandomListNode third=linkedListClone.new RandomListNode(3);
        RandomListNode forth=linkedListClone.new RandomListNode(4);
        RandomListNode fifth=linkedListClone.new RandomListNode(5);

        pHead.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;

        pHead.random=third;
        second.random=fifth;
        forth.random=second;

        RandomListNode newHead=linkedListClone.clone(pHead);

        return;

    }

}
