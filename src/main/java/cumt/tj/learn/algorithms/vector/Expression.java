package cumt.tj.learn.algorithms.vector;

import cumt.tj.learn.structures.stack.ArrayStack;
import cumt.tj.learn.structures.stack.LinkedStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 17-5-13.
 * 表达式操作，先缀、中缀以及后缀表达式操作
 */
public class Expression {

    //运算符优先级
    private Map<Character,Integer> operatorPriority=new HashMap<Character,Integer>();
    {
        //暂只支持加减乘除运算
        operatorPriority.put('+',1);
        operatorPriority.put('-',1);
        operatorPriority.put('*',2);
        operatorPriority.put('/',2);
        operatorPriority.put('(',3);
        operatorPriority.put(')',3);
    }
    /**
     * 中缀表达式变后缀表达式
     * @return 后缀表达式数组
     */
    public char[] infixToPostfix(char[] infix){
        //后缀表达式长度，如果中缀表达式中有括号的话，这个长度其实大于实际长度
        int postFixLen=infix.length;
        char[] postFix=new char[postFixLen];
        //存放操作符的栈
        LinkedStack<Character> operatorStack=new LinkedStack<Character>();

        //1. 读取中缀表达式，将操作数放入后缀表达式数组，操作符放入操作符栈
        int priority;
        //栈顶操作符
        char topOperator;
        //记录加入后缀表达式数组的元素个数
        int j=0;
        //记录中缀表达式中的当前元素
        char item;
        for (int i=0;i<infix.length;i++){
            item=infix[i];
            priority=getPriority(item);

            if(priority==-1){
                postFix[j++]=item;
            }else{
                try {
                    topOperator = operatorStack.pop();
                }catch (NullPointerException e){
                    operatorStack.push(item);
                    continue;
                }
                if(getPriority(topOperator)<priority){
                    //2.1 如果操作符o的优先级高于栈顶操作符，则压入操作符栈，为了保持原栈不变，现将原来的栈顶元素压入
                    operatorStack.push(topOperator);
                    operatorStack.push(item);
                }else {
                    //2.2 如果操作符o的优先级不高于栈顶操作符，则将操作符栈顶开始连续高于或等于o的操作符全部弹出，并按出栈的先后顺序，加入后缀表示数组
                    postFix[j++]=topOperator;
                    while (!operatorStack.isEmpty()){
                        topOperator=operatorStack.pop();
                        if (getPriority(topOperator)<=priority){
                            if(topOperator!=Character.valueOf('(')){
                                postFix[j++]=topOperator;
                            }
                        }
                    }
                    if(item!=')'){
                        operatorStack.push(item);
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()){
            topOperator=operatorStack.pop();
            postFix[j++]=topOperator;
        }
        return postFix;
    }

    /**
     * 获取操作符的优先级，如果是操作数直接返回-1
     * @param c 操作数或者操作符
     * @return 优先级
     */
    private int getPriority(char c){
        switch (c){
            case '+':return 1;
            case '-':return 1;
            case '*':return 2;
            case '/':return 2;
            case '(':return 3;
            case ')':return 3;
        }
        return -1;
    }
}
