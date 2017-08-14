package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-8-12.
 */
public class DuliYi {

    int x;//房屋租金
    int f;//已有水果
    int d;//已有现金
    int p;//水果单价
    long max;//最长生活天数

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc = new Scanner(System.in);

        x=sc.nextInt();
        f=sc.nextInt();
        d=sc.nextInt();
        p=sc.nextInt();

        sc.close();

    }

    /**
     * 经过分析，题目其实是解不等式方程的最大整数解
     * (max-f)*p+x*max<=d
     * max<=((d+f*p)/(p+x))
     */
    public void solve(){

//        max=(int)((d+(long)f*p)/(p+x));
//        max=(int)Math.floor((double)((d+(long)f*p)/(p+x)));
        max=(long)Math.floor((double)((d+(long)f*p)/(p+x)));
        //max=(int)Math.floor((double)(d+f*p)/(p+x));

    }

    public static void main(String[] args) {

        DuliYi duliYi=new DuliYi();

//        long max=2*1000000000*1000000000;
//        System.out.print(2*1000000000);
//        System.out.print(Integer.MAX_VALUE);

        //读取输入
        duliYi.readInput();

        //求解
        duliYi.solve();

        //输出
        System.out.print(duliYi.max);

    }

}
