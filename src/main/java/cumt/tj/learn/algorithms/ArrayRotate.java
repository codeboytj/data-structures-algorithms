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
