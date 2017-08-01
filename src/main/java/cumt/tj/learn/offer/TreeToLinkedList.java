package cumt.tj.learn.offer;

import cumt.tj.learn.structures.tree.Tree;

/**
 * Created by sky on 17-8-1.
 * 题目描述:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：
 * 二叉搜索树的中序遍历为有序序列
 * 在中序遍历到根节点的时候，左子树已经排好序，需要将根节点与坐子树连接起来
 * 然后对右子树遍历，返回末尾节点
 */
public class TreeToLinkedList {

    public TreeNode convert(TreeNode pRootOfTree) {

        //如果是空节点
        if(pRootOfTree==null) return null;

        //不是空节点
        convertNode(pRootOfTree);
        while (pRootOfTree.left!=null)
            pRootOfTree=pRootOfTree.left;

        return pRootOfTree;

    }

    private void convertNode(TreeNode pRootOfTree){

        TreeNode left=pRootOfTree.left;
        TreeNode right=pRootOfTree.right;

        //如果是叶子节点
        if(left==null && right==null) return;

        //如果不是叶子节点
        if(left!=null) {
            convertNode(left);
            while (left.right!=null)
                left=left.right;
            left.right=pRootOfTree;
            pRootOfTree.left=left;
        }
        if(right!=null) {
            convertNode(right);
            while (right.left!=null)
                right=right.left;
            right.left=pRootOfTree;
            pRootOfTree.right=right;
        }
//        return right;


    }

    public static void main(String[] args) {

        TreeToLinkedList tree=new TreeToLinkedList();
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(6);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(8);
        root.right=new TreeNode(14);
        root.right.left=new TreeNode(12);
        root.right.right=new TreeNode(16);

        TreeNode newRoot=tree.convert(root);

        return;

    }

}
