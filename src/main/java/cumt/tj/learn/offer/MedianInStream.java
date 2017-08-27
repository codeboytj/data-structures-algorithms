package cumt.tj.learn.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sky on 17-8-27.
 *
 * 题目描述
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 思路：
 * 最大、最小堆
 *
 */
public class MedianInStream {

    //最小堆
    PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    //最大堆
    PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {

        if(isOod()){

            //如果当前是第偶数个
            if(maxHeap.peek()>num){
                //如果小于最大堆中的元素
                //先插入到最大堆
                maxHeap.offer(num);
                //然后将最大堆的最大元素插入到最小堆
                minHeap.offer(maxHeap.poll());
            }else {
                //否则直接插入到最小堆
                minHeap.offer(num);
            }

        }else{

            //如果当前是第奇数个
            if(maxHeap.size()!=0 && minHeap.peek()<num){
                //如果大于最小堆中的元素
                //先插入到最小堆
                minHeap.offer(num);
                //然后将最小堆的最小元素插入到最大堆
                maxHeap.offer(minHeap.poll());
            }else {
                //否则直接插入到最小堆
                maxHeap.offer(num);
            }

        }

    }

    public Double GetMedian() {

        if(isOod()){
            return (double)maxHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }

    }

    /**
     * 判断当前数组中已有元素总数是否为奇数
     * @return
     */
    private boolean isOod(){
        return (minHeap.size()+maxHeap.size())%2!=0;
    }

}
