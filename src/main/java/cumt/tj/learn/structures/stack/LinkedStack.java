package cumt.tj.learn.structures.stack;

/**
 * Created by sky on 17-5-14.
 * 栈的链表实现，《Java编程思想》第15.2.2节
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            item=null;
            next=null;
        }
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        //这是一个末端哨兵，来判断堆栈是否为空
        boolean end(){
            return item==null&&next==null;
        }
    }

    //栈顶元素
    private Node<T> top=new Node();
    public void push(T item){
        //新栈顶元素被推入，原来的栈顶元素变成倒数第二个
        top=new Node<T>(item,top);
    }
    public T pop(){
        T result=top.item;
        if(!top.end()){
            //舍弃原栈顶，新栈顶为第二个
            top=top.next;
        }
        return result;
    }
    public boolean isEmpty(){
        return (top.end());
    }
}
