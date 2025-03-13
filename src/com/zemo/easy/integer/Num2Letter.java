package com.zemo.easy.integer;

/**
 * @ClassName: Num2Letter
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2022/9/10
 * @Description convert Number to Letter start with 1 input a number  output Letter, for example: 1->A   2->B 25->AA
 * 26->AB
 */
public class Num2Letter {

    public static void main(String[] args) {
        num2Letter("A", 1);
        System.out.println(num2Letter("", 2));
        System.out.println(num2Letter("", 26));
        System.out.println(num2Letter("", 27));
        System.out.println(letter2Num("A"));
        System.out.println(letter2Num("AA"));
        System.out.println(letter2Num("AAA"));
        System.out.println("---------");

        String res = num2Letter("BY", 34-1);
        System.out.println(res);
        System.out.println(letter2Num(res));

        /*for (int i = 1; i <= 703; i++) {
            System.out.println(i + num2Letter("", i));
        }*/
    }

    public static String num2Letter(String start, int num) {
        String res = "";
        if (start != null && start.trim().length() > 0) {
            num += letter2Num(start);
        }
        while (num > 0) {
            num -= 1;
            char firstLetter = (char) ('A' + num  % 26);
//            System.out.println(firstLetter);
            res = firstLetter + res;
            num /= 26;
        }
        return res;
    }

    public static long letter2Num(String letters) {
        if (letters == null || letters.trim().length() <= 0) {
            return -1;
        }
        long res = 0;
        char[] chars = letters.toCharArray();

        for (int i =  0; i < chars.length; i++) {
            int c = chars[i]-'A'+1;
            if (c <= 0 || c >= 26) {
                continue;
            }
            res = res*26+c;
        }

        return res;
    }
}
