package com.zemo.medium;

/**
 * @ClassName: MaxSameString_1062
 * @author: zemo
 * @email: zeming.chen@dmall.com
 * @Date 10/22/24 11:10 AM
 * @Description
 */
public class LongestCommonSubsequence_1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int l1 = text1.length();
        int l2 = text2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return  dp[l1][l2] ;


    }

    public static void main(String[] args) {
        String text1 = "bl";
        String text2 = "yby";
        System.out.println("Longest common subsequence is: " + longestCommonSubsequence(text1, text2));

    }
}
