package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-8.
 * 题目： 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后
 * 半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 思路：
 *      1. 将数组A复制一份儿得到数组B，方便操作
 *          在B头尾各设一个指针fore,back，同时移动
 *          如果fore遇到奇数，奇数个数negativeCount加1,将A[negativeCount]变为fore遇到的奇数
 *          如果back遇到偶数，偶数个数positiveCount加1,将A[A.length-positiveCount]变为back遇到的偶数
 *          直到fore与back越界为止
 */
public class ReOrderArray {

    public void reOrder(int[] array){
        //复制数组
        int[] newArray=new int[array.length];
        System.arraycopy(array,0,newArray,0,array.length);

        //首尾指针
        int fore=0;
        int back=array.length-1;
        int positiveCount=0;
        int negativeCount=0;

        //
        while (fore<array.length && back>=0){
            if(!isEven(newArray[fore])){
                //fore遇到奇数
                array[negativeCount++]=newArray[fore];
            }
            if(isEven(newArray[back])){
                array[array.length-(++positiveCount)]=newArray[back];
            }
            fore++;
            back--;
        }

    }

    /**
     * 判断是否为偶数
     * 对于正数，如果number/2=(number-1)/2，那么为奇数
     * 对于负数，如果number/2=(number+1)/2，那么为奇数
     * 0为偶数
     * @param number
     * @return
     */
    public boolean isEven(int number){
        if(number==0) {
            return true;
        }else if(number>0) {
            return (number / 2) != (number - 1) / 2;
        }else{
            return (number/2)!=(number+1)/2;
        }
    }

    public static void main(String[] args){
        ReOrderArray reOrderArray=new ReOrderArray();
        System.out.println(reOrderArray.isEven(2));
        System.out.println(reOrderArray.isEven(4));
        System.out.println(reOrderArray.isEven(-4));
        System.out.println(reOrderArray.isEven(3));
        System.out.println(reOrderArray.isEven(1));
        System.out.println(reOrderArray.isEven(0));
        System.out.println(reOrderArray.isEven(-2));
        System.out.println(reOrderArray.isEven(-1));
        System.out.println(reOrderArray.isEven(-3));
//        int[] array={1,2,3,-2,4,-3,6};
        int[] array={1,2,3,4,5,6,7};
        reOrderArray.reOrder(array);
//        System.out.print(array);
        for (int i:array
             ) {
            System.out.print(i);
        }
    }

}
