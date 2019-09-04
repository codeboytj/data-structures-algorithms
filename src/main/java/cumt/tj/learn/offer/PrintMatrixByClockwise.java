package cumt.tj.learn.offer;

import cumt.tj.learn.structures.list.MyArrayList;

import java.util.ArrayList;

/**
 * Created by sky on 17-7-29.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrixByClockwise {

    private static ArrayList<Integer> printMatrixByClockwise(int[][] matrix){

        int rows;int columns;

        //矩阵为空
        if(matrix==null) return null;
        //没有行、列
        if((rows=matrix.length)<=0) return null;
        if((columns=matrix[0].length)<=0) return null;

        int start=0;
        ArrayList<Integer> integers=new ArrayList<Integer>();

        while (rows>start*2 && columns>start*2){

            printSingleCircle(matrix,rows,columns,start,integers);
            start++;

        }

        return integers;

    }

    /**
     * 打印一圈
     * @param matrix
     * @param rows
     * @param columns
     * @param start
     */
    private static void printSingleCircle(int[][] matrix,int rows,int columns,int start,ArrayList<Integer> integers){

        //行终点与列终点（索引）
        int endColumn=columns-1-start;
        int endRow=rows-1-start;

        //如果列终点不小于列起点，可以进行第一步
        for(int i=start;i<=endColumn;i++){
            integers.add(matrix[start][i]);
        }

        //如果行终点不小于行起点，可以进行第二步
        for(int i=start+1;i<=endRow;i++){
            integers.add(matrix[i][endColumn]);
        }

        //如果行终点不小于行起点，并且列终点大于列起点,可以进行第二步
        if(endRow>start && endColumn>start){
            for (int i=endColumn-1;i>=start;i--){
                integers.add(matrix[endRow][i]);
            }
        }

        //如果行终点大于行起点+1、列终点大于列起点可以进行第二步
        if(endRow>start+1 && endColumn>start){
            for (int i=endRow-1;i>start;i--){
                integers.add(matrix[i][start]);
            }
        }

    }

    public static void main(String[] args) {
        System.out.print(printMatrixByClockwise(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
    }


}
