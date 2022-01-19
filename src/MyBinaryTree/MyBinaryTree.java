package MyBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-16
 * Time: 21:51
 * Description:
 */


class BTNode {

    public char val;
    public BTNode left;
    public BTNode right;

    public BTNode(char val) {
        this.val = val;
    }


}


public class MyBinaryTree {

    public BTNode root;
    public int treeSize;

    public BTNode createTree() {

        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        //E.right = H;

        return A;
    }


    public void preOrder (BTNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder (BTNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }



    public void postOrder (BTNode root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }



    public int size (BTNode root) {
        if(root == null) {
            return 0;
        }

        treeSize++;
        size(root.left);
        size(root.right);
        return treeSize;
    }


    public int sizeSub (BTNode root) {

        if(root == null) {
            return 0;
        }

        //int leftree = sizeSub(root.left);
        //int righttree = sizeSub(root.right);
        //treeSize = leftree + righttree + 1;

        return sizeSub(root.left) + sizeSub(root.right) + 1;
        //return treeSize;
    }

    public int leaves;

    public int getLeafNodeCount (BTNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) leaves++;

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return leaves;
    }

    public int getLeafNodeCountSub (BTNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) return 1;

        return getLeafNodeCountSub(root.left) + getLeafNodeCountSub(root.right);
    }


    public int getKLevelNodeCount (BTNode root, int k) {
        if(k < 0) throw new RuntimeException("Invalid k level");
        if (root == null) return 0;
        if (k == 1) return 1;

        return getKLevelNodeCount(root.right , k - 1) + getKLevelNodeCount(root.left , k - 1);
    }

    public int getHeight (BTNode root) {
        if (root == null) return 0;

        if(root.right == null && root.left == null) {
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public BTNode find (BTNode root, char val) {
        if(root == null) return null;
        if(root.val == val) return root;

        BTNode rst1 = find(root.right, val);
        BTNode rst2 = find(root.left, val);

        if(rst2 == null) return rst1;
        return rst2;
    }

    public boolean isCompleteTree1 (BTNode root) {

        if(root == null) return false;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        BTNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(temp.right != null && temp.left != null) {
                queue.offer(temp.right);
                queue.offer(temp.left);
            }
            else if(temp.right == null && temp.left == null) {
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }

    public boolean isCompleteTree (BTNode root) {

        if(root == null) return false;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        BTNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(temp != null) {
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
            else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            BTNode node = queue.peek();
            if(node != null) {
                return false;
            }
            queue.poll();
        }

        return true;
    }


}
