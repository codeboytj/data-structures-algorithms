package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 17-8-27.
 *
 * 题目描述
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * 思路：
 * 二叉搜索树的中序遍历序列为有序序列，第k个就是要找的
 */
public class KthNode {

    TreeNode KthNode(TreeNode pRoot, int k)
    {

        //空树或k越界
        if(pRoot==null || k<=0) return null;

        List<TreeNode> nodes=new ArrayList<TreeNode>();

        kthNode(pRoot,nodes);

        //k越界
        if(k>nodes.size()) return null;

        return nodes.get(k-1);

    }

    void kthNode(TreeNode pRoot,List<TreeNode> nodes){

        //左右子树
        TreeNode left=pRoot.left;
        TreeNode right=pRoot.right;

        //递归遍历左子树
        if(left!=null){
            kthNode(left,nodes);
        }

        //
        nodes.add(pRoot);

        //递归遍历右子树
        if(right!=null){
            kthNode(right,nodes);
        }
    }

}
