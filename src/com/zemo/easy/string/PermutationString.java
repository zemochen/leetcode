package com.zemo.easy.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PermutationString
 * @author: zeming.chen
 * @email: zeming.chen@dmall.com
 * @Date 12/3/2022
 * @Description 给出一个字符串，求所有子集
 */
public class PermutationString {

    public static List<String> permuatation(String str) {
        List<String> res = new ArrayList<>();

        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        process(chars, 0, res);
        return res;
    }

    /**
     * 从第i位 开始确认位置上可能的字母 chars[i...] 都有机会来到i位置
     *
     * @param chars
     * @param i
     * @param ans
     */
    private static void process(char[] chars, int i, List<String> ans) {
        //当递归到最后一位，就只有一种可能，直接返回
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1, ans);
            //交换生成结果后，需要交换回来，还原成原顺序
            swap(chars, i, j);
        }
    }

    /**
     * 把chars中 target 位置与 from位置交换
     * @param chars
     * @param target
     * @param from
     */
    private static void swap(char[] chars, int target, int from) {
        char tmp = chars[target];
        chars[target] = chars[from];
        chars[from] = tmp;
    }


    public static void main(String[] args) {
        List<String> abcd = permuatation("abc");
        abcd.forEach(System.out::println);
    }
}
