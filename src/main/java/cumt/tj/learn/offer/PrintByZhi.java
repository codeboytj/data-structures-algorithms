package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sky on 17-8-24.
 *
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 思路：
 * 之前做过层序遍历，这道题不同的是层序遍历时候的遍历方向
 * 用一个flag表示方向
 * 由于LinkedList可以当成队列和栈使用
 * flag=1的时候，当成队列用，先进先出
 * flag=-1的时候，当成栈用，先进后出
 * 所以：
 * 1. 根据flag，遍历prevList中存储上一步遍历的node
 *      将每个node的值存入arrayList
 *      将他们的儿子node存储在currentList中
 *      将flag取反
 * 2. 此时prevList为空，将prevList指向currentList
 *      currentList指向新链表
 *      进行下一步遍历
 */
public class PrintByZhi {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        //结果
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

        //空树
        if(pRoot==null) return result;

        //先用双链表把节点存起来
        LinkedList<TreeNode> prevList=new LinkedList<TreeNode>();
        LinkedList<TreeNode> curentList;
        prevList.add(pRoot);
        int flag=1;

        //遍历prevList
        TreeNode currentNode;
        TreeNode left,right;
        ArrayList<Integer> iList;
        while (prevList.size()>0){

            iList=new ArrayList<Integer>();
            curentList=new LinkedList<TreeNode>();

            while (prevList.size()>0){

                //取出队头节点或栈顶节点
                currentNode=(flag==1?prevList.poll():prevList.removeLast());

                //存入列表
                iList.add(currentNode.val);

                //子结点
                left=currentNode.left;right=currentNode.right;
                if(flag==1){
                    //将子结点加入currentList
                    if(left!=null) curentList.add(left);
                    if(right!=null) curentList.add(right);
                }else{
                    if(right!=null) curentList.add(0,right);
                    if(left!=null) curentList.add(0,left);
                }

            }

            result.add(iList);
            flag*=-1;
            prevList=curentList;

        }

        return result;

    }

}
