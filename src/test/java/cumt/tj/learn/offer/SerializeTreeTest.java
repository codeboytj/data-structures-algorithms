package cumt.tj.learn.offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-8-25.
 */
public class SerializeTreeTest {

    @Test
    public void serialize(){

        SerializeTree st=new SerializeTree();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(4);

        String serialized=st.Serialize(root);
        assertEquals(serialized,"1,2,#,#,4,#,#");

        TreeNode newRoot=st.Deserialize(serialized);

        root.left.left=root.right;
        root.right=null;
        serialized=st.Serialize(root);
        newRoot=st.Deserialize(serialized);
        assertEquals(serialized,"1,2,4,#,#,#,#");
    }

}
