package FiftyOneToSeventy;

public class IntersectionOfTwoLinkedLists {
    //    Write a program to find the node at which the intersection of two singly linked lists begins.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Get the Lists length,then subtract the diff
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = headA, p2 = headB;
        if (p1 == null || p2 == null) {
            return null;
        }
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int diff = Math.abs(len1 - len2);
        p1 = headA;
        p2 = headB;

        if (len1 < len2) {
            int i = 0;
            while (i < diff) {
                p2 = p2.next;
                i++;
            }
        } else {
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        }

        while (p1 != null) {
            if (p1.val == p2.val) {
                return p1;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }
}
