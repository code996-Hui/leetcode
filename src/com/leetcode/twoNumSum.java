package com.leetcode;

import java.lang.reflect.Method;

/**
 * @author 姚晶辉
 * @Description TODO
 * @date 2020/12/21 10:41
 * @Version 1.0
 */
public class twoNumSum {
    public static void main(String[] args) {
        int [] sums = new int[]{2, 7, 11, 15};
        int[] arr=   method(sums,9);
        for (int i : arr) {
            System.out.printf("%d",i);
        }
    }
    public static int[] method(int [] nums,int target){
        int[] arr = new int[2];
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if ((arr[i]+arr[j])==target){
                    arr[0]=i;
                    arr[1]=j;
                    return arr;
                }

            }
        }
        return arr;
    }
}
