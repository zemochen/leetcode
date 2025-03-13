package com.zemo.easy.array;

import java.util.*;

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

        int[] nums = {2,5,1,5,6,3,3};
        int[] result = new int[2];

        result = twoSum.twoSum(nums, 8);

        System.out.println();

        int count = 0;
        int total = 4;
        for (int i = 0; i < total; i++) {
            for (int j = i+1; j < total; j++) {
                count++;
            }
        }
        System.out.println(count);

        for (List<Integer> integers : findAllGroup(nums, 8)) {
            System.out.println(integers.toString());
        }
    }
    public static List<List<Integer>> findAllGroup(int[] list,int sum){

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0;i<list.length;i++){
            Integer a = list[i];
            if(map.containsKey(a)){
                int count = map.get(a);
                map.put(a,count+1);
            }else{
                map.put(a,1);
            }
        }
        for (Integer integer : map.keySet()) {
            if(map.containsKey(sum-integer)){
                for(int j = 0;j< map.get(integer);j++){
                    result.add(appendResult(integer, 8 - integer));
                }
                map.put(sum-integer,0);
            }
        }

        return result;
    }
    public static List<Integer> appendResult(int a, int b) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(a);
        result.add(b);
        return result;
    }
}
