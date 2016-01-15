package com.zemo.easy.add.digits;

/**
 * @ClassName: AddDigits
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 12/3/15 20:50
 * @Description Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *  For example:
 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *  Follow up:
 *  Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(888888));
    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
