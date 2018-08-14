package com.zemo.easy.array;

/**
 * @ClassName: IntersectionArray
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/18/16 22:24
 * @Description Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionArray {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 == n2) {
                    for (int i : intersection) {

                    }
                }
            }
        }
        return null;
    }
}
