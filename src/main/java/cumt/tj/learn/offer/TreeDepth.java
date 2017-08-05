package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-5.
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 思路：
 * 递归，后序遍历，取左右子树较大的深度+1
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {

        if(root==null) return 0;

        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);

        return (left>right)?(left+1):(right+1);

    }

}

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */