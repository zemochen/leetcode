package com.zemo.easy.happy.number;

/**
 * @ClassName: HappyNumber
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 12/3/15 21:25
 * @Description Write an algorithm to determine if a number is "happy".
 *              A happy number is a number defined by the following process:
 *                  Starting with any positive integer, replace the number by the sum of
 *                  the squares of its digits, and repeat the process until the number
 *                  equals 1 (where it will stay), or it loops endlessly in a cycle which
 *                  does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *              Example: 19 is a happy number
 *              1*1 + 9*9 = 82
 *              8*8 + 2*2 = 68
 *              6*6 + 8*8 = 100
 *              1*1 + 0*0 + 0*0 = 1
 */
public class HappyNumber {

    //TODO haven't work out
    public boolean isHappy(int n) {

        int x = n % 10;
        if (x == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
