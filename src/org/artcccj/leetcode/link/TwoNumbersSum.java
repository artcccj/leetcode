package org.artcccj.leetcode.link;

public class TwoNumbersSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ret = new ListNode();

        ListNode a = l1;
        ListNode b = l2;
        ListNode c = ret;
        int t = 0;

        while (a != null || b != null) {
            int an = 0, bn = 0;

            if (a != null) {
                an = a.val;
                a = a.next;
            }
            if (b != null) {
                bn = b.val;
                b = b.next;
            }

            int cur = an + bn + t;
            if (cur >= 10) {
                c.next = new ListNode(cur % 10);
                t = 1;
            } else {
                c.next = new ListNode(cur);
                t = 0;
            }
            c = c.next;
        }

        if (t != 0) {
            c.next = new ListNode(t);
        }

        return ret.next;
    }

}
