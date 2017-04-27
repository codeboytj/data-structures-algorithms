package cumt.tj.learn.algorithms.search;

/**
 * Created by sky on 17-4-27.
 */
public class BinarySearch {
    /**
     *对有序序列进行查找，返回元素在序列中的位置
     *取中间元素，与待查找数做比较，如果相等，则return元素所在位置;如果大于待查找数，则取左半边序列进行递归查找;如果小于待查找数，则取右半边序列进行递归查找。
     * @param a 待查找的有序序列
     * @param b 待查找的数
     * @param startPC 当前查找范围的起始索引，这样做是为了避免使用临时数组，减少内存开销
     * @param endPC 当前查找范围的结束索引，这样做是为了避免使用临时数组，减少内存开销
     * @return 如果没有找到，返回-1;找到的话返回相应索引
     */
    public int sort(int[] a,int b,int startPC,int endPC){
        if(endPC<startPC) return -1;
        int center= (endPC+startPC)/2;
        if (a[center]==b){
            return center;
        }else if(a[center]>b){
            return sort(a,b,startPC,center-1);
        }else {
            return sort(a,b,center+1,endPC);
        }
    }

    public int sort(int[] a,int b){
        return sort(a,b,0,a.length-1);
    }
}
