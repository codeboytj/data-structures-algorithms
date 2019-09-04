package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-5.
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：
 * 由于一个数与它自己进行异或运算结果为0，与别的数异或，结果的二进制中至少有一位1
 * 如果对数组中的每个数求异或，那么最终结果为那两个不相同数的异或结果
 * 而可以根据结果二进制中的不为0的一位把数组分为2组
 * 一组的所有数字二进制该位为1,另一组所有数字该位二进制为0
 * 而且原来的2个不相同的数字被分到了2组
 * 然后分别对每组求异或就能得到原来的2个不同值
 */
public class FindNumsAppearOnce {

    /**
     * num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1 为长度为1的数组。传出参数
     * @param num2 为长度为1的数组。传出参数
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int length;
        if(array==null || (length=array.length)<=1) return;

        //先对数组的每个数求异或
        int result=0;
        for(int i=0;i<length;i++){
            result^=array[i];
        }

        //找到是为1的那一位
        int indexBit=findFirstBitIs1(result);
        num1[0]=0;num2[0]=0;
        for(int i:array){
            if((i & indexBit)==0){
                num1[0]^=i;
            }else{
                num2[0]^=i;
            }
        }

    }


    /**
     * 返回第一位不为0对应的那个数，无法用语言表达清楚，是这样的：
     * 比如0110,返回0010;1111,返回0001
     * @param source
     * @return
     */
    public int findFirstBitIs1(int source){

        //
        int indexBit=1;

        for(int i=0;i<31;i++){
            if((source & indexBit)!=0) break;
            indexBit<<=1;
        }

        return indexBit;

    }

}
