package cumt.tj.learn.offer;

/**
 * Created by sky on 17-10-7.
 *
 * 题目：最长公共子序列
 * 对于两个字符串，请设计一个高效算法，求他们的最长公共子序列的长度，
 * 这里的最长公共子序列定义为有两个序列U1,U2,U3...Un和V1,V2,V3...Vn,
 * 其中Ui&ltUi+1，Vi&ltVi+1。且A[Ui] == B[Vi]。
 *
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 *
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 *
 * 返回：6
 * 公共子序列："123456"，也就是说公共子序列不要求连续
 *
 */
public class LCS {

    private int maxLen;//最长公共子序列长度
    private int[][] ps;

    public int findLCS(String A, int n, String B, int m) {

        ps=new int[n+1][m+1];
        ps[0]=new int[m+1];

        for(int i=1;i<=n;i++){

            ps[i]=new int[m+1];

            for(int j=1;j<=m;j++){

                if(A.charAt(i-1) == B.charAt(j-1))
                    ps[i][j] = ps[i-1][j-1] + 1;
                else {
                    ps[i][j] = Math.max(ps[i-1][j],ps[i][j-1]);
                }
            }
        }

        return ps[n][m];

    }

    public int findChar(String A,int startA,int endA,char b){
        for(int i=startA;i<endA;i++){
            if(A.charAt(i)==b)
                return i;
        }
        return -1;
    }

    public void findLCS(String A, int n, String B, int m,int startB,int posA,int len) {

        //越界
        if(startB==m || posA==n){
            maxLen=(len>maxLen)?len:maxLen;
            return;
        }

        int leftA=n-posA;//A中剩余的长度
        int leftB=m-startB;//B中剩余的长度
        //枝剪，A与B的剩余所有字符都加上都超不过最大长度了
        if(leftA<maxLen-len || leftB<maxLen-len) return;

        //可以要A[posA]，也可以不要
        int firstA=findFirstAInB(B,A.charAt(posA),startB);
        if(firstA!=-1){
            //B中有相应字符
            findLCS(A,n,B,m,firstA+1,posA+1,len+1);
        }

        //也可以不要A[posA]
        findLCS(A,n,B,m,startB,posA+1,len);

    }

    /**
     * 在B[start,length)中找到第一个与a想等的字符
     * @param B
     * @param a
     * @param start
     * @return
     */
    public int findFirstAInB(String B,char a,int start){

        for(int i=start;i<B.length();i++){
            if(B.charAt(i)==a){
                return i;
            }
        }

        return -1;

    }

}
