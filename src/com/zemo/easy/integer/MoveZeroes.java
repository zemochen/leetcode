package com.zemo.easy.integer;

/**
 * @ClassName: MoveZeroes
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/16/16 21:01
 * @Description ${TODO}
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int zeroCount = 0, index = 0;
        for (int i = 0; nums != null && i < nums.length && index < nums.length; index++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                zeroCount++;

            } else {
                i++;
            }
        }
        while (zeroCount > 0) {
            nums[nums.length - zeroCount--] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }

        while (zeroCount > 0) {
            nums[nums.length - zeroCount--] = 0;
        }
    }

    public static void main(String[] args) {
        int nums[] = {0,2,1,0,0,3};
        moveZeroes2(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
