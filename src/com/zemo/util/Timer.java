package com.zemo.util;

import java.util.Date;
/**
 * @ClassName: Timer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 11/17/14 22:28
 * @Description ${TODO}
 */
public class Timer{
    public Date start;
    public Timer() {
        this.start = new Date();
    }
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Long useTime(Date now) {
        System.out.println(this.start.getTime() - now.getTime());
        return this.start.getTime() - now.getTime();
    }
}
