package SeventyOneToNinty;

import FiftyOneToSeventy.ListNode;

public class MergeSortLinkedList {
    public static ListNode mergeSortedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        int middle = count / 2;

        ListNode l = head, r = null;
        ListNode p2 = head;
        int countHalf = 0;
        while (p2 != null) {
            countHalf++;
            ListNode next = p2.next;
            if (countHalf == middle) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }

        ListNode h1 = mergeSortedList(l);
        ListNode h2 = mergeSortedList(r);

        ListNode merged = merge(h1, h2);
        return merged;
    }

    public static ListNode merge(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;

        ListNode fakeHead = new ListNode(100);
        ListNode pNew = fakeHead;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                pNew.next = new ListNode(p2.val);
                p2 = p2.next;
                pNew = pNew.next;
            } else if (p2 == null) {
                pNew.next = new ListNode(p1.val);
                p1 = p1.next;
                pNew = pNew.next;
            } else {
                if (p1.val < p2.val) {
                    pNew.next = new ListNode(p1.val);
                    p1 = p1.next;
                    pNew = pNew.next;
                } else if (p1.val == p2.val) {
                    pNew.next = new ListNode(p1.val);
                    pNew.next.next = new ListNode(p1.val);
                    pNew = pNew.next.next;
                    p1 = p1.next;
                    p2 = p2.next;
                } else {
                    pNew.next = new ListNode(p2.val);
                    p2 = p2.next;
                    pNew = pNew.next;
                }
            }
        }

        return fakeHead.next;
    }

}
