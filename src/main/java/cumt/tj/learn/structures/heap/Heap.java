package cumt.tj.learn.structures.heap;

/**
 * Created by sky on 17-6-17.
 */
public interface Heap<T>{
    //插入
    void insert(T t);
    //删除最小元
    T deleteMin();
}
