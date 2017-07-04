package cumt.tj.learn.structures.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sky on 17-7-4.
 * 表的链表实现，它需要实现以下功能：
 * 1. 表的基本操作：add、remove、get、set以及size等
 * 2. 实现Iterable接口的功能，这可能需要提供一个实现Iterator接口的内部类
 */
public class MyLinkedList<T> implements Iterable<T>,MyList<T>{

    //它需要一个内部类来表示双链表中的节点
    private static class Node<E>{
        E data;
        //它分别有一个向前和向后的指针
        Node next;
        Node previous;

        public Node(E data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    //它分别有一个指向链表头和尾的指针，以便在表的两端进行操作
    Node<T> firstMarker;
    Node<T> endMarker;

    //存储当前列表中元素的个数
    private int currentSize;

    //记录修改次数，用来检查使用迭代器的过程中是否更改了集合结构
    private int modCount;

    public MyLinkedList() {
        firstMarker =new Node<T>(null,null,null);
        endMarker =new Node<T>(null,null, firstMarker);
        firstMarker.next= endMarker;
    }

    /**
     * 设置指定位置的元素值
     * @param index 元素的索引
     * @param t 元素
     * @return 该位置原来的元素
     */
    public T set(int index, T t) {

        Node<T> theOld=getNode(index);
        theOld.data=t;
        return theOld.data;

    }

    /**
     * 返回指定位置的元素
     * @param index 元素的索引
     * @return
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * 删除列表末尾的元素
     * @return 被删除的元素
     */
    public T remove() {
        return remove(currentSize-1);
    }

    /**
     * 删除列表指定位置的元素
     * @param index 要删除元素的索引
     * @return 被删除的元素
     */
    public T remove(int index) {

        //找到该位置的节点
        Node<T> theOne=getNode(index);

        //删除该节点
        remove(theOne);

        return theOne.data;
    }

    /**
     * 删除节点
     * @param theOne 将被删除的节点
     */
    private void remove(Node<T> theOne){

        //它的前节点与后节点
        Node<T> thePrevious=theOne.previous;
        Node<T> theNext=theOne.next;

        //重新指定它们的指针关系
        thePrevious.next=theNext;
        theNext.previous=thePrevious;

        //这样就成功地删除了一个元素
        currentSize--;
        //修改了一次
        modCount++;

    }

    /**
     * 返回列表中元素个数
     * @return 列表中的元素个数
     */
    public int size() {

        return currentSize;

    }

    /**
     * 往表的末尾插入新元素
     * @param t 要插入的元素
     */
    public void add(T t) {

        add(size(),t);

    }

    /**
     * 往表的指定位置上插入新元素
     * @param index 要插入元素的索引
     * @param t 要插入的元素
     */
    public void add(int index, T t) {

        //找到该索引当前所指的节点
        Node<T> theOld=getNode(index,0,currentSize);
        //找到theOld当前的previous节点
        Node<T> theOldPrevious=theOld.previous;
        //构造新节点，设置其数据、前后指针
        Node<T> theNew=new Node<T>(t,theOld,theOldPrevious);
        //然后把theOldPrevious的next指针指向新节点
        theOldPrevious.next=theNew;
        //然后把theOld的previous指针指向新节点
        theOld.previous=theNew;
        //现在列表中又多了一个元素了
        currentSize++;
        //修改了一次
        modCount++;

    }

    /**
     * 这个是给除去add()的其他方法用的getNode()，因为判断下标是否越界的时候add的上界是currentSize，而其他方法是currentSize-1
     * @param index 索引
     * @return
     */
    private Node<T> getNode(int index){

        return getNode(index,0,currentSize-1);

    }


    /**
     * 这个是给add()方法专用的getNode()，因为判断下标是否越界的时候add的上界是currentSize，而其他方法是currentSize-1
     * 根据指定的索引获取节点。由于我们持有首尾两个节点的指针，所以，根据索引与首尾节点的距离，决定从哪个节点
     * 开始遍历，需要满足：
     * 1. 由于，在插入的时候，采取修改节点的previous节点完成。所以，对于最初列表为空的情况，应该返回的是endMarker
     * @param index 索引
     * @param lower 下界
     * @param upper 上界
     * @return
     */
    private Node<T> getNode(int index,int lower,int upper){
        Node<T> p;

        if(index<lower||index>upper){
            throw new IndexOutOfBoundsException();
        }

        if(index<currentSize/2){

            p=firstMarker.next;
            for (int i=0;i<index;i++)
                p=p.next;

        }else {
            p=endMarker;
            for (int i=currentSize;i>index;i--)
                p=p.previous;
        }

        return p;

    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{

        private Node<T> current=firstMarker.next;
        private int expectCount=modCount;
        //删除是否可行，删除了一次就不能在删除了
        private boolean okToRemove;

        public boolean hasNext() {
            return current!=endMarker;
        }

        public T next() {

            if(modCount!=expectCount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();

            T nextItem=current.data;

            current=current.next;
            okToRemove=true;

            return nextItem;
        }

        public void remove() {

            if(modCount!=expectCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();

            MyLinkedList.this.remove(current.previous);
            expectCount++;
            okToRemove=false;

        }
    }
}
