package com.zemo.easy.countandsay;

/**
 * @ClassName: CountAndSay
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 11/18/14 11:50
 * @Description The count-and-say sequence is the sequence of integers beginning as follows:
 *              1, 2,  3 ,  4  ,   5
 *              1, 11, 21, 1211, 111221, ...
 *              1 is read off as "one 1" or 11.
 *              11 is read off as "two 1s" or 21.
 *              21 is read off as "one 2, then one 1" or 1211.
 *              Given an integer n, generate the nth sequence.
 *              Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuffer say = new StringBuffer();
        if (n != 1){
            int count = 0;
            String nString = countAndSay(n - 1);
            char temp = nString.charAt(0);
            for (int i = 0; i < nString.length(); i++) {
                if (nString.charAt(i) == temp) {
                    count++;
                } else {
                    say.append(count);
                    say.append(temp);
                    count = 1;
                    temp = nString.charAt(i);
                }
            }
            say.append(count);
            say.append(temp);
        }else {
            say.append(1);
        }
        return say.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(11));
    }
}
