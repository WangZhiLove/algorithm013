package com.wz.september.time2.a28;

import java.util.List;

public class PathSumII {

    /**
     * 路径总和 II
     *
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明:叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        return null;
    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }