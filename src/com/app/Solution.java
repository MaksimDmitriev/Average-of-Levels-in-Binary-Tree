package com.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

    private static final TreeNode END_OF_LEVEL = new TreeNode(0);

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        res.add((double) root.val);

        // bfs based solution
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(END_OF_LEVEL);
        double sum = 0;
        int count = 0;
        while (true) {
            TreeNode elem = queue.remove();
            if (elem == END_OF_LEVEL) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(END_OF_LEVEL);
                res.add(sum / count);
                sum = 0.0;
                count = 0;
            } else {
                if (elem.left != null) {
                    queue.add(elem.left);
                    count++;
                    sum += elem.left.val;
                }
                if (elem.right != null) {
                    queue.add(elem.right);
                    count++;
                    sum += elem.right.val;
                }
            }
        }

        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}