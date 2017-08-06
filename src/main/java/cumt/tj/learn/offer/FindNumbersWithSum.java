package cumt.tj.learn.offer;

import java.util.ArrayList;

/**
 * Created by sky on 17-8-6.
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 思路：
 * 假设没有相同的元素
 * halfSum=sum/2
 * 在数组中找到halfSum的索引，如果没有，找到刚好比它大的index
 * 设置2个指针，指向index-1与index
 * 遍历，如果和小于sum，那么后指针后移，前指针不动
 * 如果和大于sum，那么前指针前移，后指针不动
 * 如果相等，存储乘积最小值的2个数，然后前后指针都移动寻找下一个
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result=new ArrayList<Integer>();
        int length;
        if(array==null || (length=array.length)<=1) return result;

        int halfSum=sum/2;
        int index=-1;
        for(int i=0;i<length;i++){
            if(array[i]>=halfSum){
                index=i;
                break;
            }
        }
        //都小于sum的一半或者都大于等于sum的一半
        if(index<=0) return result;
        int min=-1;
        int forePos=index-1;int behindPos=index;int tmpSum;
        while (forePos>=0 && behindPos<length){
            tmpSum=array[forePos]+array[behindPos];
            if (tmpSum>sum){
                forePos--;
            }else if (tmpSum<sum){
                behindPos++;
            }else{
                if(min==-1){
                    min=array[forePos]*array[behindPos];
                    result.add(0,array[forePos]);
                    result.add(1,array[behindPos]);
                }else {
                    if (array[forePos] * array[behindPos] < min) {
                        result.set(0, array[forePos]);
                        result.set(1, array[behindPos]);
                    }
                }
                forePos--;
                behindPos++;
            }
        }

        return result;

    }

}
