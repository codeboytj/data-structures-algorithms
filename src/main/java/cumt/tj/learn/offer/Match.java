package cumt.tj.learn.offer;

import java.util.Arrays;

/**
 * Created by sky on 17-8-10.
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 思路：
 * 1. 从前往后遍历（失败）
 *    2个指针strPos与patternPos同时遍历
 *    如果都是正常字符且相等且patternPos后面不是'*'，那么进行下一项
 *    如果遇到patternPos遇到'.'，将'.'变为strPos所指字符
 *    如果都是正常字符且相等且patternPos后面是'*'
 *          如果strPos所指的与patternPos不同，那么patternPos+=2,strPos不动
 *          如果strPos所指的与patternPos相同
 *              如果'*'后面的字符与strPos的字符相同
 *                  那么计算后面与strPos相同字符的长度lp,同时计算strPos开始的该字符长度ls
 *                      如果长度ls<lp，那么不匹配
 *                      如果长度ls>=lp，那么继续遍历相同字符后面的
 *              如果'*'后面的字符不相同，那么patternPos+=2,strPos+=ls
 *    不过是正常字符，且不相等
 *           如果patternPos后面是'*'，那么strPos不动，patternPos++;
 *           如果后面是正常字符，那么不匹配
 *     当然，哪一方下标先越界也是不行的
 * 这样太麻烦了，试一试从后往前遍历：
 *
 * 2. 从后往前遍历（失败）
 *    pattern遇到正常字符，
 *          相等，2个指针往前移;不等，不匹配
 *    pattern遇到'.'，2个指针前移
 *    pattern遇到'*'，patternPos--,strPos不动
 *          如果patternPos遇到'.'或者==str[strPos]，那么strPos与patternPos都前移到!=str[strPos]的位置
 *          如果!=str[strPos]，patternPos--，strPos不动
 *
 * 3.　剑指offer递归版
 */
public class Match {

    public boolean match(char[] str, char[] pattern) {

        return seqMatch(str,0,pattern,0);

    }

    public boolean seqMatch(char[] str,int sStart,char[] pattern,int pStart){

        int sLen,pLen;
        if(str==null || pattern==null) return false;

        sLen=str.length;pLen=pattern.length;
        int sPos=sStart,pPos=pStart;

        //模式超界：
        //字符串同时超界
        if(sPos>=sLen && pPos>=pLen) return true;
        //字符串未超界
        if(sPos<sLen && pPos>=pLen) return false;

        if(pPos<pLen-1 && pattern[pPos+1]=='*'){
            //模式的下一个是'*'
            if(sPos<sLen && (str[sPos]==pattern[pPos] || pattern[pPos]=='.')) {
                //字符串还没有越界：
                //如果字符等
                //三种情况：
                //模型后移2个位置
                return seqMatch(str, sPos, pattern, pPos + 2)
                        //字符串后移1个位置
                        || seqMatch(str,sPos+1,pattern,pPos )
                        || seqMatch(str,sPos+1,pattern,pPos+2);
            }else{
                //如果字符不等或者字符串越界，模式后移2位
                return seqMatch(str,sPos,pattern,pPos+2);
            }
        }

        //模式的下一个不是'*'
        if(sPos<sLen && (str[sPos]==pattern[pPos] || pattern[pPos]=='.')){
            //如果字符相等，则判断下一个
            return seqMatch(str,sPos+1,pattern,pPos+1);
        }

        return false;
    }

    /**
     * 失败了
     * @param str
     * @param pattern
     * @return
     */
    public boolean reverseMatch(char[] str,char[] pattern){

        int sLen,pLen;
        if(str==null || pattern==null) return false;

        sLen=str.length;pLen=pattern.length;
        int sPos=sLen-1,pPos=pLen-1;
        char sameOne;

        while (true){

            //如果指针小于0
            if(sPos<0){
                if(pPos<0) return true;
                if(pPos==0) return false;
            }
            if(pPos<0) return false;

            if(pattern[pPos]=='.'){
                sPos--;pPos--;
            }else if (pattern[pPos]=='*'){
//                pPos--;
                //暂时不考虑自减之后，小于0的情况
                if(pPos--<0) return false;
                if(sPos<=0) return pPos==0;
                sameOne=str[sPos];
                if(pattern[pPos]=='.' || pattern[pPos]==sameOne){
//                    return reverseMatch()
                    while (pPos>=0 && (pattern[pPos]==sameOne)) pPos--;
                    while (sPos>=0 && str[sPos]==sameOne) sPos--;
                    if(sPos<0){
                        if(sLen>0 && pattern[pPos]=='*') {
                            char[] dest = new char[pPos + 1];
                            System.arraycopy(pattern, 0, dest, 0, pPos + 1);
                            return reverseMatch(new char[]{str[0]}, dest);
                        }else if(pattern[pPos]!='*'){
                            return false;
                        }
                    }
                }else {
                    pPos--;
                }
            }else{
                //正常字符
                if(str[sPos--]!=pattern[pPos--]) return false;
            }

        }

    }

    /**
     * 失败
     * @param str
     * @param pattern
     * @return
     */
    public boolean seqMatch(char[] str,char[] pattern){
        int sLen,pLen;
        if(str==null || pattern==null) return false;

        sLen=str.length;pLen=pattern.length;
        int sPos=0,pPos=0,ls=0,lp=0;
        char sameOne;

        while (true){

            if(sPos==sLen || pPos==pLen) {
                if(sPos==sLen){
                    if(pPos==pLen) return true;
                    return (pPos+2==pLen && pattern[pPos+1]=='*')?true:false;
                }else{
                    return false;
                }
            }

            if (pattern[pPos] == '.') {
                pattern[pPos] = str[sPos];
                continue;
            }

            if(pPos<pLen-1 && pattern[pPos+1]=='*'){
                sameOne=str[sPos];
                if(pattern[pPos]==sameOne) {
                    //计算str中与pattern中相同字符的长度
                    while (sPos < sLen && str[sPos] == sameOne){
                        sPos++;ls++;
                    }
                    pPos += 2;
                    while (pPos < pLen && pattern[pPos] == sameOne){
                        pPos++;
                        lp++;
                    }
                    if (ls < lp) return false;
//                    sPos-=(ls-lp-1);
                }else{
                    pPos+=2;
                }
            }else {
                if (str[sPos] == pattern[pPos]) {
                    sPos++;pPos++;
                } else {
                    //不相等
                    return false;
                }
            }

        }

    }

}
