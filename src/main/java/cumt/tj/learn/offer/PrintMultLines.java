package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sky on 17-8-25.
 *
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 思路：
 *
 */
public class PrintMultLines {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        //结果
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

        //空树
        if(pRoot==null) return result;

        //先用双链表把节点存起来
        LinkedList<TreeNode> prevList=new LinkedList<TreeNode>();
        LinkedList<TreeNode> curentList;
        prevList.add(pRoot);

        //遍历prevList
        TreeNode currentNode;
        TreeNode left,right;
        ArrayList<Integer> iList;
        while (prevList.size()>0){

            iList=new ArrayList<Integer>();
            curentList=new LinkedList<TreeNode>();

            while (prevList.size()>0){

                //取出队头节点
                currentNode=prevList.poll();

                //存入列表
                iList.add(currentNode.val);

                //子结点
                left=currentNode.left;right=currentNode.right;
                //将子结点加入currentList
                if(left!=null) curentList.add(left);
                if(right!=null) curentList.add(right);

            }

            result.add(iList);
            prevList=curentList;

        }

        return result;

    }

}
