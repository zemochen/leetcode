package com.zemo.easy.string;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JewelsAndStones_771
 * @author: superzemo
 * @email: zemochen@gmail.com
 * @Date 2018/7/17 10:55 PM
 * @Description You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * * S and J will consist of letters and have length at most 50.
 * * The characters in J are distinct.
 */
public class JewelsAndStones_771 {

    public static void main(String[] args) {
        int[] a = new int['z'];

        System.out.println(a.length);
        String J = "z", S = "ZZ";
        System.out.println(numJewelsInStones2(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> buckets = new HashMap<Character, Integer>();
        for (char c : S.toCharArray()) {
            if (buckets.get(c) == null) {
                buckets.put(c, 1);
            } else {
                buckets.put(c, buckets.get(c) + 1);
            }
        }

        int jewelsCount = 0;
        for (char c : J.toCharArray()) {
            jewelsCount += buckets.get(c) == null ? 0 : buckets.get(c);
        }
        return jewelsCount;
    }

    public static int numJewelsInStones2(String J, String S) {
        int[] stonesBuckets = new int['z' + 1];

        for (char c : J.toCharArray()) {
            stonesBuckets[c] = 1;
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            count += stonesBuckets[c];
        }
        return count;
    }

}
