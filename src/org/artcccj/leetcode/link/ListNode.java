package org.artcccj.leetcode.link;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();

        ListNode c = this;

        while (c != null) {
            list.add(c.val);
            c = c.next;
        }

        return list.toString();
    }
}
