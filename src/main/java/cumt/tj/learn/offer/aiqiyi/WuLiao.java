package cumt.tj.learn.offer.aiqiyi;

import java.util.Scanner;

/**
 * Created by sky on 17-10-14.
 */
public class WuLiao {

    //nums种方案
    static int nums;
    //总时间
    static int totalTime;

    public static void getQi(int n,int m){

        if(m<=0){
            //已经都无聊了
            nums++;
            return;
        }

        if(m>=1){

            if(n<=0){
                //可以都选m
                getQi(n,m-2);
                totalTime++;
            }

            if(n>=1) {
                //可以一样选一个
                getQi(n - 1, m - 1);
                totalTime++;
            }

            if(n>1) {
                //可以都选N
                getQi(n - 2, m);
                totalTime++;
            }
        }

        if(m>=2) {

            if (n > 0){
                //可以都选m
                getQi(n, m - 2);
                totalTime++;
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.close();

        getQi(n,m);

        System.out.print(String.format("%.1f",(double)totalTime/nums));

    }

}
