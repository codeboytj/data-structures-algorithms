package cumt.tj.learn.offer.netbase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sky on 17-8-10.
 *  给定一个 n 行 m 列的地牢，
 *  其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，
 *  牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，
 *  和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，
 *  要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 *  地牢的出口可能在任意某个可以通行的位置上。
 *  牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
 *
 * 输入描述:
 * 每个输入包含 1 个测试用例。
 * 每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。
 * 接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。
 * 接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），
 * 出发位置一定是 '.'）。
 * 之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，
 * 接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
 *
 * 输出描述:
 * 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，
 * 如果永远无法离开，输出 -1。
 * 以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，
 * 地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
 *
 * 输入例子1:
 * 3 3
 * ...
 * ...
 * ...
 * 0 1
 * 4
 * 1 0
 * 0 1
 * -1 0
 * 0 -1
 *
 * 输出例子1:
 * 3
 *
 * 思路：
 * １．递归
 *     从入口有k种走法，
 *          走到X舍去
 *          走到'.'，是边界的话，比较步数是不是大于最大值，这条路停止
 *                  不是边界的话，继续K中走法
 *     但问题是到了边界之后，有可能不是出口，还需要继续走
 * 2. 重新分析题目
 *      出口在任意可通行位置上，而不仅仅是在边界的可通行的位置上
 *      题目所说的最坏情况，其实是指的，最坏的出口的最小步数，也就是最小步数最大的出口的最小步数
 *      题目所指的永远无法离开，指的是如果有某一个'.'无法到达，那么如果这个点是出口的时候，就永远无法离开
 */
public class EscapeDungeon {

    //行数与列数
    int n,m;
    //地牢
    char[][] dungeon;
    //起点
    int x0,y0;
    //合法的步法数
    int k;
    //合法的步法矩阵
    int[][] footworks;
    //最大步数
    int max=-1;
    //所有可能的出口的最小步数
    int[][] min;

    /**
     * 递归实现，运行成功，但是对于一些情况，超过了内存限制
     * 需要将递归转换成循环或者动态规划
     */
    public void escape(){

        //当前位置
        int x=x0,y=y0;
        //当前步数
        int currentSteps=0;

        //递归求解
//        escape(x,y,currentSteps);

        //循环求解
        cycleEscape();

        //找出最坏情况
        findMax();

    }

    /**
     * 循环求解
     * 将递归转换为循环，通过了所有测试用例
     */
    public void cycleEscape(){

        //初始位置
        int x=x0,y=y0;
        //初始步数
        int currentSteps=0;
        //存储当前起点
        List<int[]> cSP=new ArrayList<int[]>();
        cSP.add(new int[]{x,y});

        //循环中使用的当前位置
        int cx,cy;
        //循环中使用的记录每一个起点的k种步法的步数
        int[] steps;
        int size=cSP.size();
        //存储下一次循环的起点
        List<int[]> help;

        while (size>0){

            //帮助数组
            help=new ArrayList<int[]>();
            for(int j=0;j<size;j++){
                //当前从这么多个点出发

                //从当前位置k种走法
                steps=new int[k];
                for(int i=0;i<k;i++){
                    //当前位置
                    cx=cSP.get(j)[0];cy=cSP.get(j)[1];
                    currentSteps=min[cx][cy];
                    //走一步后的位置
                    cx+=footworks[i][0];
                    cy+=footworks[i][1];

                    //如果越界
                    if(cx<0 || cx>=n || cy<0 || cy>=m){
                        //如果越界，那么此路不通
                        //下一步循环
                        continue;
                    }

                    //如果是'.'，每个'.'都是可能边界
                    if(dungeon[cx][cy]=='.'){
                        steps[i]=currentSteps+1;
                        int prevMin=min[cx][cy];
                        if(steps[i]<prevMin || prevMin==0){
                            //还没有初始化或者
                            //如果达到该可能边界的步数小于之前存储的，那么替换
                            min[cx][cy]=steps[i];
                            //存储下一个循环的起点
                            help.add(new int[]{cx,cy});
                        }else{
                            //如果达到该可能边界的步数大于等于之前存储的，那么舍弃这条路
                        }
                    }else{
                        //如果是'X'，那么舍弃
                        //将最优步数设为－１，最后好判断
                        min[cx][cy]=-1;
                    }
                }

            }

            cSP=help;help=null;size=cSP.size();

        }
    }

