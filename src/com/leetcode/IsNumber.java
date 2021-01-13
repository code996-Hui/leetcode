package com.leetcode;

public class IsNumber {
    public static void main(String[] args) {

        System.out.println(IsNumber.isNumber("1 1"));
    }

    /**
     * 判断字符串是否是数值
     *
     * @Time 2020.12.02
     */
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
// 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
    public static boolean isNumber(String s) {
        //判断字符串如果为空，则返回false
        if (s == null || s.length() == 0) {
            return false;
            //System.out.println(false);
        }
        //定义标记位
        //定义是否为数字
        boolean isNum = false;
        //定义是否为小数点
        boolean isDot = false;
        //定义是否为E或者e
        boolean isEe = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <='9'){
                //第一个字符为数字
                isNum = true;
            }else if (chars[i] == '.') {
                //看当前字符是否为小数点，小数点前不能出现e和小数点
                if (isDot || isEe) return false;
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                //e之前不能出现e，必须出现数字
                if (isEe || !isNum) return false; //说明是e或者不是数
                isEe = true;
                isNum = false;//重置isNum，排除123e或者123e+的情况,确保e之后也出现数
            } else if (chars[i] == '-' || chars[i] == '+') {
                //+-出现在0位置，或者e后面第一个位置才是合法的
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') return false;

            } else {
                return false;
            }
        }
        return isNum;


    }
}
