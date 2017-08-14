package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-8-12.
 */
public class Series {

    //n个整数，[1,k]范围内
    int n,k;
    int[] numbers;
    int max;

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc = new Scanner(System.in);

        //读取输入
        n=sc.nextInt();
        k=sc.nextInt();
        //初始化整数数组
        numbers=new int[n];

        sc.close();

    }

    /**
     * 判断是否为喜欢的数列
     * 测试是否满足第三个条件
     * @return
     */
    public boolean isLiked(){

        for(int i=0;i<n-1;i++){

            if(numbers[i]<=numbers[i+1] || numbers[i]%numbers[i+1]!=0){
                return true;
            }else{
                return false;
            }

        }

        //n=1的时候,或者满足第三个条件的时候
        return true;

    }

    /**
     * 求解
     */
    public void solve(){

        //利用全排列，然后判断每一个数列是否合乎要求
        for(int m=0;m<n;m++) {

            for(int r=1;r<=k;r++){

                numbers[m]=r;
                //其他位置
                for (int i = 0; i < n; i++) {

                    for (int j = 1; j <= k; j++) {
                        numbers[i] = j;
                        //到目前为止，满足了2个条件
                    }

                    if(i==(m-1)) i++;

                }
                if (isLiked()) {
                    max++;
                    if(max>=1000000007) max=max%1000000007;
                }

            }
        }

    }

    public static void main(String[] args) {

        Series series=new Series();

        //读取输入
        series.readInput();
        //求解
        series.solve();

        System.out.print(series.max);

    }

}
