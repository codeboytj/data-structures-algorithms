package cumt.tj.learn.offer;

import java.util.HashSet;

/**
 * Created by sky on 17-7-16.
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：1. 对于空树的情况，直接返回false
 *       2. 对于不是空树的情况，可以递归查看是否是左右子树(这是错的，因为它判断的是子结构，而不是子树)
 *       3. 对于不是空树的情况，分为2步
 *       首先判断当前root的值是否相同，如果相同，则判断root的下面的节点与root2下面的节点是否相同
 *       如果当前root的值不相同，则判断root的下面的节点与root2是否相同
 *
 */
public class HasSubtree {


    public boolean hasSubtree(TreeNode root1,TreeNode root2) {

        boolean result=false;

        if (root1 == null || root2 == null) {
            return false;
        }

        if(root1.val==root2.val){
            result= isSubtree(root1,root2);
        }

        if(!result) result=hasSubtree(root1.left,root2)||hasSubtree(root1.right,root2);

        return result;
    }

    private boolean isSubtree(TreeNode root1,TreeNode root2){

        if(root2==null) return true;

        if (root1==null) return false;

        if(root1.val!=root2.val) return false;

        return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);

    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(8);
        root1.left=new TreeNode(8);
        root1.right=new TreeNode(8);
        root1.left.left=new TreeNode(9);
        root1.left.left.left=new TreeNode(9);
        root1.left.left.right=new TreeNode(9);
        root1.left.right=new TreeNode(3);

        TreeNode root2=root1.left;

        HasSubtree hasSubtree=new HasSubtree();
        System.out.print(hasSubtree.hasSubtree(root1,root2));
        System.out.print(hasSubtree.hasSubtree(root1,null));
    }
}


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
