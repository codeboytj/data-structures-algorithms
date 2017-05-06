package cumt.tj.learn.algorithms;

/**
 * Created by sky on 17-4-28.
 */
public class ArrayRotate {
    //编程珠玑第2章问题B:将一个n元向量向左旋转i个位置。例如，当n=8且i=3时，向量abcdefgh旋转为defghabc。简单的代码使用一个n元中间向量在n步内完成工作。能否仅使用数十个额外字节的存储空间，在正比于n的时间内完成向量的旋转？

    /**
     * 杂技旋转，>_>，如将n=9位向量x=abcdefghi向左旋转rotdist=3位成defghiabc
     * 1.先将x[0]移动到临时变量t
     * 2.然后移动x[rotdist]至x[0];移动x[2rotdist]至x[rotdist]，一次类推，直至取回t中的元素，第一轮旋转完毕
     * 3.先将x[1]移动到临时变量t
     * 4.然后移动x[rotdist+1]至x[1];移动x[2rotdist+1]至x[rotdist+1]，依次类推，直至取回t中的元素，第二轮旋转完毕
     * 5.依次类推，直至第rotdist轮旋转完毕
     * @param s 待旋转的字符串
     * @param rotdist 需旋转rotdist
     */
    public String acrobaticsRotate(String s,int rotdist){
        int n=s.length();
        char[] t=s.toCharArray();
        //需要进行最大公约数轮旋转
        for(int j=0;j<gcd(n,rotdist);j++){
            char tmp=t[j];
            int pre=j;
            int k;
            while (true){
                k=pre+rotdist;
                if(k>=n){
                    //这一步是怎么想到的呢？真是精妙
                    k-=n;
                }
                if(k==j){
                    break;
                }
                t[pre]=t[k];
                pre=k;
            }
            t[pre]=tmp;
        }
        return String.copyValueOf(t);
    }

    /**
     * 块旋转算法：旋转向量x就是交换向量ab的位置，得到向量ba。这里a代表了x中的前i个元素。假设a比b短，将b分为b1与b2，是的b2具有
     * a相同的长度。交换a与b2，也就将ab1b2转换成b2b1a。这是，a就处于最终的位置了，因此现在的问题就是交换b的两部分了。由于新问题与
     * 元问题有相同的形式，就能够递归地解决了。
     * @param s 要旋转的向量
     * @param rotdist 旋转rotdist位置
     * @return 最终结果
     */
    public String blockRotate(String s,int rotdist){
        //在[0,s.length())范围内操作
        //整个问题是将[startPC,rotdist)与[rotdist,endPC)互换
        int startPC=0;int endPC=s.length();
        char[] t=s.toCharArray();
        singleBlockRotate(t,startPC,rotdist,endPC);
        return String.copyValueOf(t);
    }

    /**
     * 将数组x的a向量(x[startPC,rotdist))与b向量(x[rotdist,endPC])互换
     * @param t 初始向量
     * @param startPC 起始位置
     * @param rotdist 向左rotdist-startPC位
     * @param endPC 结束位置
     */
    public void singleBlockRotate(char[] t,int startPC,int rotdist,int endPC){
        //左右两边向量长度
        int leftLen=rotdist-startPC;int rightLen=endPC-rotdist;

        //比较左右两边长度
        int compareResult=rightLen-leftLen;
        /*
        偏移位
        如果后段大于前段，则交换a[startPC,rotdist)与b[rotdist+offset,endPC);
        如果后段小于前段，则交换a[startPC,singleLen)与b[rotdist+0,endPC)。
         */
        int offset=0;
        if (compareResult>0){
            offset=rightLen-leftLen;
        }
        //每次交换的长度
        int singleLen=rightLen-offset;

        //互换首尾两端
        char tmp;
        for(int i=0;i<singleLen;i++){
            tmp=t[startPC+i];t[startPC+i]=t[rotdist+offset+i];t[rotdist+offset+i]=tmp;
        }

        //此时，进行递归
        if(compareResult>0){
            singleBlockRotate(t,startPC,rotdist,rotdist+compareResult);
        }else if(compareResult==0){
            return;
        }else {
            singleBlockRotate(t,rotdist+compareResult,rotdist,endPC);
        }
    }

    /**
     * 求最大公约数的欧几里得算法
     * @param i ，不为0的整数
     * @param j，不为0的整数
     * @return i与j的最大公约数
     */
    public int gcd(int i,int j){
        while (i!=j){
            if (i>j){
                i-=j;
            }else {
                j-=i;
            }
        }
        return i;
    }
}
