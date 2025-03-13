package com.zemo.hard;

/**
 * @ClassName: NQueen
 * @author: zeming.chen
 * @email: zeming.chen@dmall.com
 * @Date 12/12/2022
 * @Description
 */
public class NQueen {

    /**
     *
     * @param limit 皇后总数
     * @param colLim 列限制，二进制 1表示此列已有
     * @param lLim 左斜线限制，二进制，1表示做些先上有
     * @param rLim 又斜线限制，二进制
     * @return 共有X中摆法
     */
    public static int process(int limit, int colLim, int lLim, int rLim) {

        if (colLim == limit) {
            return 1;
        }

        int totalLim = colLim | lLim | rLim;
        //~totalLim 表示当前行还可以放置的位置  与 limit取余去掉左侧的 多余的1
        int pos = limit & (~totalLim);
        int mostRight = 0;
        int res = 0;
        while (pos != 0) {
            //每次取出最右侧的1 尝试 自己与自己取反+1 就去除最右侧1

            mostRight = pos & (~pos + 1);
            //需要去掉最右侧1，准备下次尝试
            pos = pos - mostRight;
            //加上这次的列限制
            int nextColLim = colLim | mostRight;
            //上次左斜线限制加上本次，向左移动1位就是下次的左斜线
            int nextLLim = (lLim | mostRight) << 1;
            //上次右斜线限制加上本次，向右移动1位就是下次的右斜线
            int nextRLim = (rLim | mostRight) >>> 1;

            res += process(limit, nextColLim, nextLLim, nextRLim);
        }
        return res;
    }

    public static void main(String[] args) {
        int limit = 5;
        int colLim = 0;
        int lLim = 0;
        int rLim = 0;
        int res = process(limit, colLim, lLim, rLim);
        System.out.printf(limit+"个皇后，共有："+res+"种方法");
    }
}
