package org.artcccj.leetcode.test;

import org.artcccj.leetcode.array.TwoNumberSum;
import org.junit.Test;

public class TwoNumberSumTest {

    @Test
    public void test() {

        int[] ret = new TwoNumberSum().twoSum(new int[]{2, 7, 11, 15}, 9);

        assert ret[0] == 0;
        assert ret[1] == 1;

    }

}
