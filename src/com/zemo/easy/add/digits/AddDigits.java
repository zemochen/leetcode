package com.zemo.easy.add.digits;

/**
 * @ClassName: AddDigits
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 12/3/15 20:50
 * @Description ${TODO}
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(888888));
    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
