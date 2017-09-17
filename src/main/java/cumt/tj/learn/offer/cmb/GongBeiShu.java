package cumt.tj.learn.offer.cmb;

import java.util.Scanner;

/**
 * Created by sky on 17-9-13.
 */
public class GongBeiShu {

    static int a,b,n;
    //公倍数个数
    static int nums;

    public static void readInput(){
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        n=sc.nextInt();
        sc.close();
    }

    public static void solve(){

        int max=Math.max(a,b);
        for(int i=max;i<=n;i++){
            if(i%a==0 && i%b==0) nums++;
        }

    }

    public static void main(String[] args) {

        readInput();
        solve();
        System.out.print(nums);


    }

}
