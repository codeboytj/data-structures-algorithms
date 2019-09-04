package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-29.
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
     8
     /  \
     6   10
     / \  / \
     5  7 9 11
     镜像二叉树
     8
     /  \
     10   6
     / \  / \
     11 9 7  5
 *
 * 思路：
 * 对于非叶子结点，交换左右子树
 */
public class BinaryTreeMirror {

    private static void getMirror(TreeNode root){

        if(root==null) return;

        //左右子树
        TreeNode left=root.left;
        TreeNode right=root.right;

        //叶子节点
        if(left==null && right==null) return;

        //非叶子节点
        root.left=right;
        root.right=left;

        getMirror(left);
        getMirror(right);

    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        getMirror(root);
        System.out.println(1==root.val);
        System.out.println(3==root.left.val);
        System.out.println(2==root.right.val);
        System.out.println(5==root.right.left.val);
        System.out.println(4==root.right.right.val);
        System.out.println(7==root.left.left.val);
        System.out.println(6==root.left.right.val);
    }

}

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
