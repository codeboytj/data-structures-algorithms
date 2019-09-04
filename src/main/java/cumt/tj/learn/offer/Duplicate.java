package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-9.
 *
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 思路：
 * 1. 利用额外的长为n的数组，索引为Index的位置上存index出现的次数
 *    这样一次遍历存储每个数字的次数
 *    第二次遍历辅助数组，找不为>1的返回索引
 *    这样需要一个o(n)的空间和o(n)的时间复杂度
 * 2. 如果原数组可以修改的话，可以在o(1)的空间和o(n)的时间复杂度，下完成
 *    利用原数组都是大于等于0的特点
 *    利用数组元素0～n-1范围刚好是索引的特点
 *    一次遍历
 *    如果index位的数字是n
 *      如果a[index]>=0
 *          如果a[n]>=0，那么a[index]=a[n]，a[n]=-1
 *          如果a[n]<0，就说明index索引上的已经出现了一次了，那么直接返回
 *      如果a[index]<0，那么进行下一个
 */
public class Duplicate {
    /**
     *
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
                      Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
                    这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * @return true if the input is valid, and there are some duplications in the array number
                         otherwise false
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if(numbers==null || length==0) return false;

        int number;
        for(int i=0;i<length;i++){
            number=numbers[i];
            if(number>=0){
                if(numbers[number]>=0){
                    numbers[i]=numbers[number];
                    numbers[number]=-1;
                    i--;
                }else{
                    duplication[0]=number;
                    return true;
                }
            }else {
                continue;
            }
        }

        return false;

    }

}
