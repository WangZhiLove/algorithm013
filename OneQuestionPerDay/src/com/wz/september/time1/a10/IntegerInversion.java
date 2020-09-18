package com.wz.september.time1.a10;

public class IntegerInversion {

    /**
     * 整数反转
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例1:
     *
     * 输入: 123
     * 输出: 321
     * 示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−2^31, 2^31− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > 214748364 || result < -214748364) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}