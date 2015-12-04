package com.zemo.jd;

/**
 * @ClassName: DeerApple
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 9/27/15 19:15
 * @Description 1.N（1<=N<=9）个小熊分一堆苹果，
 *              第一只小熊将苹果分成N份，多了一个，
 *              扔掉，然后拿走自己的那一份。第二只熊将剩余的苹果分成N份，
 *              又多了一个，扔掉，然后拿走自己的那一份，第三只.....，直到第N只熊；
 *              问最初的苹果有多少个？
 *
 *              n=2,a = 3;
 *              n=3, a =
 */
public class BeerApple {
    public static void main(String[] args) {
        int n = 9;//熊数
        int a ;     //苹果数
        for (int i = 1; i < Integer.MAX_VALUE; i++) {

        }
    }

    public boolean canShare(int a,int n) {
        if (a % n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int share(int a,int n) {
        if (canShare(a, n)) {
            a = a - (a / n) - 1;
            n = n - 1;
            share(a, n);
        } else {
            return 0;
        }
        return 0;
    }
}
