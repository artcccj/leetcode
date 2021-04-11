package org.artcccj.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WidthOfBinaryTreeSolution {

    static class Aux {
        TreeNode node;
        int location;

        public Aux(TreeNode node, int location) {
            this.node = node;
            this.location = location;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Aux starter = new Aux(root, 0);
        List<Aux> queue = new ArrayList<>();
        queue.add(starter);

        List<Aux> nextLevel = new ArrayList<>();
        int width = widthOfLevelReturnNextLevel(queue, nextLevel);

        while (!nextLevel.isEmpty()) {
            List<Aux> nnl = new ArrayList<>();
            width = Math.max(width, widthOfLevelReturnNextLevel(nextLevel, nnl));
            nextLevel = nnl;
        }

        return width;
    }

    int widthOfLevelReturnNextLevel(List<Aux> level, List<Aux> nextLevel) {

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (Aux item : level) {
            left = Math.min(item.location, left);
            right = Math.max(item.location, right);

            if (item.node.left != null) {
                nextLevel.add(new Aux(item.node.left, item.location * 2 + 1));
            }

            if (item.node.right != null) {
                nextLevel.add(new Aux(item.node.right, item.location * 2 + 2));
            }
        }

        return right - left + 1;
    }

    /**
     *           1
     *          / \
     *         3   2
     *        /     \
     *       5       9
     *      /         \
     *     6           7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * PS: 无法解决中空问题
     */
    public int widthOfBinaryTreeV0(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        List<List<Integer>> levels = new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        List<TreeNode> nextLevel = getWithLevel(nodes, levels);

        while (!nextLevel.isEmpty()) {
            nextLevel = getWithLevel(nextLevel, levels);
        }

        // count result

        int maxWidth = 0;
        for (List<Integer> level : levels) {

            maxWidth = Math.max(getValidSize(level), maxWidth);
        }

        return maxWidth;
    }

    private int getValidSize(List<Integer> level) {
        trimNull(level);

        int lastIndex = 0;
        for (int i = level.size() - 1; i >= 0; i--) {
            if (level.get(i) != null) {
                lastIndex = i;
                break;
            }
        }

        return lastIndex + 1;
    }

    private void trimNull(List<Integer> level) {
        Iterator<Integer> iterator = level.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == null) {
                iterator.remove();
            } else {
                break;
            }
        }
    }

    private List<TreeNode> getWithLevel(List<TreeNode> nodes, List<List<Integer>> levels) {

        List<Integer> level = new ArrayList<>();
        levels.add(level);

        List<TreeNode> ret = new ArrayList<>();

        if (nodes.isEmpty()) {
            return ret;
        }

        Iterator<TreeNode> iterator = nodes.iterator();

        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            iterator.remove();

            if (node == null) {
                level.add(null);
                continue;
            }

            ret.add(node.left);
            ret.add(node.right);

            level.add(node.val);
        }

        return ret;
    }

}


