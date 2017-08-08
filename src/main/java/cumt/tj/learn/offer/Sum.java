package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-8.
 * 题目描述
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 思路：
 * 1. 递归，行不通，因为需要用If判断结束条件
 * 2. 等差数列公式，行不通，需要用到乘除法
 * 3. 使用两次取反运算，决定终止递归或者继续运行，因为只有!!0=false，其它都为true。
 *      但是java里面是不支持int转换为boolean的
 *      可以用一个大小为n的int数组a取代,由于数组的初始值为0，因此我们将a[0]设置-1
 *      调用函数的时候使用(a[n]+1)取代!!n
 */
public class Sum {

    Decide[] decides=new Decide[]{new Terminate(),new Continue()};

    public interface Decide{
        int sum(int n,int[] flags);
    }

    public class Terminate implements Decide{
        public int sum(int n,int[] flags){
            return 0;
        }
    }

    public class Continue implements Decide{
        public int sum(int n,int[] flags){
            return decides[flags[n-1]+1].sum(n-1,flags)+n;
        }
    }

    public int sum(int n) {

        int[] flags=new int[n];
        flags[0]=-1;

        return decides[1].sum(n,flags);

    }

}
