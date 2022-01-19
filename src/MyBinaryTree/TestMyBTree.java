package MyBinaryTree;

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
        BTNode btNode = myBinaryTree.createTree();
        System.out.println(myBinaryTree.sizeSub(btNode));
        System.out.println(myBinaryTree.getLeafNodeCount(btNode));
        System.out.println(myBinaryTree.getKLevelNodeCount(btNode, 3));
        System.out.println(myBinaryTree.getHeight(btNode));
        System.out.println(myBinaryTree.find(btNode, 'N'));
        System.out.println(myBinaryTree.isCompleteTree(btNode));
    }
}
