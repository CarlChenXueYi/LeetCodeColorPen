package SeventyOneToNinty;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class FlattenBinaryTree {
    //             1
//            /\
//            25
//            /\\
//            346
//    The flattened tree should look like:
//            1
//            \
//            2
//             \
//              3
//               \
//                4
//                 \
//                  5
//                   \
//                    6
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
    }
}
