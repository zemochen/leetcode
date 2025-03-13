package com.zemo.easy.array;

/**
 * @ClassName: FindSingle
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2021/11/17
 * @Description 一个数组中,有一个数字只出现奇数次,其他数都出现偶数次,使用时间复杂度O(N),空间复杂度O(1) 的算法找出
 */
public class FindSingle {

    //只有一个数出现奇数次
    public static void onlyOneFind(int[] arr) {
        int res = 0;
        for (int j : arr) {
            res ^= j;
        }
        System.out.println("once:"+res);

    }
    //有两个数出现奇数次
    public static void onlyTwoFind(int[] arr) {
        //a^b
        int res1 = 0;
        //a or b
        int res2 = 0;
        //此时res1 = a^b;
        for (int j : arr) {
            res1 ^= j;
        }
        // res1 != 0
        //a^b 必有一个二进制位是1,取出第一位1(决定他俩不同的第一个二进位)
        int diffBin = res1 & (~res1 + 1);
        for (int i : arr) {
            //取出某位不同的只出现一次的数(a or b)
            if ((i & diffBin) == 0) {
                res2 ^= i;
            }
        }
        System.out.println("twice:");
        System.out.println(res2);
        System.out.println(res1 ^ res2);
    }
    public static void main(String[] args) {
        int[] arrOnce = {1, 2, 1, 3, 4, 1, 2, 4, 1};
        onlyOneFind(arrOnce);
        int[] arrTwice = {1, 2, 1, 3, 4, 1, 2, 4, 1,5};

        onlyTwoFind(arrTwice);

    }
}
