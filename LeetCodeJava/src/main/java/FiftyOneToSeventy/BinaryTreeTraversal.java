package FiftyOneToSeventy;

import SeventyOneToNinty.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            resultList.add(n.val);

            if (n.left != null) {
                stack.push(n.left);
            }
            if (n.right != null) {
                stack.push(n.right);
            }
        }
        return resultList;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
        return lst;
    }

}
