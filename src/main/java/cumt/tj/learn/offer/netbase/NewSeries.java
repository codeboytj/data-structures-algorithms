package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-9-9.
 */
public class NewSeries {

    //数列数
    static int n;
    //数列
    static int[][] series;
    //数列中的2的倍数但非4的倍数的个数
    static int[] times2;
    //数列中的4的倍数的个数
    static int[] times4;
    //非4非2倍数的个数
    static int[] n2n4;
    //结果
    static String[] result;

    public static void solve(){

        for(int i=0;i<n;i++){
            if(times4[i]-times2[i]>=n2n4[i]-1){
                result[i]="Yes";
            }else{
                result[i]="No";
            }
        }

    }

    public static void readInput(){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        series=new int[n][];
        result=new String[n];
        times2=new int[n];
        times4=new int[n];
        n2n4=new int[n];
        int tmp;
        for(int i=0;i<n;i++){
            tmp=sc.nextInt();
            series[i]=new int[tmp];
            for(int j=0;j<tmp;j++){
                series[i][j]=sc.nextInt();
                if(series[i][j]%2==0){
                    if(series[i][j]%4==0){
                        times4[i]++;
                    }else{
                        times2[i]++;
                    }
                }else{
                    n2n4[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {

        //读取输入
        readInput();
        solve();
        for(String s:result){
            System.out.println(s);
        }

    }

}
