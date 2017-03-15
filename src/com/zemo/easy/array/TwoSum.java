package com.zemo.easy.array;

/**
 * @ClassName: TwoSum
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 14/03/2017 20:51
 * @Description Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (b == a) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int[] result = new int[2];

        result = twoSum.twoSum(nums, 26);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
