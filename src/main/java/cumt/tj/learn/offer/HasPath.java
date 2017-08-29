package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-29.
 *
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 */
public class HasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        if(matrix==null || str==null) return false;

        char[][] matrix2=new char[rows][cols];

        for(int i=0;i<rows;i++){

            for(int j=0;j<cols;j++){
                matrix2[i][j]=matrix[cols*i+j];
            }

        }

        return hasPath(matrix2,0,0,str,0,new boolean[rows][cols]);

    }

    public boolean hasPath(char[][] matrix2,int rowPos,int colPos,char[] str,int strPos,boolean[][] isArrived){

        //查看字符串是否已经遍历结束
        if(strPos==str.length) return true;

        //否则，查看下标越界情况
        if(rowPos>=matrix2.length || rowPos<0 || colPos<0 || colPos>=matrix2[0].length) return false;

        //然后，查看这个点是不是已经到过了
        if(isArrived[rowPos][colPos]) return false;

        //查看(rowPos,colPos)
        if(matrix2[rowPos][colPos]==str[strPos]){
            isArrived[rowPos][colPos]=true;
            //查看它的上下左右
            if(hasPath(matrix2,rowPos,colPos+1,str,strPos+1,isArrived)||
                    hasPath(matrix2,rowPos,colPos-1,str,strPos+1,isArrived)||
                    hasPath(matrix2,rowPos+1,colPos,str,strPos+1,isArrived)||
                    hasPath(matrix2,rowPos-1,colPos,str,strPos+1,isArrived)){
                return true;
            }else{
                //上下左右都不是正确路线
                isArrived[rowPos][colPos]=false;
            }
        }else if(strPos!=0){
            return false;
        }

        //矩阵中的下一个点
        if(colPos==matrix2[0].length-1){
            //已经到一行的边界
            return hasPath(matrix2, rowPos+1, 0, str, strPos,isArrived);
        }else{
            return hasPath(matrix2, rowPos, colPos+1, str, strPos,isArrived);
        }

    }

}
