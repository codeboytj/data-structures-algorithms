package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-5.
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 假设数组中构成矩阵的每个向量的长度都是固定的。。。
 * 思路
 * 1. 对于左上角的点，如果要查找的元素小于它，那么直接可以返回结果，如果要查找的元素大于它，
 * 由于和它同列同行的元素都大于它，所以并不能排除一堆数据。同理右下角的点也不行。
 * 2. 而对于右上角的点，如果要查找的元素小于它，那么可以排除同列元素，如果查找的元素大于它，
 * 那么可以排除同行元素。同理左下角的点也一样。
 * 所以，选取右上角的点开始查找
 */
public class FindIn2DArray {

    public static boolean find(int target, int [][] array) {

        //行数与列数
        int colCount=array[0].length-1;

        //从左上角开始递归
        return inRange(target,array,0,colCount);

    }

    private static boolean inRange(int target,int[][] array,int upperRightRow,int upperRightCol){

        if(upperRightCol<0||upperRightRow>array.length-1){
            return false;
        }

        if(target==array[upperRightRow][upperRightCol]){
            //找到了
            return true;
        } else if(target<array[upperRightRow][upperRightCol]){
            //排除同列元素
            return inRange(target,array,upperRightRow,upperRightCol-1);
        }else {
            //排除同行元素
            return inRange(target,array,upperRightRow+1,upperRightCol);
        }

    }

    public static void main(String[] args) {
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(7,array));
        System.out.println(find(20,array));
    }
}
