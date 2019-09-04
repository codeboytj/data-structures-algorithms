package cumt.tj.learn.algorithms.vector;

import cumt.tj.learn.structures.stack.LinkedStack;
import cumt.tj.learn.structures.tree.BinaryTree;
import cumt.tj.learn.structures.tree.BinaryTreeNode;

/**
 * Created by sky on 17-5-13.
 * 表达式操作，先缀、中缀以及后缀表达式操作
 */
public class Expression {

    /**
     * 后缀表达式变成表达式树
     * @param postfix 表达式数组，它肯定是字符型数组
     * @return 二叉表达式树
     */
    @Deprecated
    public BinaryTree<Character> postfixToTree(char[] postfix){
        //树栈
        LinkedStack<BinaryTree> treeStack=new LinkedStack<BinaryTree>();
        //遇到操作符时，从栈顶弹出的两颗子树
        BinaryTree<Character> leftTree;
        BinaryTree<Character> rightTree;
        //1. 遍历后缀表达式
        for(int i=0;i<postfix.length;i++){
            if (getPriority(postfix[i])==-1){
                //2. 遇到操作数就建立一个单节点树并将它推入栈中
//                treeStack.push(new BinaryTree(Character.valueOf(postfix[i])));
                treeStack.push(new BinaryTree(postfix[i]));
            }else {
                //3. 遇到操作符就从栈中弹出两颗树，并形成一颗新树压入栈
                //3.1 弹出两颗树
                rightTree=treeStack.pop();
                leftTree=treeStack.pop();
                //3.2 形成新树并压入栈
                treeStack.push(new BinaryTree(postfix[i],leftTree.getRootNode(),rightTree.getRootNode()));
            }
        }

        return treeStack.pop();
    }

    /**
     * 后缀变成树
     * @param postfix 后缀表示式
     * @return 二叉表达式树
     */
    public BinaryTreeNode<Character> postfixToBinaryTree(char[] postfix){
        //树栈
        LinkedStack<BinaryTreeNode> treeStack=new LinkedStack<BinaryTreeNode>();
        //遇到操作符时，从栈顶弹出的两颗子树
        BinaryTreeNode<Character> leftTree;
        BinaryTreeNode<Character> rightTree;
        //1. 遍历后缀表达式
        for(int i=0;i<postfix.length;i++){
            if (getPriority(postfix[i])==-1){
                //2. 遇到操作数就建立一个单节点树并将它推入栈中
//                treeStack.push(new BinaryTree(Character.valueOf(postfix[i])));
                treeStack.push(new BinaryTreeNode(postfix[i]));
            }else {
                //3. 遇到操作符就从栈中弹出两颗树，并形成一颗新树压入栈
                //3.1 弹出两颗树
                rightTree=treeStack.pop();
                leftTree=treeStack.pop();
                //3.2 形成新树并压入栈
                treeStack.push(new BinaryTreeNode(postfix[i],leftTree,rightTree));
            }
        }

        return treeStack.pop();
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
                //如果是操作数，那么压入操作数组
                postFix[j++]=item;
            }else{
                try {
                    //如果是操作符，那么将操作符栈顶操作符拿出来比较优先级
                    topOperator = operatorStack.pop();
                }catch (NullPointerException e){
                    //如果操作符栈里面什么都没有，就压入操作符，然后进行下一步循环
                    operatorStack.push(item);
                    continue;
                }
                if(getPriority(topOperator)<priority&&item!=')'){
                    //2.1 如果操作符o的优先级高于栈顶操作符且不是右括号，则压入操作符栈，为了保持原栈不变，现将原来的栈顶元素压入
                    operatorStack.push(topOperator);
                    operatorStack.push(item);
                }else {
                    //2.2 如果操作符o的优先级不高于栈顶操作符，则将操作符栈顶开始连续高于或等于o的操作符全部弹出，并按出栈的先后顺序，加入后缀表示数组
                    if(topOperator=='('){
                        operatorStack.push(topOperator);
                    }else {
                        postFix[j++]=topOperator;
                        while (!operatorStack.isEmpty()){
                            topOperator=operatorStack.pop();
                            if (getPriority(topOperator)<priority){
                                //如果栈顶操作符优先级小于o的优先级，结束出栈行为
                                break;
                            }
                            if(topOperator!=Character.valueOf('(')){
                                postFix[j++]=topOperator;
                            }else {
                                //如果没有遇到')'，那么'('不出栈
                                if(item!=')') operatorStack.push(topOperator);
                                break;
                            }
                        }
                    }
                    //操作符入栈
                    if(item!=')'){
                        operatorStack.push(item);
                    }
                }
            }
        }

        //中缀表达式里面弄完了，但是操作符栈里还有东西，就全部弄出来
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
