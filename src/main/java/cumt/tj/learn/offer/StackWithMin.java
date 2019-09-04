package cumt.tj.learn.offer;

import java.util.Stack;

/**
 * Created by sky on 17-7-29.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackWithMin {

    //用来存储真实的数据
    Stack<Integer> dataStack=new Stack<Integer>();
    //用来存储当前最小值
    Stack<Integer> helpStack=new Stack<Integer>();

    public void push(int node) {

        //存入数据
        dataStack.push(node);

        if(helpStack.empty()){
            //如果辅助栈为空
            helpStack.push(node);
        }else {
            //如果辅助栈不为空
            int min=helpStack.peek();
            if(node<min){
                //如果元素比当前需最小元素小，那么需要存入元素
                helpStack.push(node);
            }else {
                //如果元素不比当前需最小元素小，那么推入原来的栈顶元素
                helpStack.push(min);
            }
        }

    }

    public void pop() {

        dataStack.pop();
        helpStack.pop();

    }

    public int top() {

        return dataStack.peek();

    }

    public int min() {

        return helpStack.peek();

    }

    public static void main(String[] args) {

        StackWithMin stackWithMin=new StackWithMin();
        stackWithMin.push(3);
        stackWithMin.push(4);
        stackWithMin.push(2);
        stackWithMin.push(1);

        System.out.println(stackWithMin.min()==1);
        stackWithMin.pop();
        System.out.println(stackWithMin.min()==2);
        stackWithMin.pop();
        System.out.println(stackWithMin.min()==3);

    }

}
