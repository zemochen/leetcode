package com.zemo.easy.string;

import java.util.Stack;

/**
 * @ClassName: ReverseString
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 21:20
 * @Description Write a function that takes a string as input and returns the string reversed.
 *          Example:
 *              Given s = "hello", return "olleh".
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString3("123"));
    }

    // this method is faster than reverseString2
    public String reverseString1(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //this method is too slowly
    public String reverseString3(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < array.length; i++)
            stack.push(array[i]);

        String reverse = "";
        for (int i = 0; i < array.length; i++)
            reverse += stack.pop();

        return reverse;
    }

    //this is the fastest
    public String reverseString4(String s) {
        char[] array=s.toCharArray();
        int start = 0;
        int end = array.length-1;
        while(start<end){
            char temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
        return new String(array);
    }
}
