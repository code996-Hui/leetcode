package com.leetcode;

import java.util.LinkedList;

/**
 * @author 姚晶辉
 * @Description 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 *              调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @date 2020/12/10 10:13
 * @Version 1.0
 */
public class MinStack {
    //region 自己写的
  /*  *//** initialize your data structure here. *//*
   private LinkedList<Integer> linkedList =  null;
   private LinkedList<Integer> minList=null;
   private int min_stack;

    public MinStack() {
        if (linkedList==null){
            linkedList=new LinkedList();
            minList=new LinkedList<>();
        }
        min_stack=Integer.MAX_VALUE;
    }

    public void push(int x) {
        //只要曾经是最小值的都要放进去
        if (x<=min_stack){
            minList.addLast(min_stack);
            min_stack=x;
        }
        linkedList.addLast(x);

    }

    public void pop() {
        if (linkedList==null||linkedList.size()<=0){
            new RuntimeException();
        }
        if (linkedList.getLast()==min_stack){
            min_stack = minList.removeLast();
        }
        linkedList.removeLast();
    }

    public int top() {
        if (linkedList==null||linkedList.size()<=0){
            new RuntimeException();
        }
        return linkedList.getLast();
    }

    public int min() {
        if (linkedList==null||linkedList.size()<=0){
            new RuntimeException();
        }
        return min_stack;
    }*/
    //endregion


    //别人写的
    private int[] data; // 栈数据
    private int maxSize; // 最大长度
    private int top; // 栈顶指针（下标）
    private int min; // 最小值

    // 构造函数
    public MinStack() {
        // 设置默认值
        maxSize = 10000;
        data = new int[maxSize];
        top = -1;
        min = Integer.MAX_VALUE;
    }

    // 入栈（添加元素）
    public void push(int x) {
        if (min >= x) {
            // 遇到了更小的值，记录原最小值（入栈）
            data[++top] = min;
            min = x;
        }
        // 当前值入栈
        data[++top] = x;
    }

    // 出栈（移除栈顶元素）
    public void pop() {
        if (min == data[top]) {
            min = data[--top]; // 拿到原最小值，并（将原最小值）出栈
        }
        --top; // 出栈
    }

    // 查找栈顶元素
    public int top() {
        return data[top];
    }

    // 查询最小值
    public int min() {
        return min;
    }

}
