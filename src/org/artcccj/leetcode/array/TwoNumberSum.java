package org.artcccj.leetcode.array;

public class TwoNumberSum {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (target == a + b) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

}
