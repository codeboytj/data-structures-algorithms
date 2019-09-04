package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-3.
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 *
 * 思路：采用递归的思想，如：对于1～1356中1出现的次数。可以这样算：
 * 分为1~356和356~1356两段
 * 1. 对于356～1356这一段：
 *      最高位出现1的次数为1000～1356：356次
 *      而356～1356中，根据排列组合原理，剩下的后3位中1出现的次数可以把任一为设为1,其它位在0~9之中取值
 *      即3×10^2=300次
 * 2. 对于1~356这一段：
 *      进行递归
 */
public class NumberOf1Between1AndN {

    public int numberOf1Between1AndN(int n) {

        if(n<=0) return 0;

        //先求n的位数
        int m=getNumbers(n);
        return numberOf1Between1AndN(1,n,m);

    }

    public int numberOf1Between1AndN(int start,int end,int m){

        //对于一位数
        if(m==1){
            return (end==0)?0:1;
        }

        //对于多位数
        //继续分割
        int pivot=end%((int)Math.pow(10,m-1));
        //第一部分
        int times=0;
        if(pivot!=0) {
            times = numberOf1Between1AndN(1, pivot, m - 1);
        }
        //第二部分
        int highest=end/((int)Math.pow(10,m-1));
        times+=(highest==1)?(pivot+1):((int)Math.pow(10,m-1));
        times+=highest*(m-1)*(int)Math.pow(10,m-2);

        return times;

    }

    /**
     * 返回位数，比如123为3位数
     * @param n
     * @return
     */
    public int getNumbers(int n){

        //先求n的位数
        int m=n;
        int numbers=1;
        while (m>=10){
            m=m/10;
            numbers++;
        }
        return numbers;

    }

}
