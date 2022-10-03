package SeventyOneToNinty;

import FiftyOneToSeventy.ListNode;

public class ConvertSortedArrayToBinaryTree {
    //    Given an array where elements are sorted in ascending order,
//    convert it to a height balanced BST.
    //Use recursively
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, begin, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }

    static ListNode h;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    public TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

}
