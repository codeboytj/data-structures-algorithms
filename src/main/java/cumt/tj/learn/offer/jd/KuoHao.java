package cumt.tj.learn.offer.jd;

import java.util.Scanner;

/**
 * Created by sky on 17-9-8.
 * 京东笔试：拆括号问题,通过100%测试
 */
public class KuoHao {

    static char[] serie;
    static int length;
    static int nums;
    static boolean[] isCuted;

    public static void solve(int first){

        while (first<length && serie[first]==')') {
            first++;
        }

        if(first==length){
            nums++;
            return;
        }

        //利用2个指针，用于判断左括号的下一个字符是否为右括号
        int second;
        second=first+1;

        if(serie[second]!=')' || isCuted[second]){
            //下一个不为右括号或这下一个为右括号但是已经被拆
            //对于剩余的n个右括号有n种拆法
            for(int i=second+1;i<length;i++){
                if(serie[i]==')' && !isCuted[i]){
                    //i为右括号，且还没有被拆
                    isCuted[i]=true;
                    solve(first+1);
                    isCuted[i]=false;
                }
            }
        }else{
            //下一个为右括号且没有被拆
            isCuted[second]=true;
            solve(first + 1);
            isCuted[second]=false;
        }
    }

    /**
     * 读取输入
     */
    public static void readInput(){

        Scanner sc=new Scanner(System.in);
        serie=sc.nextLine().toCharArray();
        isCuted=new boolean[serie.length];
        length=serie.length;
        sc.close();

    }

    public static void main(String[] args) {

        readInput();
        solve(0);
        System.out.println(nums);

    }

}

//import java.util.Scanner;
//
///**
// * Created by sky on 17-9-8.
// */
//public class Main {
//
//    static char[] serie;
//    static int nums=1;
//
//    public static void solve(){
//
//        //左括号数
//        int leftNum=serie.length/2;
//        //利用2个指针，用于判断左括号的下一个字符是否为右括号
//        int first=0,second=1;
//
//        while (true){
//
//            while (serie[first]==')') {
//                first++;
//                second++;
//            }
//
//            if(serie[second]!=')'){
//                //下一个不为右括号
//                nums*=leftNum;
//            }else{
//                nums*=1;
//            }
//            first++;second++;
//            leftNum-=1;
//
//            if(leftNum<=0) break;
//
//        }
//
//    }
//
//    /**
//     * 读取输入
//     */
//    public static void readInput(){
//
//        Scanner sc=new Scanner(System.in);
//        serie=sc.nextLine().toCharArray();
//        sc.close();
//
//    }
//
//    public static void main(String[] args) {
//
//        readInput();
//        solve();
//        System.out.println(nums);
//
//    }
//
//}
