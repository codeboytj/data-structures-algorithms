package cumt.tj.learn.algorithms.sort;

import java.io.*;

/**
 * Created by sky on 17-4-26.
 */
public class BitArraySort {
    /**
     * 编程珠玑第一章，位矢量排序实现
     * @param inputFile 输入文件名
     * @param n 位向量中的位数，即带排序中的最大数为n-1
     * @param outputFile 输出文件名
     */
    public void sort(String inputFile,int n,String outputFile) throws IOException {
        //临时变量
        int i;int j;

        //使用char类型来实现位向量，因为java中的基本类型中只有它是无符号整数
        //需要count个char才能表示所有带排序的数
        //参考数组，用来通过按位与操作判断第m位是否为1，从而得到该位是否有整数
        //还有一个用处是将整数相应位设为1时，通过和参考数组的按位或运算进行
        char[] caoKao=new char[16];
        //数组的第16个元素的第16位为1
        //0000 0000 0000 0001
        caoKao[15]=1;
        for(j=14;j>=0;j--){
            //一次进行移位操作，第j个元素的第j位为1
            caoKao[j]= (char) (caoKao[j+1] << 1);
        }
        int count =n / 16+1;

        //1.初始化数组，将所有的位都置为0
        //char貌似默认值就是0吧？
        char[] chars=new char[count];

        //2.读入文件的每个整数，将每个对应的位都置为1
        BufferedReader in =new BufferedReader(new FileReader(inputFile));
        String s;
        while ((s=in.readLine())!=null){
            i=Integer.parseInt(s);
            //第(i/16)个char的第i%16位设为1，如读取的是15,那么第0个char的第15位设为1;如读取的是199,那么第199/16=12个char的第199%16=7为设为1
            j=i / 16;
            chars[j] = (char) (chars[j]|caoKao[i%16]);
        }
        in.close();

        //3.输出排序结果，如果该位为1,就输出对应的整数
        BufferedWriter out = null;
        out =new BufferedWriter(new FileWriter(outputFile));
        for(i=0;i<chars.length;i++){
            for(j=0;j<=15;j++){
                if((chars[i] & caoKao[j])!=0){
                    out.write(Integer.toString((i)*16+(j))+"\n");
                }
            }
        }
        out.close();
    }
}
