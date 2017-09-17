package cumt.tj.learn.offer.cmb;

import java.util.Scanner;

/**
 * Created by sky on 17-9-13.
 */
public class ChoosePerson {

    static int m;
    static int[] heights;
    static boolean[] isChoosed;
    static long[] heightSum;
    static long average;
    static long heightA;
    static long heightB;

    public static void readInput(){
        Scanner sc=new Scanner(System.in);
        m=Integer.valueOf(sc.nextLine());
        heights=new int[m];
        isChoosed=new boolean[m];
        heightSum=new long[m];
        for(int i=0;i<m;i++){
            heights[i]=sc.nextInt();
        }
        long sum=0;
        for(int i=m-1;i>=0;i--){
            sum+=heights[i];
            heightSum[i]=sum;
        }
        average=sum/2;
        sc.close();
    }

    public static boolean solve(){

        return solve(m);

    }

    public static boolean solve(int left){

        if(left<=0){
            //已经没有了
            return heightA>heightB;
        }

        if(heightA>average) return true;
        if(heightB>average) return false;

        //当前最左
        int leftPos=m-left;

        //不可能超过B的高度了
        if(heightA+heightSum[leftPos]<=heightB) return false;

        long tmpA=heightA;
        long tmpB=heightB;

        if(left>=4) {
            //A2B2
            heightA+=heights[leftPos]+heights[leftPos+1];
            heightB+=heights[leftPos+2]+heights[leftPos+3];
            if(solve(left - 4)) return true;
            heightA=tmpA;heightB=tmpB;
        }

        if(left>=3) {
            //A1B2
            heightA+=heights[leftPos];
            heightB+=heights[leftPos+2]+heights[leftPos+1];
            if(solve(left - 3)) return true;
            heightA=tmpA;heightB=tmpB;
            //A2B1
            heightA+=heights[leftPos]+heights[leftPos+1];
            heightB+=heights[leftPos+2];
            if(solve(left - 3)) return true;
            heightA=tmpA;heightB=tmpB;
        }

        if(left>=2) {
            //A1B1
            heightA+=heights[leftPos];
            heightB+=heights[leftPos+1];
            if(solve(left - 2)) return true;
            heightA=tmpA;heightB=tmpB;
            //A2B0
            heightA+=heights[leftPos]+heights[leftPos+1];
            if(solve(left - 2)) return true;
            heightA=tmpA;heightB=tmpB;
        }

        if(left==1){
            //A1B0
            heightA+=heights[leftPos];
            if(solve(left - 1)) return true;
            heightA=tmpA;heightB=tmpB;
        }

        return false;

    }

    public static void main(String[] args) {

        readInput();
        System.out.print(solve());

    }
}
