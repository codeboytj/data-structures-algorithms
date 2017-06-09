package cumt.tj.learn.structures.hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sky on 17-6-7.
 * 平方探测法的散列
 */
public class QuadraticProbingHashTable<K,V> {

    //首先，他要有一个数组存数据，而且这个数组存的东东是包含key与value的元组
    ArrayList<HashEntry> hashTable;
    //然后，调用默认构造器的时候，他的这个数组应该有个默认长度，而且默认长度为素数
    private static final int DEFAULT_SIZE=11;
    //记录当前数组的大小
//    private int currentLength;
    //记录当前有多少个元素，它指的是不为null的元素个数
    private int currentSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
//        hashTable=new ArrayList<HashEntry>(size);
//        currentLength=size;
        //先给一个null，不然插元素的时候总是越界
//        for(int i=0;i<size;i++){
//            hashTable.add(i,null);
//        }

        allocateArray(size);
    }

    /**
     * 添加元素，这个做的可能有很多bug，通过修改原来为null的元素插入数据
     * @param key 娃哈哈……
     * @param value 娃哈哈……
     */
    public void put(K key,V value){

        HashEntry entry=new HashEntry(key,value);

        //先找到坑
        int availablePos=findPos(entry);

        //踩进去
        hashTable.set(availablePos,entry);
        currentSize++;

        //平方探测时，当表有一半是空的，且表的大小是素数，那么就能保证总能够插入一个新元素
        if(currentSize>hashTable.size()/2) reHash();
    }


    /**
     * 删除元素，同样通过将引用设为null删除，可能有bug
     * @param key 键
     */
    public void remove(K key){

        HashEntry entry=new HashEntry(key,null);

        //找到这个元素
        int pos=findPos(entry);

        //通过将引用设为null删除
        hashTable.set(pos,null);
    }

    /**
     * 根据key获取值
     * @param key 猜猜我是干啥的
     * @return 不知道算了
     */
    public V get(K key){
        int pos=findPos(key);

        HashEntry theOne=hashTable.get(pos);
        if(theOne!=null){
//            有对应的value存在
            return theOne.value;
        }

        return null;
    }

    /**
     * 查看是否已经存在以key为键的键值对
     * @param key
     * @return
     */
    public boolean contains(K key){

        int pos=findPos(key);

        return hashTable.get(pos)!=null;
    }

    private void reHash(){
        List<HashEntry> oldArray=hashTable;

        //首先它要造一个数组，是原来的2倍大小（离2倍最近的素数）
        allocateArray(SeparateChainingHashTable.nextPrime(oldArray.size()*2));

        //然后，要让原来数组里面的元素，利用重新插入到新数组里面（表的大小变化了，会影响hash值与探测，所以要重新插入）
        Iterator<HashEntry> iterator=oldArray.iterator();
        while (iterator.hasNext()){
           HashEntry item=iterator.next();
            if(item!=null){
                put(item.key,item.value);
            }
        }

    }

    private void allocateArray(int length){
        hashTable=new ArrayList<HashEntry>(length);

        //先给一个null，不然插元素的时候总是越界
        for(int i=0;i<length;i++){
            hashTable.add(i,null);
        }

        //现在表中没有元素了
        currentSize=0;
    }

    public int findPos(K key){
        return findPos(new HashEntry(key,null));
    }

    /**
     * 找到元素的位置，已经存在了就找到存在的位置，没有存在就找到需要插入到的位置
     * @param entry 娃哈哈
     * @return 娃哈哈
     */
    public int findPos(HashEntry entry){

        //往下面探测的时候的偏移值
        int offset=1;

        //先计算哈希值
        int currentPos=myHash(entry);
        //然后看看列表中这个哈希值为索引的位置是不是已经有东东了
        HashEntry existOne=hashTable.get(currentPos);
        while (existOne!=null && !existOne.equals(entry)){
            //这个位置上已经有东东，并且这两个东东不一样
            //这就要往后面探测了
            //这里用的是平方值，但是书里面用的是“快速方法”，直接给offset加了一个2
            currentPos= (int) (currentPos+Math.pow(offset,2)- Math.pow((offset-1),2));
            offset++;

            //超过数组索引了，托回去继续找
//            if(currentPos>=hashTable.size()){
//                currentPos-=hashTable.size();
//            }
            if(currentPos>=hashTable.size()){
                currentPos-=hashTable.size();
            }

            //现在探测到的位置上的东东
            existOne=hashTable.get(currentPos);
        }

        return currentPos;

    }

    int myHash(HashEntry entry){

        //根据hashEntry的hashCode计算哈希值
        int hashCode=entry.hashCode();
        return myHash(hashCode);

    }

    int myHash(int hashCode){
        hashCode %= hashTable.size();
//        hashCode %= currentLength;
        if(hashCode<0){
            hashCode +=hashTable.size();
//            hashCode +=currentLength;
        }

        return hashCode;
    }

    private class HashEntry{
//        private class HashEntry{
//
        K key;
        V value;

        public HashEntry() {
        }

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HashEntry hashEntry = (HashEntry) o;

            return key != null ? key.equals(hashEntry.key) : hashEntry.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }
    }

}
