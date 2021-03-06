package com.wz.september.time2.a16;

public class EffectivePerfectSquare {
    /**
     * 有效的完全平方数
     *
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     *
     * 说明：不要使用任何内置的库函数，如 sqrt。
     *
     * 示例 1：
     *
     * 输入：16
     * 输出：True
     * 示例 2：
     *
     * 输入：14
     * 输出：False
     */

    /**
     * 直接二分查找，注意long类型
     */


    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2,
                right = num / 2,
                middle,
                square;
        while (left <= right) {
            middle = left + (right - left) / 2;
            square = middle * middle;
            if (square == num) {
                return true;
            }
            if (square > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(808201));
    }
}
