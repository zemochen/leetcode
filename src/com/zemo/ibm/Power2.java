package com.zemo.ibm;

import java.util.ArrayList;
import java.util.List;

/**
 * given an array of integers,determine whether each is a power of 2 where powers of 2 are [1,2,4,8,16,32...]
 * For each integer evaluated, append to an array a value of 1 if the number is a power of 2 or 0 otherwise
 * Example:
 * arr=[1,3,8,12,16]
 * return array is [1,0,1,0,1]...
 */
public class Power2 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(5);
        arr.add(7);
        List<Integer> result = isPowerOf2(arr);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static List<Integer> isPowerOf2(List<Integer> arr) {

        if (arr == null || arr.isEmpty()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (Integer i : arr) {
            if (i>=0&& (i&(i-1))==0)  {
                result.add(1);
            } else {
                result.add(0);
            }
        }
        return result;
    }

}
