package SeventyOneToNinty;

import java.util.LinkedList;

public class PathSum {
    //    Given a binary tree and a sum, determine if the tree has a
//    root-to-leaf path such that adding up all the values along the
//    path equals the given sum.
//    For example: Given the below binary tree and sum = 22,
//             5
//            /\
//            48
//            / / \
//            11 13 4
//            /\  \
//            7 2  1
//    5->4->11->2

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();

        nodes.add(root);
        values.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if (curr.left == null && curr.right == null && sumValue == sum) {
                return true;
            }

            if (curr.left != null) {
                nodes.add(curr.left);
                values.add(sumValue + curr.left.val);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                values.add(sumValue + curr.right.val);
            }

        }
        return false;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && (root.left == null && root.right == null)) {
            return true;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }
}
