package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sky on 17-8-28.
 *
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 思路：
 * 使用一个两端开口的队列，只存储有可能成为最大值的元素
 * 构建初始队列：
 *         对于窗口大小n=3，pos=0，首先将2的index=0存入队列，此时队列为{0}
 *                          然后pos=1，对于3>2，2已经不可能是最大值了，将0移除，将1加入队列，此时{1}
 *                          然后pos=2，对于4>3，3已经不可能是最大值了，将1移除，将2加入队列，此时{2}
 *         此时的最大值为num[2]
 * 开始滑动：
 *         此时pos=3，由于3-2<n=3，不用将2移除；由于num[3]<num[2]，然而在2滑出之后，3是有可能成为最大值的，
 *         所以将3加入队列{2,3}
 *         此时pos=4，由于4-2<n=3，然而num[4]>num[2]，所以2与3都不可能是最大值了，队列变为：{4}
 *         以此类推
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        int length=num.length;
//        不合法输入
        if(num==null) return null;

        //不合法输入
        ArrayList<Integer> list=new ArrayList<Integer>(length-size+1);
        if(size<=0 || size>length) return list;

        //构造初始队列
        LinkedList<Integer> deque=initDeque(num, size);

        int max=num[deque.getFirst()];
        list.add(max);

        //开始滑动
        for(int i=size;i<length;i++){

            if((i-deque.get(0))>=size) {
                //头元素在窗口之外了，出队
                deque.removeFirst();
            }

            if(max<=num[i]){
                //当前元素最大，队列清空，当前元素入队
                deque.clear();
                deque.add(i);
            }else {
                //当前元素并不是最大，但是有可能在最大元素出栈之后最大
                while (deque.size()>0 && num[deque.getLast()]<=num[i]){
                    deque.removeLast();
                }
                deque.add(i);
            }

            max=num[deque.getFirst()];
            list.add(max);

        }


        return list;
    }

    public LinkedList<Integer> initDeque(int[] num,int size){

        LinkedList<Integer> deque=new LinkedList<Integer>();
        deque.add(0);

        //当前最大值
        int max=num[0];
        for(int i=1;i<size;i++){
            if(max<=num[i]){
                deque.clear();
                max=num[i];
                deque.add(i);
            }else{
                deque.add(i);
            }
        }

        return deque;

    }

}
