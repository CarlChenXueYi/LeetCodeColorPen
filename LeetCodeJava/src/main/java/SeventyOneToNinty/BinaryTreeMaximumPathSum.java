package SeventyOneToNinty;

public class BinaryTreeMaximumPathSum {
    int max;

    public int maxPathSum(TreeNode root) {
        max = (root == null) ? 0 : root.val;
        findMax(root);
        return max;
    }

    public int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(findMax(node.left), 0);
        int right = Math.max(findMax(node.right), 0);

        max = Math.max(node.val + left + right, max);
        return node.val + Math.max(left, right);
    }


    public int maxPathSum1(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    private int calculateSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
        return current;
    }


}
