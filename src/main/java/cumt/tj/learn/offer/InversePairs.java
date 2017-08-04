package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-4.
 *
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * Note:题目保证输入的数组中没有的相同的数字
 *
 * 思路：
 * 剑指Offer神奇归并排序版
 */
public class InversePairs {

    public int inversePairs(int [] array) {

        int leftPos=0,rightPos;
        if(array==null || (rightPos=array.length)<=1) return 0;

        int[] helpArray=new int[rightPos];

        return preventBeyond(inversePairs(array,leftPos,rightPos,helpArray));

    }

    public int inversePairs(int[] array,int leftPos,int rightPos,int[] helpArray){

        //当前只有1个元素
        if(rightPos-leftPos<=1) return 0;

        int sum=0;
        //当前部分只有2个元素
        if(rightPos-leftPos==2){
            //无相等元素
            if(array[leftPos]>array[rightPos-1]){
                //逆序，需要交换位置
                helpArray[rightPos-1]=array[leftPos];
                helpArray[leftPos]=array[rightPos-1];
                sum= 1;
            }else {
                helpArray[rightPos-1]=array[rightPos-1];
                helpArray[leftPos]=array[leftPos];
            }
        }else{
            //有多个
            int center=(leftPos+rightPos)/2;

            //先递归计算逆序对总数
            sum=inversePairs(array,leftPos,center,helpArray);
//                    %1000000007;
            sum=preventBeyond(sum);
            sum+=inversePairs(array,center,rightPos,helpArray);
            sum=preventBeyond(sum);
//            sum%=1000000007;

            //再排序
            //2个指针，分别指向2部分末尾
            int foreRight=center;
            int behindRight=rightPos;
            int helpPos=behindRight;

            while (foreRight>leftPos && behindRight>center){
                //2边都还没有遍历完

                if(array[foreRight-1]>array[behindRight-1]){
                    //左边的更大
                    helpArray[helpPos-1]=array[foreRight-1];
                    foreRight--;
                    //加上右边还剩下的个数
                    sum+=behindRight-center;
                    sum=preventBeyond(sum);
//                    sum%=1000000007;
                }else {
                    //右边的更大
                    helpArray[helpPos-1]=array[behindRight-1];
                    behindRight--;
                }
                helpPos--;

            }

            //如果左边还没有遍历完
            while(foreRight>leftPos){
                //左边的一次性复制过来
                helpArray[helpPos-1]=array[foreRight-1];
                foreRight--;helpPos--;
            }

            //如果右边的还没有遍历完
            while (behindRight>center){
                helpArray[helpPos-1]=array[behindRight-1];
                behindRight--;helpPos--;
            }

        }

        //将辅助数组里面的复制到原数组
        for(int i=leftPos;i<rightPos;i++){
            array[i]=helpArray[i];
        }

        return sum;

    }

    private int preventBeyond(int i){
        if(i>=1000000007){
            i=i%1000000007;
        }
        return i;
    }

}
