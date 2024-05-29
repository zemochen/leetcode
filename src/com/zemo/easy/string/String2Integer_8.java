package com.zemo.easy.string;

/**
 * @ClassName: String2Integer
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2021/9/7
 * @Description
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 */
public class String2Integer_8 {

    public int myAtoi(String s) {
        if (s == null) return 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        boolean negative = false;
        int begin = 0;
        long ans = 0;
        s = s.trim();
        if (s.length() > 0) {
            if (s.charAt(begin)=='+') {
                begin++;
            } else if (s.charAt(begin)=='-'){
                begin++;
                negative = true;
            }
            for (int i = begin; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    ans = ans * 10 + s.charAt(i) - '0';
                } else {
                    break;
                }
                if (ans > MAX) {
                    return negative ? MIN : MAX;
                }
            }
        }
        return (int)(negative ? -ans : ans);
    }

    public int myAtoi2(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') ++i;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
    public static void main(String[] args) {
        String2Integer_8 string2Integer8 = new String2Integer_8();

        System.out.println(string2Integer8.myAtoi("-91283472332Bc"));
        System.out.println(string2Integer8.myAtoi2("-91283472332bc"));
        System.out.println(string2Integer8.myAtoi("-0032"));
    }
}
