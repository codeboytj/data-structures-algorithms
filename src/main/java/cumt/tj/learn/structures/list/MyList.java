package cumt.tj.learn.structures.list;

/**
 * Created by sky on 17-7-4.
 */
public interface MyList<T> extends Iterable<T> {
    /**
     * 设置指定位置的元素值
     * @param index 元素的索引
     * @param t 元素
     * @return 该位置原来的元素
     */
    public T set(int index,T t);

    /**
     * 返回指定位置的元素
     * @param index 元素的索引
     * @return
     */
    public T get(int index);

    /**
     * 删除列表末尾的元素
     * @return 被删除的元素
     */
    public T remove();

    /**
     * 删除列表指定位置的元素
     * @param index 要删除元素的索引
     * @return 被删除的元素
     */
    public T remove(int index);

    /**
     * 返回列表中元素个数
     * @return 列表中的元素个数
     */
    public int size();

    /**
     * 往表的末尾插入新元素
     * @param t 要插入的元素
     */
    public void add(T t);

    /**
     * 往表的指定位置上插入新元素
     * @param index 要插入元素的索引
     * @param t 要插入的元素
     */
    public void add(int index,T t);
}
