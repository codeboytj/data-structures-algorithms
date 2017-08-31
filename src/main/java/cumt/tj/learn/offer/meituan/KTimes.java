package cumt.tj.learn.offer.meituan;

import java.util.Scanner;

/**
 * Created by sky on 17-8-31.
 */
public class KTimes {

    int[] nums;
    int k;
    int maxLen;
    int length;

    public void solve(){

        //从后往前
        int sum;
        for(int i=length-1;i>=0;i--){

            sum=0;
            for(int j=0;j<length-i;j++){

                sum+=nums[i+j];

                if(maxLen<=(j+1) && sum%k==0) maxLen=(j+1);

            }

        }
    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        //读取数组大小
        int n=sc.nextInt();
        length=n;
        nums=new int[n];

        //读取数组元素
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        //读取k
        k=sc.nextInt();

        sc.close();
    }



    public static void main(String[] args) {

        KTimes kTimes=new KTimes();

        //读取输入
        kTimes.readInput();

        //求解
        kTimes.solve();

        //输出
        System.out.print(kTimes.maxLen);

    }

}
