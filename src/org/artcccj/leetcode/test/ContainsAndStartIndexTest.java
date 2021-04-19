package org.artcccj.leetcode.test;

import org.artcccj.leetcode.str.ContainsAndStartIndex;
import org.junit.Test;

public class ContainsAndStartIndexTest {

    // haystack = "hello", needle = "ll"
    @Test
    public void test() {
        int ret = new ContainsAndStartIndex().strStr("hello", "ll");
        assert ret == 2;
    }

    // haystack = "aaaaa", needle = "bba"
    @Test
    public void test1() {
        int ret = new ContainsAndStartIndex().strStr("aaaaa", "bba");
        assert ret == -1;
    }

}
