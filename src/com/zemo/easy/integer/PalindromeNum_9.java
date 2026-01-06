package com.zemo.easy.integer;

public class PalindromeNum_9 {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int num = x;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        PalindromeNum_9 palindromeNum_9 = new PalindromeNum_9();
        System.out.println(palindromeNum_9.isPalindrome(121));
        System.out.println(palindromeNum_9.isPalindrome(-121));
        System.out.println(palindromeNum_9.isPalindrome(10));
    }

}
