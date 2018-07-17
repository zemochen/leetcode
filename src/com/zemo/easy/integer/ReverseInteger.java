package com.zemo.easy.integer;

/**
 * @ClassName: ReverseInteger
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 16/04/2017 16:44
 * @Description Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-1));

    }

    public int reverse(int x) {
        int MIN_INT = 0x80000000;
        int MAX_INT = 0X7fffffff;

        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        if (ans > MAX_INT || ans < MIN_INT) ans = 0;
        return (int) ans;
    }
}
