package cumt.tj.learn.algorithms.divide;

/**
 * Created by sky on 17-9-5.
 *
 * 矩阵快速幂
 *
 * 与快速幂类似，不同在于整数相乘变为矩阵相乘
 *
 */
public class QuickMatrixPow {

    /**
     * 矩阵快速求幂
     * @param base
     * @param pow
     * @return
     */
    public int[][] quickMatrixPow(int[][] base,int pow){

        int[][] result=new int[base.length][base[0].length];

        for(int i=0;i<base.length;i++){
            result[i][i]=1;
        }

        while (pow!=0 && pow!=Integer.MIN_VALUE){

            if((pow & 1)==1){
                result=matrixMult(result,base);
            }

            pow>>>=1;base=matrixMult(base,base);

        }

        return result;

    }

    /**
     * 矩阵相乘
     * @param a
     * @param b
     * @return
     */
    public int[][] matrixMult(int[][] a,int[][] b){

        //首先A的列数需要等于B的行数
        int rowA=a.length,colA=a[0].length;
        int rowB=b.length,colB=b[0].length;
        if(colA!=rowB){
            throw new RuntimeException("矩阵a的列数不等于b的行数");
        }

        //生成的矩阵行数等于a的行数，列数等于b的列数
        int[][] result=new int[rowA][colB];

        //计算乘积
        for(int i=0;i<rowA;i++){
            for(int j=0;j<colB;j++){
                for(int k=0;k<colB;k++){
                    result[i][j]+=a[i][k]*b[k][j];
                }
            }
        }

        return result;

    }

}
