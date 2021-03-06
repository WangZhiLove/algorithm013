package com.wz.september.time1.a8;

import java.util.*;

public class TopKElements {
    /**
     * 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     * 提示：
     *
     * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案
     */

    /**
     * 这个已经是第好几遍做了，看看能不能回忆起来
     */

    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 时间复杂度就在于排序了
     * O(n * log n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 转化成List或者Set
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        int[] result = new int[k];
        int len = 0;
        while (len < k) {
            result[len ++] = list.get(list.size() - len).getKey();
        }
        return result;
    }

    /// 小顶堆
    /*public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 堆的创建难住我了
        PriorityQueue<Map.Entry<Integer, Integer>> maps = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            maps.add(integerIntegerEntry);
            if (maps.size() > k) {
                maps.poll();
            }
        }
        int[] result = new int[k];
        int len = 0;
        while (len < k) {
            result[len ++] = maps.poll().getKey();
        }
        return result;
    }*/
}
