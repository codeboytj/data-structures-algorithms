package cumt.tj.learn.offer.jd;

import java.util.Scanner;

/**
 * Created by sky on 17-9-8.
 * 京东笔试：有趣的幂运算问题,通过20%测试
 */
public class FannyPower {

    static int n;
    static long nums;
    static boolean[] isCom;

    public static void solve(){

        double newBase;
        //对于底数为1的情况
        nums+=n*n;
        if(nums>=1000000007) nums=nums%1000000007;
        for(int i=2;i<=n;i++){
            if(isCom[i-1]) continue;
            for(int j=1;j<=n;j++){
                //i的j次方
                //先不考虑1
                //首先对j进行整除
                for(int k=1;k<=j;k++){
                    if(j%k==0){
                        //k能被j整除
                        //那么i^j=(i^k)(j/k)
                        newBase=Math.pow(i,k);
                        if(newBase<=(double)n){
                            nums++;
                            if(!isCom[(int)newBase-1])isCom[(int)newBase-1]=true;
                        }
                    }
                }
                if(nums>=1000000007) nums=nums%1000000007;
            }
        }

    }

    public static void main(String[] args) {

        //读取输入
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.close();
        isCom=new boolean[n];
        solve();
        System.out.print(nums);

    }

}
