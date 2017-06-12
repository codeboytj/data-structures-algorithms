package cumt.tj.learn.structures.queue;

/**
 * Created by sky on 17-6-12.
 */
public class LinkedListQueue<T> {

    //节点类
    private static class Node<U>{
        U item;
        Node<U> next;

        public Node() {

        }

        public Node(U item) {
            this.item = item;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        public U getItem() {
            return item;
        }

        public void setItem(U item) {
            this.item = item;
        }

        public Node<U> getNext() {
            return next;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }

        public boolean end(){
            return item==null && next==null;
        }
    }

    //队头元素
    Node<T> front=new Node<T>();
    //队尾元素，一开始队头与队尾一样
    Node<T> rear=front;

    /**
     * 入队
     * @param item
     */
    public void enqueue(T item){

        //对于队列来说，从队尾入队
        //通过这种调用setter方法的方式入队，可以省掉一个队列是否为空的判断
        rear.setItem(item);
        rear.setNext(new Node<T>());

        //现在队尾变成了新元素
        rear=rear.next;
    }

    /**
     * 出队，队为空的时候返回null
     * @return
     */
    public T dequeue(){
        if(front.end()){
            //当队列为空的时候
            return null;
        }

        //从队头出队
        T item=front.item;

        //队头元素变成下一项
        front=front.next;

        return item;
    }

}
