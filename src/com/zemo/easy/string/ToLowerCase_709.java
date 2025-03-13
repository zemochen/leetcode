package com.zemo.easy.string;

/**
 * @ClassName: ToLowerCase_709
 * @author: superzemo
 * @email: zemochen@gmail.com
 * @Date 2018/7/18 11:23 PM
 * @Description Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Example 1:
 *          Input: "Hello"
 *          Output: "hello"
 * Example 2:
 *          Input: "here"
 *          Output: "here"
 * Example 3:
 *          Input: "LOVELY"
 *          Output: "lovely"
 */
public class ToLowerCase_709 {

    public static String toLowerCase(String str) {
        if (str == null) return null;
        char[] letters = str.toCharArray();
        char[] lowerLetters = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] >= 65 && letters[i] <= 90) {
                lowerLetters[i] = (char) (letters[i] + 32);
            } else {
                lowerLetters[i] = letters[i];
            }
        }
        return new String(lowerLetters);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase(null));
    }
}
