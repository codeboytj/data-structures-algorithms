package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-29.
 *
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 *
 *
 */
public class MovingCount {

    public int movingCount(int threshold, int rows, int cols)
    {

        //不合法输入
        if(rows<0 || cols<0 || threshold<0) return 0;

        boolean[][] isArrived=new boolean[rows][cols];

        movingCount(threshold,0,0,rows,cols,isArrived);

        //计算有多少个能到达的格子
        int sum=0;
        for(boolean[] ii:isArrived){

            for (boolean i:ii){
                if(i) sum++;
            }

        }

        return sum;

    }

    public void movingCount(int threshold,int rowPos,int colPos, int rows, int cols,boolean[][] isArrived){

        //是否越界
        if(rowPos<0 || rowPos>=rows || colPos<0 || colPos>=cols) return;

        //查看是否已经到过这一格
        if(isArrived[rowPos][colPos]) return;

        //查看是否能到这格
        if(canArrived(rowPos,colPos,threshold)){

            isArrived[rowPos][colPos]=true;

            //对上下左右进行递归
            movingCount(threshold, rowPos+1, colPos, rows, cols, isArrived);
            movingCount(threshold, rowPos-1, colPos, rows, cols, isArrived);
            movingCount(threshold, rowPos, colPos+1, rows, cols, isArrived);
            movingCount(threshold, rowPos, colPos-1, rows, cols, isArrived);

        }

    }

    /**
     * 判断是否能到达指定方格
     * @param rowPos
     * @param colPos
     * @param threshold
     * @return
     */
    public boolean canArrived(int rowPos,int colPos,int threshold){

        int sum=0;

        while (true){
            sum+=rowPos%10;
            if((rowPos/=10)==0) break;
        }

        while (true){
            sum+=colPos%10;
            if((colPos/=10)==0) break;
        }

        return sum<=threshold;

    }

}
