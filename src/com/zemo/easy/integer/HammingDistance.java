package com.zemo.easy.integer;

/**
 * @ClassName: HammingDistance
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 20/03/2017 20:49
 * @Description The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int diffInt = x ^ y;
        int count = 0;
        while (diffInt >= 1) {

            count += diffInt % 2 == 1 ? 1 : 0;
            diffInt /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(1, 4));
    }
}
