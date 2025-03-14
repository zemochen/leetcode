package com.zemo.easy.integer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target-num)) {
                return new int[]{map.get(target - num), i};
            } else {
                map.put(num, i);
            }
        }

        return null;
    }

}
