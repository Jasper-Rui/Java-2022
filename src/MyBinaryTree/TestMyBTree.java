package MyBinaryTree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-17
 * Time: 21:15
 * Description:
 */
public class TestMyBTree {
    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        TreeNode btNode = myBinaryTree.createTree();
        /*System.out.println(myBinaryTree.sizeSub(btNode));
        System.out.println(myBinaryTree.getLeafNodeCount(btNode));
        System.out.println(myBinaryTree.getKLevelNodeCount(btNode, 3));
        System.out.println(myBinaryTree.getHeight(btNode));
        System.out.println(myBinaryTree.find(btNode, 'N'));
        System.out.println(myBinaryTree.isCompleteTree(btNode));
        myBinaryTree.levelOrder(btNode);*/

        List<List<TreeNode>> list = myBinaryTree.levelOrder(btNode);
        System.out.println(list.size());
        int max = myBinaryTree.widthOfBinaryTree(btNode);
        System.out.println(list.get(0).toString());
        System.out.println(max);

    }
}