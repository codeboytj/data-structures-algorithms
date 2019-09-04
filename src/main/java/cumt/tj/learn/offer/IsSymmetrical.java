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
 *      但是这种无法处理所有元素都一样的情况，此时需要将空指针也考虑进来
 */
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot)
    {

        return isSymmetrical(pRoot,pRoot);

    }

    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){

        if(pRoot1==null && pRoot2==null) return true;

        if(pRoot1==null || pRoot2==null) return false;

        if(pRoot1.val!=pRoot2.val) return false;

        return isSymmetrical(pRoot1.left,pRoot2.right) &&
                isSymmetrical(pRoot1.right,pRoot2.left);

    }

}
