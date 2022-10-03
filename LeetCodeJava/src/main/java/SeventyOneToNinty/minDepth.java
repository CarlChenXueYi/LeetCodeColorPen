package SeventyOneToNinty;

import java.util.LinkedList;

public class minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> counts = new LinkedList<>();

        nodes.add(root);
        counts.add(1);

        while ((!nodes.isEmpty())) {
            TreeNode curr = nodes.remove();
            int count = counts.remove();
            if (curr.left != null) {
                nodes.add(curr.left);
                counts.add(count + 1);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                counts.add(count + 1);
            }
            if (curr.left == null && curr.right == null) {
                return count;
            }

        }
        return 0;
    }
}
