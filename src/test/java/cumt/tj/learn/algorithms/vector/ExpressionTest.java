package cumt.tj.learn.algorithms.vector;

import cumt.tj.learn.structures.tree.BinaryTree;
import cumt.tj.learn.structures.tree.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-5-14.
 */
public class ExpressionTest {
    @Test
    public void infixToPostfix(){
        Expression expression=new Expression();
        //基本运算
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b".toCharArray())),"ab-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a+b".toCharArray())),"ab+");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a*b".toCharArray())),"ab*");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a/b".toCharArray())),"ab/");
        //混合运算
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b+c".toCharArray())),"ab-c+");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b-c".toCharArray())),"ab-c-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b*c".toCharArray())),"abc*-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b/c".toCharArray())),"abc/-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b/c-b*c".toCharArray())),"abc/-bc*-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b-c*b".toCharArray())),"ab-cb*-");
        //带括号运算
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-(b-c)*b".toCharArray())).substring(0,7),"abc-b*-");
    }

    @Test
    public void postfixToTree(){
        Expression expression=new Expression();
        char[] postfix="ab-".toCharArray();
        BinaryTree<Character> expressionTree=expression.postfixToTree(postfix);
        BinaryTree<Character> expressionTree1=expression.postfixToTree("abc-b*-".toCharArray());
        System.out.print("后缀变表达式树");
    }

    @Test
    public void postfixToBinaryTree(){
        Expression expression=new Expression();
        BinaryTreeNode<Character> expressionTree1=expression.postfixToBinaryTree("abc-b*-".toCharArray());
        System.out.print("后缀变表达式树");
    }
}
