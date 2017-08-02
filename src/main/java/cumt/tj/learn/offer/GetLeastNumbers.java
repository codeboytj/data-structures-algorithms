package cumt.tj.learn.offer;

import java.util.ArrayList;

/**
 * Created by sky on 17-8-2.
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 * 思路：根据快排的partition函数，将大于枢纽元素的都移到左边，小于枢纽元素的都移到右边
 * 对于大小排名第k的元素，重排之后，前k个就是需要的数组
 */
public class GetLeastNumbers {

    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {

        ArrayList<Integer> numbers=new ArrayList<Integer>();

        if(input==null || k<=0 || k>input.length) return numbers;

        int start=0;int end=input.length-1;
        int index=partition(input,start,end,end);

        while (index!=k-1){

            //重排之后，还不是第k-1个元素
            if(index<k-1){
                //对右边的重排
                start=index+1;
                index=partition(input,start,end,end);
            }else {
                end=index-1;
                index=partition(input,start,end,end);
            }

        }

        for (int i=0;i<k;i++){
            numbers.add(input[i]);
        }

        return numbers;

    }

    /**
     * 对于数组中的第pivotIndex个元素，重排数组，使得该元素左边都小于它，右边都大于它
     * 返回重排后该元素的索引
     * @param inputs 待重排数组
     * @param start 起始索引
     * @param end 结束索引
     * @param pivotIndex 选取的元素
     * @return 重排后该元素索引
     */
    public int partition(int[] inputs,int start,int end,int pivotIndex){

        if(start==end) return start;

        //将第一个元素与pivotIndex换位
        int tmp=inputs[start];inputs[start]=inputs[pivotIndex];inputs[pivotIndex]=tmp;

        //start指针后移与end形成2个指针
        int fore=start+1;int behind=end;

        if(end-start==1 && inputs[fore]>inputs[start]) return pivotIndex;

        while (true){

//            //如果fore指针的元素小于标杆元素，那元素不动，fore后移
            while (fore<end && inputs[fore]<=inputs[start]) fore++;
//            //如果behind指针的元素大于标杆元素，那元素不动，behind后移
            while (behind>start && inputs[behind]>=inputs[start]) behind--;

            if(fore<behind){
//            //如果fore指针的元素大于标杆元素，且behind指针小于标杆元素，那两元素交换，fore后移，behind前移
                tmp=inputs[fore];inputs[fore]=inputs[behind];inputs[behind]=tmp;
            }else {
//            //在不交叉的情况下循环
                break;
            }

        }

        //然后标杆元素与fore互换，那么左边的就是小于标杆的
        tmp=inputs[start];inputs[start]=inputs[behind];inputs[behind]=tmp;

        return behind;

    }

    public static void main(String[] args) {

        GetLeastNumbers leastNumbers=new GetLeastNumbers();
        int[] array;
        array=new int[]{4,5,1,6,2,7,3,8};
        System.out.println(leastNumbers.getLeastNumbers(array,4));
        System.out.println(leastNumbers.partition(array,0,array.length-1,0));
        array=new int[]{3,2,5,3,1,7,5};
        System.out.println(leastNumbers.getLeastNumbers(array,4));
        System.out.println(leastNumbers.partition(array,0,array.length-1,3));

        array=new int[]{2,1};
        System.out.println(leastNumbers.getLeastNumbers(array,1));
        System.out.println(leastNumbers.partition(array,0,array.length-1,1));

        array=new int[]{1,2};
        System.out.println(leastNumbers.getLeastNumbers(array,2));
        System.out.println(leastNumbers.partition(array,0,array.length-1,1));

        array=new int[]{1,2};
        System.out.println(leastNumbers.partition(array,0,array.length-1,0));

        return;

    }

}
