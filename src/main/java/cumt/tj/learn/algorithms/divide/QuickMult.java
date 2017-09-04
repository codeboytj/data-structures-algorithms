package cumt.tj.learn.algorithms.divide;

/**
 * Created by sky on 17-9-4.
 *
 * 参考博客:http://www.cnblogs.com/luruiyuan/p/5570756.html
 *
 * 快速乘法的基本思想 ，是二进制和乘法分配律的结合，（不由得想起浮点数不满足结合律，严重吐槽！！！╮(╯-╰)╭），
 * 比如说，13 ==（1101）2  ，4*13等于4*（1101）2 ，用分配律展开得到4*13 == 4*（1000+100+1）2，
 * 我们不难观察出，快速幂可以通过判断当前的位（bit）是1还是0，推断出是否需要做求和操作，
 * 每次移动到下一位（bit）时，就对ans进行*2操作，等待是否求和。
 * 由于除以2和位移操作是等效的，因此这也可以看作是二分思想的应用，
 * 这种算法将b进行二分从而减少了不必要的运算，时间复杂度是log（n）。
 *
 */
public class QuickMult {

    /**
     * 快速乘法
     * @param a
     * @param b
     * @return
     */
    public long qmul(long a,long b){

        //refer作为需要拆分成二进制和的参照
        long base=a,refer=b;
        if(Math.abs(a)<Math.abs(b)){
            //取较小者为参照
            base=b;refer=a;
        }

        //最后的结果
        long result=0;
        while ((refer!=0)&&(refer!=Long.MIN_VALUE)){

            if((refer & 1)==1){
                //末位为1，需要利用惩罚分配律相加
                result+=base;
            }

            //移位,refer不带符号右移
            refer>>>=1;base<<=1;

        }

        return result;

    }

}
