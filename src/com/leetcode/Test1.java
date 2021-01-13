package com.leetcode;

/**
 * @author 姚晶辉
 * @Description TODO
 * @date 2020/12/7 18:57
 * @Version 1.0
 */
public class Test1 {
    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为O(n)。
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //测试连续子数组最小和
        int max = getMax(nums);
        System.out.println(max);
        //测试MinStack
        text_MinStack();
    }

    /**
     * 测试MinStackde fangfa
     */
    private static void text_MinStack() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
       // System.out.println(minStack.top());
        System.out.println(minStack.min());

    }

    private static int getMax(int[] nums) {
        //dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
