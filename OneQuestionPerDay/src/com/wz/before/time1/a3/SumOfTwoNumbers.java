package com.wz.before.time1.a3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wz157
 */
public class SumOfTwoNumbers {
    /**
     * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    /**
     * 思路：
     * 1. 暴力求解： 双层for循环遍历，枚举所有的情况，但是需要考虑 4 + 4 = 8的情况
     * 2. 两遍哈希和一遍哈希（这个方案是看了题解之后），利用空间换时间（可我发现和暴力求解的内存赵勇差不了多少），
     */

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        printArr(twoSum(arr, 9));
    }


    /**
     * 两遍哈希表和一遍哈希表，利用哈希表查找快O(1)的时间复杂度，来查找，时间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (map.containsKey(minus)) {
                return new int[]{map.get(minus), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 暴力求解, 时间复杂度为 O(n^2)
     * @return
     */
    /*public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[0];
    }*/

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
