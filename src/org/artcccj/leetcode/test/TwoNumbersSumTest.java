package org.artcccj.leetcode.test;

import org.artcccj.leetcode.link.ListNode;
import org.artcccj.leetcode.link.TwoNumbersSum;
import org.junit.Test;

public class TwoNumbersSumTest {

    // l1 = [2,4,3], l2 = [5,6,4]
    @Test
    public void test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode list = new TwoNumbersSum().addTwoNumbers(l1, l2);
        System.out.println(list);
    }

    // l1 = [0], l2 = [0]
    @Test
    public void test1() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode list = new TwoNumbersSum().addTwoNumbers(l1, l2);
        System.out.println(list);
    }

}
