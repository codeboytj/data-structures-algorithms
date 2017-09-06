package cumt.tj.learn.algorithms.backtracking;

import java.util.Scanner;

/**
 * Created by sky on 17-9-6.
 *
 * 链接：https://www.nowcoder.com/questionTerminal/728fcf136ca1488b8043c82fd2b181da
 * 来源：牛客网
 *
 * 网易2017春招笔试真题：工作安排
 * 现在有n位工程师和6项工作(编号为0至5)，
 * 现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。
 * 现在需要进行工作安排，
 * 每位工程师只能被安排到自己能够胜任的工作当中去，
 * 两位工程师不能安排到同一项工作当中去。
 * 如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，
 * 现在需要计算出有多少种不同工作安排计划。
 *
 * 输入描述:
 * 输入数据有n+1行：
 * 第一行为工程师人数n(1 ≤ n ≤ 6)
 * 接下来的n行，每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)
 *
 * 输出描述:
 * 输出一个整数，表示有多少种不同的工作安排方案
 *
 * 示例1
 * 输入
 * 6
 * 012345
 * 012345
 * 012345
 * 012345
 * 012345
 * 012345
 *
 * 输出
 * 720
 *
 * 思路：题目说了一大堆没说明白，意思是：
 * 每位工程师都要有工作安排，
 * 每个工作只要一个人
 */
public class WorkArrangement {

    //工程师人数
    int n;
    //工程师
    Engineer[] engineers;
    //方案总数
    int ways;
    //没有任务的工程师数与剩余的工作数
    int leftWork=6,leftEngineer;
    //任务
    boolean[] isDone=new boolean[6];

    public void solve(){
        solve(0);
    }

    public void solve(int engineerIndex){

        if(engineerIndex>=n){
            ways++;return;
        }

        //当前工程师
        Engineer currentEngineer=engineers[engineerIndex];

        for(int i=0;i<6;i++){
            //查看当前工程师能够做的工作
            if(currentEngineer.canDos[i]){
                if(!isDone[i]) {
                    //这个工作还没有人做
                    //他可以做这个任务
                    leftWork--;
                    isDone[i] = true;
                    solve(engineerIndex+1);
                    //也可以不做
                    leftWork++;
                    isDone[i] = false;
                }
            }
        }

    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        n=Integer.valueOf(sc.nextLine());
        engineers=new Engineer[n];
        leftEngineer=n;

        for(int i=0;i<n;i++){
            engineers[i]=new Engineer(sc.nextLine());
        }

        sc.close();

    }

    public static void main(String[] args) {

        WorkArrangement wa=new WorkArrangement();

        wa.readInput();
        wa.solve();

        System.out.print(wa.ways);

    }

    class Engineer{

        //能完成的任务数
        int canDoNums;
        //是否已经有任务
        boolean isBusy;
        //能完成的任务列表
        boolean[] canDos=new boolean[6];

        public Engineer(String skills) {
            canDoNums= skills.length();
            for(char s:skills.toCharArray()){
                canDos[s-'0']=true;
            }
        }
    }

}
