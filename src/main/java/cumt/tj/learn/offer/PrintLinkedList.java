package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sky on 17-7-5.
 * 题目：输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：
 *      1. 利用ArrayList的方法add(index,value)数组头插入元素的方式存储，由于需要移动数组元素，这样需要花费平方时间
 *      2. 从尾到头打印，刚好符合栈的“先进后出”特点，可以通过栈来实现
 *      3. 由于方法调用本来就是在Java虚拟机栈中完成的，所以可以通过递归的方法调用完成
 */
public class PrintLinkedList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        return storeByRecursive(listNode);
    }

    /**
     * 通过递归的方法调用完成
     * @param listNode 原链表
     * @return
     */
    private ArrayList<Integer> storeByRecursive(ListNode listNode){

        ArrayList<Integer> integers=new ArrayList<Integer>();
        storeByRecursive(listNode,integers);
        return integers;

    }

    /**
     * 递归存储内部实现
     * @param listNode
     * @param integers
     */
    private void storeByRecursive(ListNode listNode,ArrayList<Integer> integers){

        if(listNode==null) {
            //链表已为空，可以返回了
            return;
        }

        //链表中还有节点，继续递归
        storeByRecursive(listNode.next, integers);

        //当递归方法返回了，就可以存储当前的数据了
        integers.add(listNode.val);

    }

    /**
     * 数组实现
     * @param listNode
     * @return
     */
    private ArrayList<Integer> storeByArray(ListNode listNode){

        ArrayList<Integer> integers=new ArrayList<Integer>();

        ListNode p=listNode;
        while (p!=null){
            integers.add(0,p.val);
            p=p.next;
        }

        return integers;

    }

    /**
     * 栈实现
     * @param listNode
     * @return
     */
    private ArrayList<Integer> storeByStack(ListNode listNode){

        ArrayList<Integer> integers=new ArrayList<Integer>();
        Stack intStack=new Stack();

        //先把数据存储在栈中
        ListNode p=listNode;
        while (p!=null){
            intStack.push(p.val);
//            integers.add(0,p.val);
            p=p.next;
        }

        //反序地存储在列表中
        int tmp;
        while (true){
            tmp=intStack.pop();
            integers.add(tmp);
            if(intStack.end()) break;
        }

        return integers;

    }

    public static void main(String[] args) {
        PrintLinkedList printLinkedList=new PrintLinkedList();
        ListNode listNode=new ListNode(2);
        listNode.next=new ListNode(4);
        listNode.next.next=new ListNode(1);
        System.out.println(printLinkedList.printListFromTailToHead(listNode));
    }
}

/**
 * 栈实现
 */
class Stack<T>{

    Node currentMarker=new Node(null);

    public int pop(){
        currentMarker=currentMarker.prev;
        int data=currentMarker.val;
        return data;
    }

    public boolean end(){
        return currentMarker.prev==null;
    }

    public void push(int val){

        currentMarker.val=val;
        currentMarker.next=new Node(0,null,currentMarker);
        currentMarker=currentMarker.next;

    }

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

