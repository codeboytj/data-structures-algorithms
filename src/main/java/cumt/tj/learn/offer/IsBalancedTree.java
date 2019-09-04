package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-5.
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：
 * 平衡二叉树的左右子树都是平衡二叉树
 * 后序遍历
 * 递归判断左右子树是不是深度差是否小于1
 * 不是则不是平衡二叉树
 * 是则拿到最大深度继续
 */
public class IsBalancedTree {

    public boolean IsBalanced_Solution(TreeNode root) {


        if(root==null) return true;

        return (TreeDepth(root)==-1)?false:true;

    }


    public int TreeDepth(TreeNode root) {

        if(root==null) return 0;

        //拿到左右子树的深度,并判断左右子树是否是平衡二叉树
        int left=TreeDepth(root.left);
        if(left==-1) return -1;
        int right=TreeDepth(root.right);
        if(right==-1) return -1;

        //左右都是平衡二叉树，判断自己是不是平衡树
        if(left-right>1 || right-left>1) return -1;

        // 自己是平衡树最大深度+1，继续
        return (left>right)?(left+1):(right+1);

    }

}
