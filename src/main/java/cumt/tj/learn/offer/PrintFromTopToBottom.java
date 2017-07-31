package cumt.tj.learn.offer;

import cumt.tj.learn.structures.tree.Tree;

import java.util.ArrayList;

/**
 * Created by sky on 17-7-31.
 * 题目描述：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：
 * 逐层打印
 * 将每一层的元素存储到List里面，递归调用的时候，打印List每个元素的左右节点
 */
public class PrintFromTopToBottom {


    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> printSeq=new ArrayList<Integer>();
        ArrayList<TreeNode> nodeSeq=new ArrayList<TreeNode>();

        if(root==null) return printSeq;

        nodeSeq.add(root);
        //记录当前层与下一层的节点数
        int currentNum=1;
        int nextNum;
        int startIndex=0;
        int size;
        //当前节点及其左右节点
        TreeNode left;
        TreeNode right;
        TreeNode current;

        //终止条件：当前遍历层没有节点
        while (currentNum!=0){

            nextNum=0;
            size=nodeSeq.size();
            //对当前层进行遍历
            for(int i=startIndex;i<size;i++){

                current=nodeSeq.get(i);
                left=current.left;
                right=current.right;
                printSeq.add(current.val);

                if(left!=null){
                    //如果当前节点有左节点，那么左节点加入list
                    nodeSeq.add(left);
                    nextNum++;
                }
                if(right!=null){
                    nodeSeq.add(right);
                    nextNum++;
                }

            }

            startIndex+=currentNum;
            currentNum=nextNum;

        }

        return printSeq;
    }

    public static void main(String[] args) {

        PrintFromTopToBottom printFromTopToBottom=new PrintFromTopToBottom();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        System.out.print(printFromTopToBottom.printFromTopToBottom(root));

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