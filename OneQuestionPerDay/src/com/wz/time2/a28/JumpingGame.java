package com.wz.time2.a28;

public class JumpingGame {

    /**
     * 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例2:
     *
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */

    public static void main(String[] args) {
        // System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    /**
     * 只需要判断0就可以，只要能跳过0，那就肯定可以到达最后
     * 这个的时间复杂度就是 0的个数和0所在的索引位置决定的
     * 空间复杂度就是 O（1）
     */
    public static boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int num = i;
            if (nums[i] == 0) {
                while (num > 0) {
                    // 判断索引处的值和当前索引与0所在索引之间的距离就好
                    if (nums[num - 1] > i - num + 1) {
                        num = -1;
                    } else {
                        num --;
                    }
                }
                if (num == 0) {
                    return false;
                }
            }

        }
        return true;
    }
}