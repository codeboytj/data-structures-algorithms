package cumt.tj.learn.offer;

import java.util.ArrayList;

/**
 * Created by sky on 17-8-1.
 * 题目描述:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 思路：
 * 对于c，有1种排列
 * 对于bc，有2中排列，bc,cb
 * 对于abc，可以分为a与bc、cd，有3×2种排列：abc,acb,bac,cab,bca,cba
 * 所以对于长为n的字符串，排列方式有这么多种:
 * f(n)：
 * 1,n=1
 * f(n-1)*n,n>1
 * 不难看出是个递归问题
 */
public class Permutation {

    public ArrayList<String> permutation(String str) {

        if(str==null ) return null;

        ArrayList<StringBuilder> sbList=new ArrayList<StringBuilder>();
        ArrayList<String> sl=new ArrayList<String>();

        if(str.length()!=0) {

            permutation(str, 0, str.length(), sbList);
            for (StringBuilder sb : sbList) {
                sl.add(sb.toString());
            }
        }

        return sl;

    }

    public void permutation(String str,int start,int length,ArrayList<StringBuilder> result) {

        char currentChar=str.charAt(start);

        //只有一个字符
        if((length-start)<=1) {
            result.add(new StringBuilder().append(currentChar));
            return;
        }

        //不止一个字符
        //递归
        permutation(str,start+1,length,result);

        //将当前字符插入
        int size=result.size();
        StringBuilder oldStr;
        StringBuilder newStr;
        for(int i=0;i<size;i++){

            oldStr=result.get(i);
            newStr=new StringBuilder(oldStr);
            //原位置开头加上字符，如bc加上'a'，成为abc
            result.set(i,newStr.insert(0,currentChar));

            //在字符串的其他位置加入字符，并添加到列表末尾
            for (int j=1;j<=oldStr.length();j++){

                //这句话去除一部分重复
//                if(oldStr.charAt(j-1)==currentChar) continue;

                newStr=new StringBuilder(oldStr);
                result.add(newStr.insert(j,currentChar));
            }

        }

    }

    public static void main(String[] args) {

        Permutation permutation=new Permutation();

        System.out.println(permutation.permutation("abcd"));
        System.out.println(permutation.permutation("aa"));
        System.out.println(permutation.permutation("aba"));
        System.out.println(permutation.permutation("abac"));
        System.out.println(permutation.permutation(""));
        System.out.println(permutation.permutation(null));

    }

}