    /**
     * 找到最坏情况
     */
    public void findMax(){

        int tmp;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tmp=min[i][j];
                if(min[i][j]==-1){
                    //这是可以到达的'X'点
                }else if(min[i][j]==0){
                    //这是无法到达的
                    if(dungeon[i][j]=='.'){
                        //如果这个点是＇．＇
                        //那么这是最坏情况
                        if(i!=x0 || j!=y0){
                            //出发点除外
                            max=-1;
                            return;
                        }
                    }else{
                        //如果是'x'，不管它
                    }
                }else{
                    //可以到达的'.'点
                    max=(tmp>max)?tmp:max;
                }
            }
        }

    }

    /**
     * @param x
     * @param y
     * @param currentSteps
     */
    public void escape(int x,int y,int currentSteps){

        //步数
        int[] steps=new int[k];
        //每一种走法后的位置
        int cx,cy;

        //从当前位置k种走法
        for(int i=0;i<k;i++){
            //走一步后的位置
            cx=x+footworks[i][0];
            cy=y+footworks[i][1];

            //如果越界
            if(cx<0 || cx>=n || cy<0 || cy>=m){
                //如果越界，那么此路不通
                //下一步循环
                continue;
            }

            //如果是'.'，每个'.'都是可能边界
            if(dungeon[cx][cy]=='.'){
                steps[i]=currentSteps+1;
                int prevMin=min[cx][cy];
                if(steps[i]<prevMin || prevMin==0){
                    //还没有初始化或者
                    //如果达到该可能边界的步数小于之前存储的，那么替换
                    min[cx][cy]=steps[i];
                    escape(cx,cy,steps[i]);
                }else{
                    //如果达到该可能边界的步数大于等于之前存储的，那么舍弃这条路
                }
            }else{
                //如果是'X'，那么舍弃
                //将最优步数设为－１，最后好判断
                min[cx][cy]=-1;
            }
        }
    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        //行数与列数
        if (sc.hasNextLine()) {
            n=sc.nextInt();
            m=sc.nextInt();
            sc.nextLine();
        }

        //读取地牢矩阵
        dungeon=new char[n][];
        //最优步数矩阵与地牢矩阵的大小一样，dungeon中'X'对应的位置虽然分配了内存，但是其实没用
        min=new int[n][];
        for (int i = 0; i < n; i++) {

            if (sc.hasNextLine()) {
                dungeon[i]=sc.nextLine().toCharArray();
                min[i]=new int[dungeon[i].length];
            }

        }

        //读取起点
        if (sc.hasNextInt()){
            //行数与列数
            x0=sc.nextInt();y0=sc.nextInt();
        }

        //合法的步法数
        if(sc.hasNextInt()){
            k=sc.nextInt();
        }

        //读取步法矩阵
        footworks=new int[k][];
        for(int i=0;i<k;i++){

            footworks[i]=new int[2];
            if(sc.hasNextLine()){
                for(int j=0;j<2;j++){
                    footworks[i][j]=sc.nextInt();
                }
            }

        }

        sc.close();

//        testReadInput();

    }

    /**
     * 测试读取输入函数是否成功
     */
    public void testReadInput(){

        System.out.println(n+" "+m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dungeon[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println(x0+" "+y0);
        System.out.println(k);
        for(int i=0;i<k;i++){
            for(int j=0;j<2;j++){
                System.out.print(footworks[i][j]+" ");
            }
            System.out.print("\n");
        }

    }

    public static void main(String[] args) {

        EscapeDungeon ed=new EscapeDungeon();

        //读取输入
        ed.readInput();

        ed.escape();

        System.out.print(ed.max);

    }

}
