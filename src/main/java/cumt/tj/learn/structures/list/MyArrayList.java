package cumt.tj.learn.structures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sky on 17-7-1.
 * 表的数组实现，它需要实现以下功能：
 * 1. 表的基本操作：add、remove、get、set以及size等
 * 2. 需要实现一种数组扩容的机制，应对数组被塞满的情况
 * 3. 实现Iterable接口的功能，这可能需要提供一个实现Iterator接口的内部类
 */
public class MyArrayList<T> implements Iterable<T>{

    //内部实现列表的数组
    private T[] theList;
    //首先，数组应该有一个默认长度
    private static final int DEFAULT_SIZE=10;
    //存储当前数组中元素个数
    private int theSize;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        theList= (T[]) new Object[size];
    }

    /**
     * 设置指定位置的元素值
     * @param index 元素的索引
     * @param t 元素
     * @return 该位置原来的元素
     */
    public T set(int index,T t){

        if(index<0||index>theSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        T theOld=theList[index];
        theList[index]=t;

        return theOld;

    }

    /**
     * 返回指定位置的元素
     * @param index 元素的索引
     * @return
     */
    public T get(int index){

        if(index<0||index>theSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        return theList[index];

    }

    /**
     * 删除列表末尾的元素
     * @return 被删除的元素
     */
    public T remove(){
        return remove(theSize-1);
    }

    /**
     * 删除列表指定位置的元素
     * @param index 要删除元素的索引
     * @return 被删除的元素
     */
    public T remove(int index){
        T theOne=theList[index];theList[index]=null;
        //将[index+1,theSize)部分前移一个位置
        for (int i=index;i<theSize-1;i++){
            theList[i]=theList[i+1];
        }
        //这样就成功地删除了元素
        theSize--;
        return theOne;
    }

    /**
     * 返回列表中元素个数
     * @return 列表中的元素个数
     */
    public int size(){
        return theSize;
    }

    /**
     * 往表的末尾插入新元素
     * @param t 要插入的元素
     */
    public void add(T t){
        //相当于往数组最后插入元素
        add(theSize,t);
    }

    /**
     * 往表的指定位置上插入新元素
     * @param index 要插入元素的索引
     * @param t 要插入的元素
     */
    public void add(int index,T t){
        //当数组已经满了
        if(theSize==theList.length){
            //数组扩容
            ensureCapacity(theSize*2);
        }

        if(index<0||index>theSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        //在Index位置插入
        //需要将原数组的[Index,theSize)整体后移一位
        for (int i=theSize-1;i>=index;i--){
            theList[i+1]=theList[i];
        }
        //然后将t插入到index位置
        theList[index]=t;
        //这样，成功地插入一个元素
        theSize++;
    }

    /**
     * 数组扩容
     * @param newCapacity 新容量
     */
    private void ensureCapacity(int newCapacity){

        if(newCapacity<theSize) return;

        T[] theOld=theList;
        theList=(T[])new Object[newCapacity];
        //将原数组的元素移动到新数组
        for(int i=0;i<theSize;i++)
            theList[i]=theOld[i];

    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public class ArrayListIterator implements Iterator<T>{

        //它里面肯定存了一个表示当前位置的索引
        private int currentPos=0;

        public boolean hasNext() {
            return currentPos<theSize;
        }

        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return theList[currentPos++];
        }

        public void remove() {
            MyArrayList.this.remove(--currentPos);
        }
    }
}
