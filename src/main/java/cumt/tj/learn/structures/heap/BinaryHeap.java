package cumt.tj.learn.structures.heap;

/**
 * Created by sky on 17-6-15.
 */
public class BinaryHeap<T extends Comparable<? super T>> implements Heap<T>{
    //由于PECS原则，Comparable需要写成Comparable<? super T>

    //由于二叉堆是一个完全二叉树，它能够用数组来实现
    T[] theHeap;
    //堆的默认大小
    private static final int DEFAULT_SIZE=10;
    //记录当前堆中的元素个数
    int currentSize;

    public BinaryHeap() {
        this(DEFAULT_SIZE);
    }

    public BinaryHeap(int size) {
        theHeap=(T[])new Comparable[size];
    }

    /**
     * 采用上滤的方式，往堆中插入元素
     * @param t 要插入的元素
     */
    public void insert(T t) {

        //暂时不考虑数组被塞满的情况

        //插入位置为当前元素个数加一，这种情况对于没有元素的时候也适用
        int hole=++currentSize;
        for(theHeap[0]=t;t.compareTo(theHeap[hole/2])<0;hole=hole/2){
            //当父节点大于要插入元素的时候
            //不断上滤，将父节点下放
            theHeap[hole]=theHeap[hole/2];
        }
        //最后满足了堆序性质，可以把元素插进来了
        theHeap[hole]=t;

    }

    /**
     * 删除最小元素
     * @return 最小元素
     */
    public T deleteMin() {

        if(currentSize<=0) throw new RuntimeException("当前堆中没有任何元素");

        //二叉树的根就是最小元素
        T min=theHeap[1];

        //然后，将最后一个元素放到根的位置，并将currentSize减1
        theHeap[1]=theHeap[currentSize--];

        //这样，开始将不满足堆序性质的根下滤
        siftDown(1);

        return min;

    }

    /**
     * 下滤算法，对于不满足堆序性质的theHeap[hole,currentSize]，如果theHeap[hole+1,currentSize]满足堆序性质，那么可以将
     * theHeap[hole]下滤，得到满足堆序性质与结构性质的堆theHeap[hole,currentSize]。
     * @param hole 不满足堆序性质的元素的索引
     */
    protected void siftDown(int hole){

        int child;
        T tmp=theHeap[hole];

        while (true){
            child=hole*2;

            //终止条件1：没有子结点
            if(hole*2>currentSize) break;

            //找到最小的子结点
            if((child+1)<=currentSize&&theHeap[child].compareTo(theHeap[child+1])>0)
                child++;

            //终止条件2：最小的子结点都大于父结点
            if(theHeap[child].compareTo(theHeap[hole])>=0) break;

            //交换父节点与子结点
            theHeap[hole]=theHeap[child];theHeap[child]=tmp;
            hole=child;
        }
    }
}
