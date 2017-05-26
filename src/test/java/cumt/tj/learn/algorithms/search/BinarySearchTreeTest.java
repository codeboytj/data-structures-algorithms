package cumt.tj.learn.algorithms.search;

import cumt.tj.learn.algorithms.vector.Expression;
import cumt.tj.learn.structures.tree.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by sky on 17-5-25.
 */
public class BinarySearchTreeTest {
    BinarySearchTree<Integer> binarySearchTree;
    public BinarySearchTreeTest() {
        //1,2,3,4,5,6,7
        BinaryTreeNode<Integer> rootNode=new BinaryTreeNode<Integer>(5);
        rootNode.setLeft(new BinaryTreeNode<Integer>(3));
        rootNode.setRight(new BinaryTreeNode<Integer>(7));
        rootNode.getRight().setLeft(new BinaryTreeNode<Integer>(6));
        rootNode.getLeft().setRight(new BinaryTreeNode<Integer>(4));
        rootNode.getLeft().setLeft(new BinaryTreeNode<Integer>(2));
        rootNode.getLeft().getLeft().setLeft(new BinaryTreeNode<Integer>(1));
        binarySearchTree=new BinarySearchTree<Integer>(rootNode);
    }

    @Test
    public void containsTest(){
        assertTrue(binarySearchTree.contains(5));
        assertTrue(binarySearchTree.contains(1));
        assertTrue(!binarySearchTree.contains(9));
    }

    @Test
    public void minAndMax(){
        //测试查找最大最小值
        assertEquals(new Integer(1),binarySearchTree.findMin());
        assertEquals(new Integer(7),binarySearchTree.findMax());
    }

    @Test
    public void insert(){
        assertTrue(!binarySearchTree.contains(8));
        binarySearchTree.insert(8);
        assertTrue(binarySearchTree.contains(8));
    }

    @Test
    public void remove(){
        assertTrue(binarySearchTree.contains(3));
        binarySearchTree.remove(3);
        assertTrue(!binarySearchTree.contains(3));
    }
}
