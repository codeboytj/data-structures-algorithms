package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-8-11.
 *
 * 牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，
 * 藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，
 * 根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。
 * 注意，子序列不要求在原字符串中是连续的，
 * 例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。
 *
 * 输出描述:
 * 输出一行 “Yes” 或者 “No” 表示结果。
 *
 * 输入例子1:
 * x.nowcoder.com
 * ooo
 *
 * 输出例子1:
 * Yes
 *
 * 思路：
 * 1. 不要求连续
 *    用2个指针p1与p2，分别指向2个字符串的起始位置
 *    开始遍历
 *    字符不等 p1++，p2不动
 *    字符相等p1++,p2++
 *    如果p2比p1先越界或者同时越界，那么匹配
 *    如果p1比p2先越界，那么不匹配
 */
public class TreasureMap {

    //原字符串与需要判断是否为子序列的字符串
    char[] source;
    char[] sub;
    //检测结果
    boolean result;

    /**
     * 判断是否为子字符串
     */
    public void isSub(){

        int p1=0,p2=0;

        while (true){

            if(p1>=source.length || p2>=sub.length){
                //其中一个越界，p2没越界就不匹配
                result=(p2<sub.length)?false:true;
                return;
            }

            if(source[p1]==sub[p2]){
                p1++;p2++;
            }else{
                p1++;
            }

        }

    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        if(sc.hasNextLine()) source=sc.nextLine().toCharArray();
        if(sc.hasNextLine()) sub=sc.nextLine().toCharArray();

        sc.close();

    }

    public static void main(String[] args) {

        TreasureMap tm=new TreasureMap();

        //读取输入
        tm.readInput();

        //判断是否为子字符串
        tm.isSub();

        System.out.print((tm.result)?"Yes":"No");

        return;

    }

}
