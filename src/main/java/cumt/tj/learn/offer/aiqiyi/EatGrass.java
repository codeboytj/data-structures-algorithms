package cumt.tj.learn.offer.aiqiyi;

import java.util.Scanner;

/**
 * Created by sky on 17-10-14.
 */
public class EatGrass {

    static int[] designs;

    public static void solve(){
        for(int i=0;i<designs.length;i++){
            int flag=1;
            int init=0x40000000;
            while (init>0){
                while (designs[i]-init>0){
                    designs[i]-=init;
                    flag*=-1;
                }
                init>>>=2;
            }
            if(flag==1){
                System.out.println("niu");
            }else{
                System.out.println("yang");
            }
        }
    }

    public static void main(String[] args) {
        //读取输入
        Scanner sc=new Scanner(System.in);
        designs=new int[Integer.parseInt(sc.nextLine())];
        for(int i=0;i<designs.length;i++){
            designs[i]=Integer.parseInt(sc.nextLine());
        }
        solve();
    }

}
