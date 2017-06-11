package cumt.tj.learn.structures.queue;

import java.lang.reflect.Array;

/**
 * Created by sky on 17-6-11.
 * 队列的循环数组实现，这个是固定长度的队列
 * 这里面通过数组实现，又使用了泛型，所以在使用构造函数的时候需要传入class与长度两个变量
 * 在遇到从空队列取值和往满队列插入元素的时候，使用抛出异常的方法结束程序
 */
public class CircularArrayQueue<T> {

    T[] theQueue;
    //开头元素的索引
    int front;
    //队尾元素的索引
    int rear;
    //记录当前队列中的元素个数
    int currentSize;

    public CircularArrayQueue(Class<T> clz,int length) {
//        this.theQueue;
        theQueue= (T[]) Array.newInstance(clz,length);
    }

    /**
     * 插入元素
     * 当队尾元素已经到数组边界之后，采用循环数组的方式实现
     * 当队列元素已满，就抛出异常
     * @param item
     */
    public void enqueue(T item){

        //增加之后可能队尾索引会超出数组最大索引，使用循环数组方式解决
        int length=theQueue.length;
        if(rear>=length){
            rear-=length;
        }
        //可能队尾与队头索引重叠，这是说明元素已经满了，就是说
        if(currentSize>=length){
            //这时是让队头元素弹出来，还是让数组变大，还是报个错呢？
            //先让它报个错吧
            throw new RuntimeException("超出了队列大小");
        }

        //往队尾插入元素
        theQueue[rear]=item;

        //队尾元素索引与队列中的元素都要增1
        rear++;currentSize++;
    }

    /**
     * 弹出队头元素
     * 当队列中没有元素的时候，抛出异常
     * @return
     */ public T dequeue(){

        //队列为空
        if(currentSize<=0){
            throw new RuntimeException("队列为空");
        }

//        从队头取出元素
        T item=theQueue[front];

//        队头索引后移，当前元素数目减一
        front++;currentSize--;

        return item;
    }

//    private void reSize(){
//        这个和哈希的再散列的逻辑有点儿像
//        T[] oldQueue=theQueue;
//

//
//        把原来的元素再插入到新的队列
//    }
}
