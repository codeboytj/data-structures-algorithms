package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 17-8-23.
 *
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 思路：
 * 1. 求出二叉树的镜像，比较是否想等
 *      这样需要使用一个o(n)的空间存储镜像
 * 2. 关于中序遍历，一般先遍历左节点、当前结点再遍历右节点，如果这是第一种中序遍历
 *      那么这道题需要第二种中序遍历：先遍历右节点、当前结点再遍历左节点
 *      如果节点第一种中序遍历与其兄弟节点的第二种中序遍历结果一样，那么就是对称二叉树
 *      但是这种无法处理所有元素都一样的情况
 */
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot)
    {

        //空节点
        if(pRoot==null) return true;

        //
        TreeNode left=pRoot.left;
        TreeNode right=pRoot.right;

        if(left==null && right==null) return true;

        List<Integer> first=new ArrayList<Integer>();
        List<Integer> second=new ArrayList<Integer>();
        if(left!=null && right!=null && left.val==right.val) {
            firstInorderTraversal(left,first);
            secondInorderTraversal(right,second);
            if(first.size()!=second.size()) return false;
            for(int i=0;i<first.size();i++){
                if(first.get(i)==null && second.get(i)==null) continue;
                if(first.get(i)==null || second.get(i)==null) return false;
                if(!first.get(i).equals(second.get(i))) return false;
            }
            return true;
        }

        return false;

    }

    public void firstInorderTraversal(TreeNode pRoot,List<Integer> first){

        if(pRoot==null) return;

        TreeNode left=pRoot.left;
        TreeNode right=pRoot.right;

        if(left!=null){
            firstInorderTraversal(left,first);
        }else{
            first.add(null);
        }

        first.add(pRoot.val);

        if(right!=null){
            firstInorderTraversal(right,first);
        }else{
            first.add(null);
        }

    }

    public void secondInorderTraversal(TreeNode pRoot,List<Integer> second){

        TreeNode left=pRoot.left;
        TreeNode right=pRoot.right;

        if(right!=null){
            secondInorderTraversal(right,second);
        }else{
            second.add(null);
        }

        second.add(pRoot.val);

        if(left!=null){
            secondInorderTraversal(left,second);
        }else{
            second.add(null);
        }

    }
}
