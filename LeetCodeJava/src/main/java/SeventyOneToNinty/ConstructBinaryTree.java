package SeventyOneToNinty;

public class ConstructBinaryTree {
    //    From the post-order array, we know that last element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
//    Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. Recursively, we can build up the tree.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return buildTree(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart,
                              int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }
        root.left = buildTree(inorder, postorder, inStart, k - 1, postStart, postStart + k - (inStart + 1));
        root.right = buildTree(inorder, postorder, k + 1, inEnd, postStart + k - inStart, postEnd - 1);
        return root;
    }
}
