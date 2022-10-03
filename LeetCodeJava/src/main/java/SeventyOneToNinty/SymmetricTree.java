package SeventyOneToNinty;

public class SymmetricTree {
    public boolean isSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmertric(root.left, root.right);
    }

    private boolean isSymmertric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (r == null || l == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        if (!isSymmertric(l.left, r.right)) {
            return false;
        }
        if (!isSymmertric(l.right, r.left)) {
            return false;
        }
        return true;
    }
}
