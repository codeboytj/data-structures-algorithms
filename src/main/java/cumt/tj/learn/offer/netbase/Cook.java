package cumt.tj.learn.offer.netbase;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sky on 17-8-11.
 * 链接：https://www.nowcoder.com/questionTerminal/ca5c9ba9ebac4fd5ae9ba46114b0f476
 * 来源：牛客网
 *
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
 *
 * 输入描述:
 * 每个输入包含 1 个测试用例。
 * 每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，
 * 输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
 *
 * 输出描述:
 * 输出一行一个数字表示完成所有料理需要多少种不同的材料。
 *
 * 示例1
 *
 * 输入
 * BUTTER FLOUR
 * HONEY FLOUR EGG
 *
 * 输出
 * 4
 *
 * 思路：
 * １．其实就是计算需要多少种材料，重复的算一种
 *
 */
public class Cook {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        Set<String> strSet=new TreeSet<String>();
        while (sc.hasNext()){
            strSet.add(sc.next());
            //默认按Ctrl+D结束输入
        }

        System.out.print(strSet.size());
    }

}
