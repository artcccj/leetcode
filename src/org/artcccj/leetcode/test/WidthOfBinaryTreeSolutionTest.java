package org.artcccj.leetcode.test;

import org.artcccj.leetcode.binary.tree.TreeNode;
import org.artcccj.leetcode.binary.tree.WidthOfBinaryTreeSolution;
import org.junit.Test;

public class WidthOfBinaryTreeSolutionTest {

    @Test
    public void testWidthOfBinaryTreeSolution() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(5), new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(9)));
        int width = new WidthOfBinaryTreeSolution().widthOfBinaryTree(root);
        assert width == 4;
    }

    // [1,1,1,1,null,null,1,1,null,null,1]
    @Test
    public void testWidthOfBinaryTreeSolution2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(1, new TreeNode(1, new TreeNode(1), null), null),
                new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1)))
        );
        int width = new WidthOfBinaryTreeSolution().widthOfBinaryTree(root);
        assert width == 8;
    }

}
