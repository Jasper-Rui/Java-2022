package MyBinaryTree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-16
 * Time: 21:51
 * Description:
 */


class TreeNode {

    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }


}


public class MyBinaryTree {

    public TreeNode root;
    public int treeSize;

    public TreeNode createTree() {
        //[1,3,2,5,3,null,9]
        TreeNode A = new TreeNode('1');
        TreeNode B = new TreeNode('3');
        TreeNode C = new TreeNode('2');
        TreeNode D = new TreeNode('5');
        TreeNode E = new TreeNode('3');
        TreeNode F = new TreeNode(' ');
        TreeNode G = new TreeNode('9');
        //TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.right = G;
        C.left = null;
        /*TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        E.right = H;*/

        return A;
    }


    public void preOrder (TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder (TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }



    public void postOrder (TreeNode root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }



    public int size (TreeNode root) {
        if(root == null) {
            return 0;
        }

        treeSize++;
        size(root.left);
        size(root.right);
        return treeSize;
    }


    public int sizeSub (TreeNode root) {

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

    public int getLeafNodeCount (TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) leaves++;

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return leaves;
    }

    public int getLeafNodeCountSub (TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) return 1;

        return getLeafNodeCountSub(root.left) + getLeafNodeCountSub(root.right);
    }


    public int getKLevelNodeCount (TreeNode root, int k) {
        if(k < 0) throw new RuntimeException("Invalid k level");
        if (root == null) return 0;
        if (k == 1) return 1;

        return getKLevelNodeCount(root.right , k - 1) + getKLevelNodeCount(root.left , k - 1);
    }

    public int getHeight (TreeNode root) {
        if (root == null) return 0;

        if(root.right == null && root.left == null) {
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public TreeNode find (TreeNode root, char val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode rst1 = find(root.right, val);
        TreeNode rst2 = find(root.left, val);

        if(rst2 == null) return rst1;
        return rst2;
    }

    public boolean isCompleteTree1 (TreeNode root) {

        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode temp;
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

    public boolean isCompleteTree (TreeNode root) {

        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode temp;
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
            TreeNode node = queue.peek();
            if(node != null) {
                return false;
            }
            queue.poll();
        }

        return true;
    }



/*    public void levelOrder(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            //if empty, it means one layer of tree is done doing traversal
            if(queue.isEmpty()) {
                List<TreeNode> list = new ArrayList<TreeNode>();
            }

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
            System.out.print(node.val + " ");
        }
    }*/
    public List<List<TreeNode>> levelOrder(TreeNode root) {
        int index = 0;
        HashMap<TreeNode, Integer> map = new HashMap();
        List<List<TreeNode>> list = new ArrayList<>();
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //size represent current number of nodes
            List<TreeNode> list1 = new ArrayList<>();
            while (size != 0) {
                TreeNode node = queue.poll();
                list1.add(node);
                size--;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(list1);
        }

        return list;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        List<List<TreeNode>> list = levelOrder(root);
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            int size = list.get(i).size();
            if(size > max) {
                max = size;
            }
        }
        return max;
    }


    public Stack<TreeNode> path = new Stack<>();


    public boolean getPath (TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if(root == null || node == null) return false;

        stack.push(root);

        if(root == node) {
            return true;
        }

        boolean flg = getPath(root.left, node, stack);
        if(flg == true) {
            return true;
        }

        flg = getPath(root.right, node, stack);
        if(flg == true) {
            return true;
        }

        stack.pop();
        return false;

    }


    public void preorderWithoutRecursion (TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                //System.out.printf(cur.val);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
}
