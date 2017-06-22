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

    public BinaryHeap(T[] array){
        theHeap=array;
        currentSize=array.length-1;
    }

    /**
     * 采用上滤的方式，往堆中插入元素
     * @param t 要插入的元素
     */
    public void insert(T t) {

        //暂时不考虑数组被塞满的情况

        //插入位置为当前元素个数加一，这种情况对于没有元素的时候也适用
        int hole=++currentSize;

        theHeap[hole]=t;

        siftUp(hole);

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
        siftDown(currentSize);

        return min;

    }

    /**
     * 堆排序算法，编程珠玑。
     * 我的实现充满了bug，首先通过构造函数创建的数组的第一个元素x[0]没有意义
     * @return 排好序的数组x[1,n]，x[0]没用
     */
    public T[] sort() {

        //形成满足堆序性质和结构性质的堆
        for(int i=2;i<=currentSize;i++){
            siftUp(i);
        }

        T tmp;
        for(int i=currentSize;i>=2;i--){
            tmp=theHeap[1];
            theHeap[1]=theHeap[i];
            theHeap[i]=tmp;
            siftDown(i-1);
        }

        return theHeap;
    }

    /**
     * 上滤算法
     * @param hole 不满足堆序性质的元素的索引
     */
    private void siftUp(int hole){
        int i=hole;
        T tmp=theHeap[i];
        //
        while (true){
            //到达顶端，结束上滤
            if(i==1) break;
            //如果满足了堆序性质，结束上滤
            int parent=i/2;
            if(theHeap[parent].compareTo(theHeap[i])<=0) break;
            //否则，上滤
            theHeap[i]=theHeap[parent];theHeap[parent]=tmp;
            i=parent;
        }
    }

    /**
     * 下滤算法，对于不满足堆序性质的theHeap[1,n]，如果theHeap[2,n]满足堆序性质，那么可以将
     * theHeap[1]下滤，得到满足堆序性质与结构性质的堆theHeap[1,n]。
     * @param n 不满足堆序性质的元素的索引
     */
    protected void siftDown(int n){

        int hole=1;
        int child;
        T tmp=theHeap[hole];

        while (true){
            child=hole*2;

            //终止条件1：没有子结点
            if(hole*2>n) break;

            //找到最小的子结点
            if((child+1)<=n&&theHeap[child].compareTo(theHeap[child+1])>0)
                child++;

            //终止条件2：最小的子结点都大于父结点
            if(theHeap[child].compareTo(theHeap[hole])>=0) break;

            //交换父节点与子结点
            theHeap[hole]=theHeap[child];theHeap[child]=tmp;
            hole=child;
        }
    }
}
