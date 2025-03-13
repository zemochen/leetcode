package com.zemo.easy.integer;

/**
 * @ClassName: SumTwoInteger
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 21:49
 * @Description ${TODO}
 */
public class SumTwoInteger {

    public static int getSum(int a, int b) {
        while ((a & b) != 0x00) {//check carry bit
            final int x = (a & b) << 1;//same bit has carry
            final int y = (a ^ b);     //different bit
            a = x;
            b = y;
        }
        return a | b;
    }

    public static void main(String[] args) {
        System.out.println(getSum(10000000,10000000));
    }
}
