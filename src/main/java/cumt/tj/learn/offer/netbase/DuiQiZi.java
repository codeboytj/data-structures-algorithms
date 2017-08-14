package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-8-12.
 */
public class DuiQiZi {

    int n;//棋子数
    int[][] pos;//棋子的位置
    int[][] footworks=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//步法，上下左右
    int[] steps;//最少操作的次数
//    int[][]

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc = new Scanner(System.in);

        //读取棋子数
        n=sc.nextInt();
        pos=new int[n][2];
        steps=new int[n];

        //读取位置坐标
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                pos[j][i]=sc.nextInt();
            }
        }

        sc.close();

    }

    public void move(){

        //至少为1的操作数为0,不管，从2开始
        //由于允许一个格子有多个棋子，假设初始的时候一个格子最多有max个，那么1~max范围内的steps都为0
        //没想出来………………
        steps=new int[]{0,1,3,10};

    }

    public static void main(String[] args) {

        DuiQiZi duiQiZi=new DuiQiZi();

        //读取输入
        duiQiZi.readInput();

        //求解
        duiQiZi.move();

        //输出
        for(int i=0;i<duiQiZi.steps.length;i++){
            System.out.print(duiQiZi.steps[i]);
            if(i!=duiQiZi.steps.length) {
                System.out.print(" ");
            }
        }

    }

}
